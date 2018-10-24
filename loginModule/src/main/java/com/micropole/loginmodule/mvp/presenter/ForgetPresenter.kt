package com.micropole.loginmodule.mvp.presenter

import com.micropole.loginmodule.mvp.contract.ForgetContract
import com.micropole.loginmodule.mvp.contract.LoginContract
import com.micropole.loginmodule.mvp.contract.RegisterContract
import com.micropole.loginmodule.mvp.model.FotgetModel
import com.micropole.loginmodule.mvp.model.LoginModel
import com.micropole.loginmodule.mvp.model.RegisterModel

/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:
 */
class ForgetPresenter:ForgetContract.Presenter() {
    override fun createModel(): ForgetContract.Model =FotgetModel()

}