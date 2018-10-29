package com.micropole.minemodule.mvp.presenter


import com.micropole.baseapplibrary.constants.Constants
import com.micropole.minemodule.mvp.contract.NoteContract
import com.micropole.minemodule.mvp.model.NoteModel
import com.micropole.minemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class NotePresenter:NoteContract.Presenter() {
    override fun getNote() {
        var str=Constants.getLocation()
        getView()?.showLoadingDialog("加载中...")
        getModel().getNote(Constants.SHORT_TOKEN,str[0],str[1]).ui({
            getView()?.getNote(it.data!!)
            getView()?.dismissLoadingDialog()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.refreshToken(it,{getNote()})
        })
    }

    override fun createModel(): NoteContract.Model =NoteModel()
}