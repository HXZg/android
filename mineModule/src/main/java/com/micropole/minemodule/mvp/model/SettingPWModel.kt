package com.micropole.minemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.minemodule.mvp.contract.SettingPWContract
import com.micropole.minemodule.network.AppService

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class SettingPWModel:SettingPWContract.Model {
    override fun getCode(phone: String)=AppApi.Api<AppService>().getCode(phone)

    override fun setPW(token: String, lat: String, lng: String, user_phone: String, code: String, new_user_pwd: String)=
            AppApi.Api<AppService>().setPW(token,lat,lng,user_phone,code,new_user_pwd)
}