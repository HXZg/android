package com.micropole.minemodule.mvp.presenter

import android.provider.SyncStateContract
import android.util.Log
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.minemodule.mvp.contract.MineContract
import com.micropole.minemodule.mvp.contract.SettingContract
import com.micropole.minemodule.mvp.contract.SettingPWContract
import com.micropole.minemodule.mvp.model.MineModel
import com.micropole.minemodule.mvp.model.SettingModel
import com.micropole.minemodule.mvp.model.SettingPWModel
import com.micropole.minemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class SettingPWPresenter:SettingPWContract.Presenter() {

    override fun createModel(): SettingPWContract.Model =SettingPWModel()
}