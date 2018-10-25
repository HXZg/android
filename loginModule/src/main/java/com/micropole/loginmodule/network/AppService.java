package com.micropole.loginmodule.network;

import com.micropole.loginmodule.bean.Code;
import com.micropole.loginmodule.bean.Login;
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
    Observable<BaseResponseEntity<Object>> register(@Field("phone") String phone, @Field("pwd") String pwd, @Field("yzm") String yzm, @Field("nickname") String nickname);
    /**
     * 发送验证码
     */
    @FormUrlEncoded
    @POST("login/sendSMS")
    Observable<BaseResponseEntity<Code>> getCode(@Field("phone") String phone);
    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("login/login")
    Observable<BaseResponseEntity<Login>> login(@Field("phone") String phone,@Field("sign") String sign);
/**
     * 忘记密码
     */
    @FormUrlEncoded
    @POST("login/forget_passwd")
    Observable<BaseResponseEntity<Object>> forgetPW(@Field("phone") String phone,@Field("pwd") String pwd,@Field("code")String code);



}
