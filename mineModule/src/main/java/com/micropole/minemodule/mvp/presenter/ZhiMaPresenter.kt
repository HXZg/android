package com.micropole.minemodule.mvp.presenter

import android.provider.SyncStateContract
import android.util.Log
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
class ZhiMaPresenter:ZhiMaContract.Presenter() {

    override fun createModel(): ZhiMaContract.Model =ZhiMaModel()
}