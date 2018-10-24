package com.micropole.minemodule.network;

import com.xx.baseutilslibrary.entity.BaseResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @ClassName AppService
 * @Author Xiaoguangfei
 * @Sign 。。。
 * @Date 2018/10/23 17:33
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public interface AppService {

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("login/reg")
    Observable<BaseResponseEntity<Object>> register(@Field("phone") String phone, @Field("pwd") String pwd, @Field("yzm") String yzm,@Field("nickname")String nickname);
}
