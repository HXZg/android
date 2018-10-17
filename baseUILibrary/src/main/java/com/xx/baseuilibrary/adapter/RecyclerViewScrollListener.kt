package com.xx.baseuilibrary.adapter


import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * RecyclerViewScrollListener
 * 沉迷学习不能自拔
 * Describe：
 * Created by 雷小星🍀 on 2018/6/8 16:56.
 */
abstract class RecyclerViewScrollListener : RecyclerView.OnScrollListener(), ILoadMore {
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            //滑动停止状态时触发
            if (null == mLayoutManager) {
                mLayoutManager = recyclerView!!.layoutManager
            }

            if (mLayoutManager is GridLayoutManager) {
                val gridLayoutManager = mLayoutManager as GridLayoutManager?
                if (gridLayoutManager!!.itemCount > limit && gridLayoutManager.findLastVisibleItemPosition() == mLayoutManager!!.itemCount - 1) {
                    //通知加载更多
                    onLoadMore()
                }
            } else if (mLayoutManager is LinearLayoutManager) {
                val linearLayoutManager = mLayoutManager as LinearLayoutManager?
                if (linearLayoutManager!!.itemCount > limit && linearLayoutManager.findLastVisibleItemPosition() == mLayoutManager!!.itemCount - 1) {
                    //通知加载更多
                    onLoadMore()
                }
            }
        }
    }
}