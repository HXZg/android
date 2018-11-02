package com.micropole.minemodule.mvp.presenter

import android.provider.SyncStateContract
import android.util.Log
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.minemodule.mvp.contract.HouserOwnerContract
import com.micropole.minemodule.mvp.contract.MineContract
import com.micropole.minemodule.mvp.contract.SettingContract
import com.micropole.minemodule.mvp.model.HouseOwnerModel
import com.micropole.minemodule.mvp.model.MineModel
import com.micropole.minemodule.mvp.model.SettingModel
import com.micropole.minemodule.util.refreshToken
import com.weibiaogan.bangbang.common.isIDCard
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class HouseOwmerPresenter:HouserOwnerContract.Presenter() {
    override fun setImage(img: String) {
        if (img.isNullOrEmpty()){
            getView()?.dismissLoadingDialog()
            getView()?.showToast("请上传身份证照片")
            return
        }
        getModel().setImage(img).ui({
            getView()?.setImage(it.data!!.imgUrl)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun beHouse(a_nickname: String, a_idcard: String, a_front_idcard: String, a_verso_idcard: String) {
        var str=Constants.getLocation()
        if (a_nickname.isNullOrEmpty()){
            getView()?.showToast("名字不能为空")
            getView()?.dismissLoadingDialog()
            return
        }
        if (a_idcard.isNullOrEmpty()){
            getView()?.showToast("身份证号码不能为空")
            getView()?.dismissLoadingDialog()
            return
        }
        if (!a_idcard.isIDCard()){
            getView()?.showToast("身份证号码不正确")
            getView()?.dismissLoadingDialog()
            return
        }
        if (a_front_idcard.isNullOrEmpty()){
            getView()?.showToast("请上传身份证正面")
            getView()?.dismissLoadingDialog()
            return
        }
        if (a_verso_idcard.isNullOrEmpty()){
            getView()?.showToast("请上传身份证反面")
            getView()?.dismissLoadingDialog()
            return
        }
        getModel().beHouse(Constants.SHORT_TOKEN,str[0],str[1],a_nickname,a_idcard,a_front_idcard,a_verso_idcard).ui({
            getView()?.beHouse()
            getView()?.dismissLoadingDialog()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.refreshToken(it,{beHouse(a_nickname, a_idcard, a_front_idcard, a_verso_idcard)})
        })
    }

    override fun createModel(): HouserOwnerContract.Model =HouseOwnerModel()
}