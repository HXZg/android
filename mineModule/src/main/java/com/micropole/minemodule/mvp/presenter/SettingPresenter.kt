package com.micropole.minemodule.mvp.presenter

import android.provider.SyncStateContract
import android.util.Log
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.minemodule.mvp.contract.MineContract
import com.micropole.minemodule.mvp.contract.SettingContract
import com.micropole.minemodule.mvp.model.MineModel
import com.micropole.minemodule.mvp.model.SettingModel
import com.micropole.minemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class SettingPresenter:SettingContract.Presenter() {
    override fun setImageUri(img: String) {
        getModel().setImageUri(img).ui({
            getView()?.setImageURI(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun setInfo(nickname: String, user_sex: String, user_img: String) {
        getView()?.showLoadingDialog("加载中...")
        var str=Constants.getLocation()
        getModel().setInfo(Constants.SHORT_TOKEN,str[0],str[1],nickname,user_sex,user_img).ui({
            getView()?.setInfo()
            getView()?.dismissLoadingDialog()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.refreshToken(it,{setInfo(nickname, user_sex, user_img)})
        })
    }

    override fun createModel(): SettingContract.Model =SettingModel()
}