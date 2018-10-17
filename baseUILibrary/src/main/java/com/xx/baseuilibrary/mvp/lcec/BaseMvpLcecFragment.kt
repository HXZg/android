package com.xx.baseuilibrary.mvp.lcec

import android.view.View

import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter


/**
 * BaseMvpLcecActivity
 * (๑• . •๑)
 * 类描述:
 * Created by 雷小星🍀 on 2017/6/22 12:02
 */

abstract class BaseMvpLcecFragment<ContentView : View, Data, M, V : BaseMvpLcecView<Data>, P : BaseMvpPresenter<M, V>> : BaseLcecFragment<ContentView, Data>() {
    private var mPresenter: P? = null

    /**
     * 获取Presenter
     *
     * @return Presenter
     */
    @Suppress("UNCHECKED_CAST")
    protected val presenter: P
        get() {
            if (mPresenter == null) {
                mPresenter = createPresenter()
                if (mPresenter == null) {
                    throw NullPointerException("在createPresenter()方法中返回了null")
                }
                mPresenter!!.attachView(this as V)
            }
            return mPresenter as P
        }

    /**
     * 获取Presenter
     *
     * @return Presenter
     */
    protected abstract fun createPresenter(): P

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}
