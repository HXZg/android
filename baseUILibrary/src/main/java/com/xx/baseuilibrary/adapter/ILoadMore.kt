package com.xx.baseuilibrary.adapter

/**
 * ILoadMore
 * 沉迷学习不能自拔
 * Describe：
 * Created by 雷小星🍀 on 2018/6/8 16:58.
 */
interface ILoadMore {
    /**
     * 获取每页数据条数
     */
    val limit: Int

    /**
     * 触发加载更多
     */
    fun onLoadMore()
}
