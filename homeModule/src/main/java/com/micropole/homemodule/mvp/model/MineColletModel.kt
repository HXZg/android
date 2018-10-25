package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.entity.SearchBean
import com.micropole.homemodule.mvp.constract.MineColletConstract
import com.micropole.homemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       MineColletModel
 * @Description     收藏，足迹
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 14:32
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineColletModel : MineColletConstract.Model() {
    override fun footList(token: String, lat: String, lng: String, page: Int): Observable<BaseResponseEntity<SearchBean>> {
        return AppApi.Api<AppService>().footList(token, lat, lng, page)
    }

    override fun collectList(token: String, lat: String, lng: String, page: Int): Observable<BaseResponseEntity<SearchBean>> {
        return AppApi.Api<AppService>().collectList(token, lat, lng, page)
    }
}