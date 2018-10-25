package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.entity.BookingBean
import com.micropole.homemodule.entity.CommitOrderBean
import com.micropole.homemodule.mvp.constract.FillOrderConstract
import com.micropole.homemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       FillOrderModel
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 17:03
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class FillOrderModel : FillOrderConstract.Model(){
    override fun commitOrder(token: String, lat: String, lng: String, h_id: String, startTime: String, endTime: String, num: Int, balance: Int, nickName: String, idCard: String, phone: String): Observable<BaseResponseEntity<CommitOrderBean>> {
        return AppApi.Api<AppService>().commitOrder(token, lat, lng, h_id, startTime, endTime, num, balance, nickName, idCard, phone)
    }

    override fun bookingHouse(token: String, lat: String, lng: String, h_id: String, startTime: String, endTime: String, num: Int, balance: Int): Observable<BaseResponseEntity<BookingBean>> {
        return AppApi.Api<AppService>().bookingHouse(token, lat, lng, h_id, startTime, endTime, num, balance)
    }
}