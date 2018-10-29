package com.micropole.minemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.minemodule.bean.Code
import com.micropole.minemodule.mvp.contract.MineContract
import com.micropole.minemodule.mvp.contract.SettingContract
import com.micropole.minemodule.mvp.contract.SettingPhoneContract
import com.micropole.minemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class SettingPhoneModel: SettingPhoneContract.Model {
    override fun setPhone( token: String, lat: String, lng: String, old_user_phone: String, new_user_phone: String, new_code: String, old_code: String)=
            AppApi.Api<AppService>().setPhone(token,lat,lng,old_user_phone,new_user_phone,new_code,old_code)

    override fun getCode(phone: String)=AppApi.Api<AppService>().getCode(phone)
}