package com.micropole.minemodule.mvp.presenter


import com.micropole.minemodule.mvp.contract.NoteContract
import com.micropole.minemodule.mvp.model.NoteModel

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
class NotePresenter:NoteContract.Presenter() {

    override fun createModel(): NoteContract.Model =NoteModel()
}