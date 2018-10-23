package com.xx.baseutilslibrary.network.gson;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import com.xx.baseutilslibrary.entity.BaseResponseEntity;
import com.xx.baseutilslibrary.entity.BaseResponseStatusEntity;
import com.xx.baseutilslibrary.network.exception.ApiFaileException;
import com.xx.baseutilslibrary.network.exception.InvalidLongTokenException;
import com.xx.baseutilslibrary.network.exception.InvalidShortTokenException;
import com.xx.baseutilslibrary.network.exception.TokenInvalidException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * HGsonConverterFactory
 * 沉迷学习不能自拔
 * Describe：
 * Created by 雷小星🍀 on 2018/5/4 11:12.
 */

public class XxGsonConverterFactory extends Converter.Factory {

    private final Gson gson;

    private XxGsonConverterFactory(Gson gson) {
        this.gson = gson;
    }

    public static XxGsonConverterFactory create() {
        return create(new Gson());
    }

    public static XxGsonConverterFactory create(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        return new XxGsonConverterFactory(gson);
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new XxGsonResponseBodyConverter<>(adapter);
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new XxGsonRequestBodyConverter<>(adapter);
    }

    private class XxGsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
        private final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
        private final Charset UTF_8 = Charset.forName("UTF-8");

        private final TypeAdapter<T> adapter;

        XxGsonRequestBodyConverter(TypeAdapter<T> adapter) {
            this.adapter = adapter;
        }

        @Override
        public RequestBody convert(@NonNull T value) throws IOException {
            Buffer buffer = new Buffer();
            Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
            JsonWriter jsonWriter = gson.newJsonWriter(writer);
            adapter.write(jsonWriter, value);
            jsonWriter.close();
            return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
        }
    }

    private class XxGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
        private final TypeAdapter<T> adapter;

        XxGsonResponseBodyConverter(TypeAdapter<T> adapter) {
            this.adapter = adapter;
        }

        @Override
        public T convert(@NonNull ResponseBody value) throws IOException {
            try {
                String valueString = value.string();
                valueString = valueString.replaceAll(":null", ":\"\"");
                BaseResponseStatusEntity baseResponseEntity = gson.fromJson(valueString, BaseResponseStatusEntity.class);
                if (baseResponseEntity == null || TextUtils.isEmpty(baseResponseEntity.getStatus())) {
                    throw new ApiFaileException("服务器返回数据异常");
                }
//                else if (LONG_TOKEN_INVALID.equals(baseResponseEntity.getCode()) || LONG_TOKEN_INVALID_.equals(baseResponseEntity.getCode())) {
//                    //长token过期,重新登录
//                    throw new InvalidLongTokenException();
//                }
//                else if (SHORT_TOKEN_INVALID.equals(baseResponseEntity.getCode()) || SHORT_TOKEN_INVALID_.equals(baseResponseEntity.getCode())||Constants.LONG_TOKEN_INVALID.equals(baseResponseEntity.getCode()) || Constants.LONG_TOKEN_INVALID_.equals(baseResponseEntity.getCode())) {
//                    //短token过期,刷新token
//                    valueString = valueString.replace("[]", "{}");
//                    return adapter.fromJson(valueString);
//                }
                if (!baseResponseEntity.getStatus().equals(BaseResponseEntity.Companion.getSUCCESS())) {
                    //接口返回失败时,不继续解析data
                    if (baseResponseEntity.getCode().equals("333")){ //短token过期
                        throw new InvalidShortTokenException(baseResponseEntity.getMsg());
                    }else if (baseResponseEntity.getCode().equals("444")){  //长token过期
                        throw new InvalidLongTokenException(baseResponseEntity.getMsg());
                    }else {
                        throw new ApiFaileException(
                                !TextUtils.isEmpty(baseResponseEntity.getMsg()) ? baseResponseEntity.getMsg() : "失败");
                    }
                }
                //前置操作正常,返回解析内容
                return adapter.fromJson(valueString);
            } finally {
                value.close();
            }
        }
    }
}
