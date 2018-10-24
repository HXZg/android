package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.entity.OrderDetailBean
import com.micropole.homemodule.mvp.constract.OrderDetailConstract
import com.micropole.homemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       OrderDetailModel
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/24 17:01
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderDetailModel : OrderDetailConstract.Model(){
    override fun orderDetail(token: String, lat: String, lng: String, orderId: String): Observable<BaseResponseEntity<OrderDetailBean>> {
        return AppApi.Api<AppService>().orderDetail(token, lat, lng, orderId)
    }
}