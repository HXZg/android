package com.micropole.loginmodule.mvp.presenter

import com.micropole.loginmodule.mvp.contract.ForgetContract
import com.micropole.loginmodule.mvp.model.FotgetModel
import com.weibiaogan.bangbang.common.isPhone
import com.weibiaogan.bangbang.common.md5Salt
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:
 */
class ForgetPresenter:ForgetContract.Presenter() {
    override fun getCode(phone: String) {
        if (!phone.isPhone()){
            getView()?.showToast("请输入正确的手机号码")
            getView()?.dismissLoadingDialog()
            return
        }
        getModel().getCode(phone).ui({
            getView()?.getCode(it.data!!)
            getView()?.dismissLoadingDialog()
        },{
            getView()?.showToast(it)
            getView()?.dismissLoadingDialog()
        })
    }

    override fun forget(phone: String, pwd: String,surePW:String, code: String) {
        if (!phone.isPhone()){
            getView()?.showToast("请输入正确的手机号码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (pwd.isNullOrEmpty()){
            getView()?.showToast("密码不能为空")
            getView()?.dismissLoadingDialog()
            return
        }
        if (surePW.isNullOrEmpty()){
            getView()?.showToast("确认密码不能为空")
            getView()?.dismissLoadingDialog()
            return
        }
        if (surePW!=pwd){
            getView()?.showToast("两次输入密码不相同")
            getView()?.dismissLoadingDialog()
            return
        }
        if (code.isNullOrEmpty()||code.length!=6){
            getView()?.showToast("请输入6位验证码")
            getView()?.dismissLoadingDialog()
            return
        }
        getModel().forget(phone,pwd.md5Salt(),code).ui({
            getView()?.forget()
        },{
            getView()?.showToast(it)

        })


    }

    override fun createModel(): ForgetContract.Model =FotgetModel()

}