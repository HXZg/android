package com.micropole.baseapplibrary.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.xx.baseutilslibrary.network.gson.XxGsonConverterFactory
import com.xx.baseutilslibrary.network.retrofit.Retrofit2Manager
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

/**
 * @ClassName       AppApi
 * @Description     network
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/16 16:04
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class AppApi {


    private var api: AppService? = null
    private var mApiSign: String? = null

    fun Api(): AppService {
        if (api == null) {
            val okHttpClient = Retrofit2Manager
                    .instance
                    .okHttpClient!!
                    .newBuilder()
                    .addNetworkInterceptor(StethoInterceptor())
                    .addInterceptor { chain ->
                        val oldRequest = chain.request()

                        val httpUrl = oldRequest.url()
                                .newBuilder()
                                .build()

                        val newRequest = oldRequest.newBuilder()
                                /*.addHeader("device",Constants.getKeyDeviceId())*/
                                /*.addHeader("language", "zh_cn")*/
                                /*.addHeader("apisign", getApiSignHeader())*/
                                .url(httpUrl)
                                .build()
                        chain.proceed(newRequest)
                    }
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//添加网络日志
                    .build()


            Retrofit2Manager
                    .instance
                    .okHttpClient = okHttpClient

            //设置新的Retrofit
            val retrofit = Retrofit.Builder()
                    .baseUrl(Retrofit2Manager.instance.apiConfigProvider!!.apiBaseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(XxGsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            Retrofit2Manager.instance.retrofit = retrofit

            api = Retrofit2Manager
                    .instance
                    .createApi(AppService::class.java!!)
        }
        return api!!
    }

    /* public static String getApiSignHeader() {
        if (Constants.getToken() != null) {
            return Constants.getToken().getSign_api();
        }
        return "123";
    }*/

    fun setApiSignHeader(apiSign: String) {
        mApiSign = apiSign
    }

    /**
     * 置空,使下次请求时重新获取配置
     */
    fun resetApi() {
        api = null
    }

}