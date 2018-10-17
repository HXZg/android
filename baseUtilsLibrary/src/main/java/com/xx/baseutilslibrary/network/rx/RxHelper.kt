package com.xx.baseutilslibrary.network.rx

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * RxHelper
 * 沉迷学习不能自拔
 * Describe：
 * Created by 雷小星🍀 on 2017/12/1 14:01.
 */

object RxHelper {
    /**
     * 线程调度切换
     *
     * @param <T>
     * @return
    </T> */
    fun <T> io_main(): ObservableTransformer<T, T> {
        return ObservableTransformer { tObservable ->
            tObservable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    /**
     * 数据加载状态监听
     */
    interface OnLoadingStatusListener {

        fun onLoadingStart()

        fun onLoadingFinish()
    }
}
