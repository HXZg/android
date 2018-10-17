package com.xx.baseuilibrary

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * BaseFragment
 * (。・∀・)ノ
 * Describe：
 * Created by 雷小星🍀 on 2017/11/1 9:29.
 */
abstract class BaseFragment : Fragment() {

    protected lateinit var mContext: Context

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getFragmentLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.isClickable = true
        initView(view)
        initData()
        initEvent(view)
    }

    /**
     * 获取Fragment的布局资源文件id
     */
    protected abstract fun getFragmentLayoutId(): Int

    /**
     * 初始化视图控件
     */
    protected abstract fun initView(view: View?)

    /**
     * 初始化事件
     */
    protected abstract fun initEvent(view: View?)

    /**
     * 初始化页面数据状态
     */
    protected abstract fun initData()


}