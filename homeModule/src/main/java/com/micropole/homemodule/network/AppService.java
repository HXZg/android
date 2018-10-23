package com.micropole.homemodule.network;

import com.micropole.homemodule.entity.HomeBean;
import com.micropole.homemodule.entity.SearchBean;
import com.micropole.homemodule.entity.SearchStyleBean;
import com.xx.baseutilslibrary.entity.BaseResponseEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
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
    Observable<BaseResponseEntity<HomeBean>> homeData(@Header("lat")String lat, @Header("lng")String lng);

    /**
     * 获取搜索风格
     * @return
     */
    @POST("Hotel/hotel_search_get_area")
    Observable<BaseResponseEntity<List<SearchStyleBean>>> getStyleData(@Header("lat")String lat, @Header("lng")String lng);

    /**
     * 搜索
     * @param styleId  风格id
     * @param type     排序类型
     * @param page     页数
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param num       人数
     * @return
     */
    @POST("Hotel/hotel_search")
    Observable<BaseResponseEntity<SearchBean>> getSearchData(@Header("lat")String lat, @Header("lng")String lng,
                                                             @Field("area_id") String styleId, @Field("type_deac") int type, @Field("page") int page,
                                                             @Field("start_time") String startTime, @Field("end_time") String endTime, @Field("people_number") String num);
}
