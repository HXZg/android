package com.micropole.minemodule.mvp.presenter

import android.util.Log
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.minemodule.mvp.contract.MineContract
import com.micropole.minemodule.mvp.model.MineModel
import com.micropole.minemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class MinePresenter:MineContract.Presenter() {
    override fun getInfo() {
        var str=Constants.getLocation()
        Log.i("Constantssss",Constants.SHORT_TOKEN+" 为"+str[0]+" 为"+str[1])
        getModel().getInfo(Constants.SHORT_TOKEN,str[0],str[1]).ui({
            getView()?.getInfo(it.data!!)
        },{
            getView()?.refreshToken(it,{getInfo()})
        })
    }

    override fun createModel(): MineContract.Model =MineModel()
}