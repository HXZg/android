package com.micropole.minemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.minemodule.mvp.contract.MineContract
import com.micropole.minemodule.network.AppService

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class MineModel:MineContract.Model {
    override fun getInfo(token: String, lat: String, lng: String)=AppApi.Api<AppService>().getInfo(token,lat,lng)
}