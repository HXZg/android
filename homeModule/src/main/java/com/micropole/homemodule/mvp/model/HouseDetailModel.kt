package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.entity.HouseDetailBean
import com.micropole.homemodule.entity.LandlordBean
import com.micropole.homemodule.mvp.constract.HouseDetailConstract
import com.micropole.homemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       HouseDetailModel
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/23 19:04
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HouseDetailModel : HouseDetailConstract.Model() {
    override fun getUserPhone(token: String, lat: String, lng: String, h_id: String): Observable<BaseResponseEntity<LandlordBean>> {
        return AppApi.Api<AppService>().getUserPhone(token, lat, lng, h_id)
    }

    override fun collectHouse(token: String, lat: String, lng: String, h_id: String): Observable<BaseResponseEntity<Any>> {
        return AppApi.Api<AppService>().collectHotel(token, lat, lng, h_id)
    }

    override fun getHouseDetail(token: String, lat: String, lng: String, h_id: String): Observable<BaseResponseEntity<HouseDetailBean>> {
        return AppApi.Api<AppService>().getHouseDetail(token, lat, lng, h_id)
    }
}