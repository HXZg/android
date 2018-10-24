package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.mvp.constract.ReportHouseConstract
import com.micropole.homemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       ReportHouseModel
 * @Description     举报
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/24 13:50
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ReportHouseModel : ReportHouseConstract.Model() {
    override fun reportHotel(token: String, lat: String, lng: String, h_id: String, content: String): Observable<BaseResponseEntity<Any>> {
        return AppApi.Api<AppService>().reportHotel(token, lat, lng, h_id, content)
    }
}