package com.micropole.minemodule.network;

import com.micropole.minemodule.bean.ImageViewUri;
import com.micropole.minemodule.bean.RefreshTokenBean;
import com.micropole.minemodule.bean.Trip;
import com.micropole.minemodule.bean.UserInfo;
import com.xx.baseutilslibrary.entity.BaseResponseEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
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

    /**
     * 用户中心
     */
    @POST("User/index")
    Observable<BaseResponseEntity<UserInfo>> getInfo(@Header("token") String token, @Header("lat") String lat, @Header("lng") String lng);

    /**
     * 刷新token
     * @param token
     * @return
     **/
    @FormUrlEncoded
    @POST("login/get_short_token")
    Observable<BaseResponseEntity<RefreshTokenBean>> refreshToken(@Field("long_token") String token);
    /**
     * 图片上传
     * @return
             **/
    @FormUrlEncoded
    @POST("Index/imgup")
    Observable<BaseResponseEntity<ImageViewUri>> setImage(@Field("img") String img);
    /**
     * 修改用户昵称或者修改性别或修改用户头像
     * @param token
     * @return
     **/
    @FormUrlEncoded
    @POST("User/update_user")
    Observable<BaseResponseEntity<Object>> setInfo(@Header("token") String token, @Header("lat") String lat, @Header("lng") String lng,@Field("nickname")String nickname,@Field("user_sex")String user_sex,@Field("user_img")String user_img);
    /**
     * 用户旅游基金记录列表
     */
    @FormUrlEncoded
    @POST("user/user_integral")
    Observable<BaseResponseEntity<List<Trip>>> getTripList(@Header("token") String token, @Header("lat") String lat, @Header("lng") String lng, @Field("page")String page);
    /**
     *房东申请
     */
    @FormUrlEncoded
    @POST("user/hotel_apply")
    Observable<BaseResponseEntity<Object>> beHouse(@Header("token") String token, @Header("lat") String lat, @Header("lng") String lng, @Field("a_nickname")String a_nickname,@Field("a_idcard")String a_idcard,@Field("a_front_idcard")String a_front_idcard,@Field("a_verso_idcard")String a_verso_idcard);

}
