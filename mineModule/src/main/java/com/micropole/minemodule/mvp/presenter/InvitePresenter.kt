package com.micropole.minemodule.mvp.presenter


import com.micropole.baseapplibrary.constants.Constants
import com.micropole.minemodule.mvp.contract.InviteContract
import com.micropole.minemodule.mvp.model.InviteModel
import com.micropole.minemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class InvitePresenter: InviteContract.Presenter() {
    override fun getShare() {
        getView()?.showLoadingDialog("加载中...")
        var str=Constants.getLocation()
        getModel().getShare(Constants.SHORT_TOKEN,str[0],str[1]).ui({
            getView()?.dismissLoadingDialog()
            getView()?.getShare(it.data!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.refreshToken(it,{getShare()})
        })

    }

    override fun createModel(): InviteContract.Model =InviteModel()
}