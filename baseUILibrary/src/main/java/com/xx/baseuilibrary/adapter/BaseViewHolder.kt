package com.xx.baseuilibrary.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * BaseViewHolder
 * (๑• . •๑)
 * 类描述:普通的BaseViewHolder
 * Created by LeiXiaoXing on 2017/3/17 14:12
 */

abstract class BaseViewHolder<in E> protected constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        initView(itemView)
    }

    /**
     * 初始化视图
     *  java调用时会使用
     * @param itemView 子视图
     */
    protected open fun initView(itemView: View) {}

    /**
     * 绑定数据
     *
     * @param entity 实体对象
     */
    abstract fun bindView(position: Int, entity: E?)
}
