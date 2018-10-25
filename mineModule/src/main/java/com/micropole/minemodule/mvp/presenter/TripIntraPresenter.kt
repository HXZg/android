package com.micropole.minemodule.mvp.presenter

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.minemodule.mvp.contract.*
import com.micropole.minemodule.mvp.model.*
import com.micropole.minemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class TripIntraPresenter:TripIntraContract.Presenter() {
    override fun getTripList(page: String) {
        var str=Constants.getLocation()
        getView()?.showLoadingDialog("加载中...")
        getModel().getTripList(Constants.SHORT_TOKEN,str[0],str[1],page).ui({
            getView()?.getTripList(it.data!!)
            getView()?.dismissLoadingDialog()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.refreshToken(it,{getTripList(page)})
        })

    }

    override fun createModel(): TripIntraContract.Model =TripIntraModel()
}