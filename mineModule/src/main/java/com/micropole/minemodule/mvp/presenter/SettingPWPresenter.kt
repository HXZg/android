package com.micropole.minemodule.mvp.presenter

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.minemodule.mvp.contract.SettingPWContract
import com.micropole.minemodule.mvp.model.SettingPWModel
import com.micropole.minemodule.util.refreshToken
import com.weibiaogan.bangbang.common.isPhone
import com.weibiaogan.bangbang.common.md5Salt
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class SettingPWPresenter:SettingPWContract.Presenter() {
    override fun getCode(phone: String) {
        if (!phone.isPhone()){
            getView()?.showToast("请输入正确的手机号码")
            getView()?.dismissLoadingDialog()
            return
        }
        getView()?.showLoadingDialog("加载中...")
        getModel().getCode(phone).ui({
            getView()?.getCode(it.data!!)
            getView()?.dismissLoadingDialog()
        },{
            getView()?.showToast(it)
            getView()?.dismissLoadingDialog()
        })
    }

    override fun setPW(user_phone: String, code: String, new_user_pwd: String,sure_PW:String) {
        if (!user_phone.isPhone()){
            getView()?.showToast("请输入正确的手机号码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (code.isNullOrEmpty()||code.length!=6){
            getView()?.showToast("请输入6位验证码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (new_user_pwd.isNullOrEmpty()){
            getView()?.showToast("密码不能为空")
            getView()?.dismissLoadingDialog()
            return
        }
        if (sure_PW.isNullOrEmpty()){
            getView()?.showToast("确认密码不能为空")
            getView()?.dismissLoadingDialog()
            return
        }

        if (new_user_pwd!=sure_PW){
            getView()?.showToast("两次输入密码不相同")
            getView()?.dismissLoadingDialog()
            return
        }

        var str=Constants.getLocation()
        getView()?.showLoadingDialog("加载中...")
        getModel().setPW(Constants.SHORT_TOKEN,str[0],str[1],user_phone,code,new_user_pwd.md5Salt()).ui({
            getView()?.setPW()
            getView()?.dismissLoadingDialog()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.refreshToken(it,{setPW(user_phone, code, new_user_pwd,sure_PW)})
        })
    }

    override fun createModel(): SettingPWContract.Model =SettingPWModel()
}