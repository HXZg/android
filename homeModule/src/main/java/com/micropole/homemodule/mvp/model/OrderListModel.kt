package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.entity.OrderListBean
import com.micropole.homemodule.mvp.constract.OrderListConstract
import com.micropole.homemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       OrderListModel
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/24 15:49
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderListModel : OrderListConstract.Model() {
    override fun orderList(token: String, lat: String, lng: String, staut: Int, page: Int): Observable<BaseResponseEntity<List<OrderListBean>>> {
        return AppApi.Api<AppService>().orderList(token, lat, lng, staut, page)
    }
}