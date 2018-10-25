package com.micropole.loginmodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.loginmodule.bean.Code
import com.micropole.loginmodule.mvp.contract.ForgetContract
import com.micropole.loginmodule.mvp.contract.LoginContract
import com.micropole.loginmodule.mvp.contract.RegisterContract
import com.micropole.loginmodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:
 */
class FotgetModel:ForgetContract.Model {
    override fun getCode(phone: String)=AppApi.Api<AppService>().getCode(phone)



    override fun forget(phone: String, pwd: String, code: String)=AppApi.Api<AppService>().forgetPW(phone,pwd,code)
}