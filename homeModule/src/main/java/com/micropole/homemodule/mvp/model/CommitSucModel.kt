package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.entity.LandlordBean
import com.micropole.homemodule.entity.OrderDetailBean
import com.micropole.homemodule.mvp.constract.CommitSucConstract
import com.micropole.homemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       CommitSucModel
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/29 9:57
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CommitSucModel : CommitSucConstract.Model() {
    override fun getUserPhone(token: String, lat: String, lng: String, h_id: String): Observable<BaseResponseEntity<LandlordBean>> {
        return AppApi.Api<AppService>().getUserPhone(token, lat, lng, h_id)
    }

    override fun orderDetail(token: String, lat: String, lng: String, orderId: String): Observable<BaseResponseEntity<OrderDetailBean>> {
        return AppApi.Api<AppService>().orderDetail(token, lat, lng, orderId)
    }
}