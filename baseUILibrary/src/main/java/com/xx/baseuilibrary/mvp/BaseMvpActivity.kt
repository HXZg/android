package com.xx.baseuilibrary.mvp

import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter

/**
 * BaseMvpActivity
 * (。・∀・)ノ
 * Describe：Mvp的基础管理操作的基类Activity
 * Created by 雷小星🍀 on 2017/10/30 15:31.
 */

abstract class BaseMvpActivity<P:BaseMvpPresenter<*,out BaseMvpView> > : BaseMvpViewActivity() {

    private var presenter: P? = null

    /**
     * 创建P层
     *
     * @return P层对象
     */
    protected abstract fun createPresenter(): P

    /**
     * 获取P层实例
     *
     * @return P层实例
     */
    protected fun getPresenter(): P {
        if (presenter == null) {
            presenter = createPresenter()
        }

        if (this is BaseMvpView) {
            //依附V
            presenter!!.attachView(this)
        }
        return presenter as P
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter().detachView()
    }
}
