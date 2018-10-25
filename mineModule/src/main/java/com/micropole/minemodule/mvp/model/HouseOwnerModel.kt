package com.micropole.minemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.minemodule.bean.ImageViewUri
import com.micropole.minemodule.mvp.contract.HouserOwnerContract
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
class HouseOwnerModel:HouserOwnerContract.Model {
    override fun setImage(img: String)=AppApi.Api<AppService>().setImage(img)

    override fun beHouse(token: String, lat: String, lng: String, a_nickname: String, a_idcard: String, a_front_idcard: String, a_verso_idcard: String)=
            AppApi.Api<AppService>().beHouse(token,lat,lng,a_nickname,a_idcard,a_front_idcard,a_verso_idcard)
}