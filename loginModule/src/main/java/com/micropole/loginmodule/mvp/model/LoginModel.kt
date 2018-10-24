package com.micropole.loginmodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.loginmodule.bean.Login
import com.micropole.loginmodule.mvp.contract.LoginContract
import com.micropole.loginmodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:
 */
class LoginModel:LoginContract.Model {
    override fun login(phone: String, sign: String): Observable<BaseResponseEntity<Login>> =AppApi.Api<AppService>().login(phone,sign)
}