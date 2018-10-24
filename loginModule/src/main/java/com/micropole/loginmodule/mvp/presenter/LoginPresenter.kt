package com.micropole.loginmodule.mvp.presenter

import com.micropole.loginmodule.mvp.contract.LoginContract
import com.micropole.loginmodule.mvp.model.LoginModel
import com.weibiaogan.bangbang.common.isPhone
import com.weibiaogan.bangbang.common.md5Salt
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:
 */
class LoginPresenter:LoginContract.Presenter() {
    override fun login(phone: String, sign: String) {
        if (!phone.isPhone()){
            getView()?.showToast("请输入正确的手机号码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (sign.isNullOrEmpty()){
            getView()?.showToast("密码不能为空")
            getView()?.dismissLoadingDialog()
            return
        }
        getModel()?.login(phone,sign.md5Salt()).ui({
            getView()?.dismissLoadingDialog()
            getView()?.login(it.data!!)

        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel(): LoginContract.Model =LoginModel()

}