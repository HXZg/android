package com.xx.baseuilibrary.mvp.lcec

import com.xx.baseuilibrary.mvp.BaseMvpView


/**
 * BaseMvpLcecView
 * (๑• . •๑)
 * 类描述:
 * Created by 雷小星🍀 on 2017/6/22 12:03
 */

interface BaseMvpLcecView<Data> : BaseMvpView {

    /**
     * 填充数据
     *
     * @param data 数据
     */
    fun setData(data: Data?)

    /**
     * 显示错误信息
     *
     * @param throwable 错误
     * @param refresh   是否是刷新
     */
    fun showError(throwable: Throwable, refresh: Boolean)
}
