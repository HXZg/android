package com.micropole.loginmodule.mvp.presenter

import com.micropole.loginmodule.mvp.contract.RegisterContract
import com.micropole.loginmodule.mvp.model.RegisterModel

/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:
 */
class RegisterPresenter:RegisterContract.Presenter() {
    override fun createModel(): RegisterContract.Model =RegisterModel()

}