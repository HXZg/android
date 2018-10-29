package com.micropole.minemodule.mvp.presenter


import com.google.gson.Gson
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.minemodule.bean.UserInfo
import com.micropole.minemodule.mvp.contract.SettingPhoneContract

import com.micropole.minemodule.mvp.model.SettingPhoneModel
import com.micropole.minemodule.util.refreshToken
import com.weibiaogan.bangbang.common.isPhone
import com.xx.baseutilslibrary.extensions.ui


/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class SettingPhonePresenter:SettingPhoneContract.Presenter() {
    override fun setPhone(old_user_phone: String, new_user_phone: String, new_code: String, old_code: String) {
        if (!new_user_phone.isPhone()){
            getView()?.showToast("请输入正确的手机号码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (new_code.isNullOrEmpty()||new_code.length!=6){
            getView()?.showToast("请输入6位验证码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (old_code.isNullOrEmpty()||old_code.length!=6){
            getView()?.showToast("请输入6位验证码")
            getView()?.dismissLoadingDialog()
            return
        }
        var info=Gson().fromJson(Constants.getUserInfo(),UserInfo::class.java)
        var str=Constants.getLocation()
        getView()?.showLoadingDialog("加载中...")
        getModel().setPhone(Constants.SHORT_TOKEN,str[0],str[1],info.user.user_phone,new_user_phone,new_code,old_code).ui({
            getView()?.dismissLoadingDialog()
            getView()?.setphone()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.refreshToken(it,{setPhone(old_user_phone, new_user_phone, new_code, old_code)})
        })
    }

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


    override fun createModel(): SettingPhoneContract.Model =SettingPhoneModel()
}