package com.xx.baseutilslibrary.network.rx


import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.Function

/**
 * RetryWhenProcess
 * 沉迷学习不能自拔
 * Describe：
 * Created by 雷小星🍀 on 2017/12/1 16:19.
 */

class RetryWhenProcess(
        /**
         * 最大重连次数
         */
        private val maxRetries: Int,
        /**
         * 每次重连间隔时间，毫秒单位
         */
        private val retryDelayMillis: Long?) : Function<Observable<out Throwable>, Observable<*>> {

    /**
     * 当前重连次数
     */
    private var retryCount: Int = 0

    @Throws(Exception::class)
    override fun apply(observable: Observable<out Throwable>): Observable<*> {
        return observable
                .flatMap(Function<Throwable, ObservableSource<*>> { throwable ->
                    if (throwable is UnknownHostException) {
                        //没有连接网络，直接返回错误信息
                        return@Function Observable.error<Any>(throwable)
                    }
                    if (++retryCount <= maxRetries) {
                        //重连最大次数范围内
                        Observable
                                .timer(retryDelayMillis!!, TimeUnit.MILLISECONDS)
                    } else Observable.error<Any>(throwable)
                    //超过次数返回异常信息
                })
    }
}
