package com.micropole.minemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.minemodule.bean.Note
import com.micropole.minemodule.mvp.contract.InviteContract
import com.micropole.minemodule.mvp.contract.MineContract
import com.micropole.minemodule.mvp.contract.NoteContract
import com.micropole.minemodule.mvp.contract.SettingContract
import com.micropole.minemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class NoteModel:NoteContract.Model {
    override fun getNote(token: String, lat: String, lng: String) = AppApi.Api<AppService>().note(token, lat, lng)
}