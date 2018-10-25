package com.micropole.minemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.minemodule.mvp.contract.*
import com.micropole.minemodule.network.AppService

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class TripIntraModel:TripIntraContract.Model {
    override fun getTripList(token: String, lat: String, lng: String, page: String) = AppApi.Api<AppService>().getTripList(token, lat, lng, page)
}