package com.xx.baseuilibrary

import android.content.Context
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.xx.baseutilslibrary.common.XxResourceUtil

/**
 * BaseActivity
 * (。・∀・)ノ
 * Describe：封装AppCompatActivity一级基类
 * Created by 雷小星🍀 on 2017/10/30 15:21.
 */

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var mContext: Context


    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    protected abstract fun getActivityLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        beforeSetContentView()
        setContentView(getActivityLayoutId())
        afterSetContentView()
    }


    /**
     * 在设置ContenView之前执行的操作
     * 需要时复写
     */
    open fun beforeSetContentView() {}


    /**
     * 在设置ContenView之后执行的操作
     * 需要时复写
     */
    open fun afterSetContentView() {
        initView()
        initData()
        initEvent()

        //初始化返回按钮
        val id = XxResourceUtil.getId(mContext, "ib_back")
        val ibBack = findViewById<View>(id)
        ibBack?.setOnClickListener {
            finish()
        }
    }

    open fun setTitleText(tit : String = "",@StringRes res: Int = 0){
        val id = XxResourceUtil.getId(mContext, "tv_title")
        val title = findViewById<TextView>(id)
        if (!TextUtils.isEmpty(tit)){
            title?.text = tit
        }else if (res != 0){
            title?.setText(res)
        }
    }

    /**
     * 初始化控件及设置
     */
    open fun initView() {}

    /**
     * 初始化数据状态
     */
    protected abstract fun initData()


    /**
     * 初始化事件
     */
    protected abstract fun initEvent()

}
