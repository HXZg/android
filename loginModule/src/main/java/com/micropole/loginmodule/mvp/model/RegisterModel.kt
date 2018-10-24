package com.micropole.loginmodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.loginmodule.mvp.contract.RegisterContract
import com.micropole.loginmodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:
 */
class RegisterModel:RegisterContract.Model {
    override fun getCode(phone: String)=AppApi.Api<AppService>().getCode(phone)

    override fun register(phone: String, pwd: String, yzm: String, nickname: String) =
            AppApi.Api<AppService>().register(phone,pwd,yzm,nickname)


}