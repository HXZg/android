package com.xx.baseuilibrary.mvp.presenter

import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.rx.RxHttpObserver
import java.util.*

/**
 * BaseMvpPresenter
 * (。・∀・)ノ
 * Describe：使用RxJava处理网络请求时使用
 * Created by 雷小星🍀 on 2017/10/31 9:37.
 */

abstract class BaseRxMvpPresenter<M, V : BaseMvpView> : BaseMvpPresenter<M, V>() {

    private var observableList: MutableList<RxHttpObserver<*>>? = null

    /**
     * 关联指定Observer
     */
    protected fun attachObserver(observable: RxHttpObserver<*>) {
        if (observableList == null) {
            observableList = ArrayList()
        }
        if (!observableList!!.contains(observable)) {
            observableList!!.add(observable)
        }
    }

    /**
     * 解除指定关联的Observer
     *
     * @param observable Observer
     */
    protected fun detachObserver(observable: RxHttpObserver<*>) {
        if (observableList != null) {
            observable.cannel()
            observableList!!.remove(observable)
        }
    }

    /**
     * 解除所有关联Observer
     */
    protected fun detachAllObserver() {
        if (observableList != null) {
            for (observable in observableList!!) {
                observable.cannel()
            }
            observableList!!.clear()
            observableList = null
        }
    }

    override fun detachView() {
        detachAllObserver()
        super.detachView()
    }

}
