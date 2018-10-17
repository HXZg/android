package com.xx.baseuilibrary.mvp.presenter


import com.xx.baseuilibrary.mvp.contract.BaseMvpRecyclerViewContract
import com.xx.baseutilslibrary.extensions.handler

/**
 * BaseMvpRecyclerViewPresenter
 * (。・∀・)ノ
 * Describe：
 * Created by 雷小星🍀 on 2017/8/4 9:48.
 */

class BaseMvpRecyclerViewPresenter<E>(private val xxModel: BaseMvpRecyclerViewContract.Model<E>)
    : BaseMvpRecyclerViewContract.Presenter<E>() {
    var startPage = 1//默认页数从1开始
    private var page = startPage
    override fun loadData(refresh: Boolean) {
        page = if (refresh) startPage else ++page
        getModel()
                .loadData(page)
                .handler(
                        { msg, entity ->
                            if (refresh) {
                                getView()?.setData(entity)
                            } else {
                                getView()?.upDateAdd(entity)
                            }
                        },
                        { error ->
                            page = if (refresh) startPage else --page
                            getView()?.showError(Throwable(error), refresh)
                        },
                        { observer ->
                            attachObserver(observer)
                            isLoading = true
                        },
                        { isLoading = false }
                )
    }

    override fun createModel(): BaseMvpRecyclerViewContract.Model<E> = xxModel
}
