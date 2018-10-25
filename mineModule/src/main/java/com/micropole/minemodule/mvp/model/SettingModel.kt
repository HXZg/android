package com.micropole.minemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.minemodule.bean.ImageViewUri
import com.micropole.minemodule.bean.UserInfo
import com.micropole.minemodule.mvp.contract.MineContract
import com.micropole.minemodule.mvp.contract.SettingContract
import com.micropole.minemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class SettingModel:SettingContract.Model {
    override fun setImageUri(img: String)=AppApi.Api<AppService>().setImage(img)

    override fun setInfo(token: String, lat: String, lng: String, nickname: String, user_sex: String, user_img: String)=AppApi.Api<AppService>().setInfo(token,lat,lng,nickname,user_sex, user_img)
}