package com.micropole.minemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.minemodule.bean.Share
import com.micropole.minemodule.mvp.contract.InviteContract
import com.micropole.minemodule.mvp.contract.MineContract
import com.micropole.minemodule.mvp.contract.SettingContract
import com.micropole.minemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class InviteModel:InviteContract.Model {
    override fun getShare(token: String, lat: String, lng: String)=AppApi.Api<AppService>().getShare(token, lat, lng)
}