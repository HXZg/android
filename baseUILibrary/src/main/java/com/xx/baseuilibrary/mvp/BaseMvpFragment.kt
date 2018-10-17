package com.xx.baseuilibrary.mvp

import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import org.jetbrains.annotations.NotNull


/**
 * BaseMvpFragment
 * (。・∀・)ノ
 * Describe：
 * Created by 雷小星🍀 on 2017/11/1 9:53.
 */
abstract class BaseMvpFragment<M, V : BaseMvpView, P : BaseMvpPresenter<M, V>> : BaseMvpViewFragment() {

    private var presenter: P? = null

    /**
     * 创建P层
     *
     * @return P层对象
     */
    @NotNull
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
            presenter!!.attachView(this as V)
        }
        return presenter as P
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter().detachView()
    }
}