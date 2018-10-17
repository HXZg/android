package com.xx.baseuilibrary.mvp

import android.app.Activity

/**
 * BaseMvpView
 * (。・∀・)ノ
 * Describe：基类View接口,可以添加一些Activity的公用方法
 * Created by 雷小星🍀 on 2017/10/30 15:33.
 */

interface BaseMvpView {


    /**
     * 显示吐司消息
     * @param short 是否是长时吐司
     */
    fun showToast(msg: String?, isLong: Boolean = false)


    /**
     *  显示加载进度框
     */
    fun showLoadingDialog(msg: String? = null)

    /**
     * 隐藏加载进度框
     */
    fun dismissLoadingDialog()

    /**
     * 启动一个Activity
     */
    fun startActivity(clz: Class<out Activity>)

    /**
     * 结束Activity
     */
    fun finishActivity()

    /**
     * 启动一个Activity,然后关闭掉自己
     */
    fun startActivityThenFinishSelf(clz: Class<out Activity>)
}
