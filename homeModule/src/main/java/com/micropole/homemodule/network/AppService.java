package com.micropole.homemodule.network;

import com.micropole.homemodule.entity.HomeBean;
import com.xx.baseutilslibrary.entity.BaseResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * @ClassName AppService
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/22 17:33
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public interface AppService {

    /**
     * 首页
     */
    @POST("Index/index")
    Observable<BaseResponseEntity<HomeBean>> homeData(@Header("token")String token, @Header("lat")String lat, @Header("lng")String lng);
}
