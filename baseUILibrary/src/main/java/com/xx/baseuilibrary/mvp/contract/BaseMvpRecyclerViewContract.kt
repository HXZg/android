package com.xx.baseuilibrary.mvp.contract

import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseRxMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * BaseMvpRecyclerViewContract
 * (。・∀・)ノ
 * Describe：
 * Created by 雷小星🍀 on 2017/8/4 9:47.
 */

interface BaseMvpRecyclerViewContract {

    interface Model<E> {
        /**
         * 加载数据
         *
         * @param page         页数
         * @param httpObserver 观察者
         */
        fun loadData(page: Int): Observable<BaseResponseEntity<MutableList<E?>?>>
    }

    interface View<E> : BaseMvpLcecView<MutableList<E?>> {
        /**
         * 加载更多数据
         *
         * @param entities 数据
         */
        fun upDateAdd(entities: MutableList<E?>?)
    }

    abstract class Presenter<E> : BaseRxMvpPresenter<Model<E>, View<E>>() {
        /**
         * 加载数据
         *
         * @param refresh 是否刷新
         */
        abstract fun loadData(refresh: Boolean)
    }
}
