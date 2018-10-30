package com.micropole.loginmodule.mvp.presenter

import com.micropole.loginmodule.mvp.contract.RegisterContract
import com.micropole.loginmodule.mvp.model.RegisterModel
import com.weibiaogan.bangbang.common.isPhone
import com.weibiaogan.bangbang.common.md5Salt
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:
 */
class RegisterPresenter:RegisterContract.Presenter() {
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

    override fun register(phone: String, pwd: String,surePW:String, yzm: String, nickname: String) {
        if (!phone.isPhone()){
            getView()?.showToast("请输入正确的手机号码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (pwd.isNullOrEmpty()||pwd.length<6||pwd.length>15){
            getView()?.showToast("请填入6到15位的密码")
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
        if (yzm.isNullOrEmpty()||yzm.length!=6){
            getView()?.showToast("请输入6位验证码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (nickname.isNullOrEmpty()){
            getView()?.showToast("昵称不能为空")
            getView()?.dismissLoadingDialog()
            return
        }
        getModel().register(phone,pwd.md5Salt(),yzm,nickname).ui({
                getView()?.register(it.msg!!)
            getView()?.dismissLoadingDialog()
        },{
                getView()?.showToast(it)
            getView()?.dismissLoadingDialog()
        })
    }

    override fun createModel(): RegisterContract.Model =RegisterModel()

}