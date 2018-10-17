package com.xx.baseutilslibrary.extensions

import com.xx.baseutilslibrary.entity.BaseResponseEntity
import com.xx.baseutilslibrary.network.rx.ExceptionEngine
import com.xx.baseutilslibrary.network.rx.RxHttpObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by Gubr on 2018/2/11.
 */


fun <T> Observable<T>.ui(action: (t: T) -> Unit, error: (msg: String) -> Unit = {}) = subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(Consumer {
            action.invoke(it)
        }, object : ExceptionEngine() {
            override fun handle(msg: String) {
                error.invoke(msg)
            }
        })

/**
 * 结果处理
 */
fun <T> Observable<BaseResponseEntity<T>>.handler(
        onSuccess: (msg: String?, entity: T?) -> Unit,
        onError: (error: String?) -> Unit = {},
        onLoadingStart: (observer: RxHttpObserver<T>) -> Unit = {},
        onLoadingFinish: () -> Unit = {}) = io_main()
        .subscribe(object : RxHttpObserver<T>() {
            override fun onCompleted(msg: String?, entity: T?) {
                onSuccess.invoke(msg, entity)
            }

            override fun onError(error: String?) {
                onError.invoke(error)
            }

            override fun onLoadingStart() {
                onLoadingStart.invoke(this)
            }

            override fun onLoadingFinish() {
                onLoadingFinish.invoke()
            }
        })

/**
 * 线程调度
 */
fun <T> Observable<T>.io_main() = subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

/**
 * 监听开始和结束
 */
fun <T> Observable<T>.start_finish(onLoadingStart: () -> Unit = {}, onLoadingFinish: () -> Unit = {}) = doOnSubscribe { onLoadingStart.invoke() }
        .doOnComplete { onLoadingFinish.invoke() }
        .doOnError { onLoadingFinish.invoke() }
        .doFinally { onLoadingFinish.invoke() }
