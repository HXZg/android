package com.micropole.homeword.util.network;

import com.micropole.homemodule.entity.LandlordBean;
import com.micropole.homeword.entity.PayBean;
import com.micropole.homeword.entity.ShareHotlBean;
import com.xx.baseutilslibrary.entity.BaseResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * @ClassName Appservice
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/26 16:01
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public interface Appservice {

    @FormUrlEncoded
    @POST("Userorder/order_pay")
    Observable<BaseResponseEntity<PayBean>> orderPay(@Header("token")String token, @Header("lat")String lat, @Header("lng")String lng,
                                                     @Field("or_id") String or_id, @Field("pay_type") int type);

    @FormUrlEncoded
    @POST("Index/hotel_share")
    Observable<BaseResponseEntity<ShareHotlBean>> share(@Header("token")String token, @Header("lat")String lat, @Header("lng")String lng,
                                                        @Field("h_id") String h_id);
}
