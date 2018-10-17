package com.micropole.baseapplibrary.activity

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.constant.RefreshState

/**
 * author: HuaiXianZhong
 * date: 2018/8/3
 * describe:
 */
class BaseRecylerViewUtil {

    var mEnableRefresh = true
    var mEnableLoadMore = true

    var view : View? = null
    var smart:SmartRefreshLayout? = null

    fun setIsRefreshLoad(refresh:Boolean,load:Boolean){
        mEnableRefresh = refresh
        mEnableLoadMore = load
    }

    fun <T> addRvData(adapter: BaseQuickAdapter<T, BaseViewHolder>, data : List<T>,layout : SmartRefreshLayout){
        smart = layout
        if (layout.state == RefreshState.Refreshing){
            layout.finishRefresh()
            adapter.setNewData(data)
            if (data.isNotEmpty()){
                layout.setNoMoreData(false)
            }else{
                //setEmptyView(adapter)
            }
        }else if (layout.state == RefreshState.Loading){
            layout.finishLoadMore()
            if (data.isNotEmpty()){
                adapter.addData(data)
            }else{
                layout.setNoMoreData(true)
            }
        }else {
            adapter.setNewData(data)
            if (data.isNotEmpty()){
                layout.setEnableRefresh(mEnableRefresh)
                layout.setEnableLoadMore(mEnableLoadMore)
            }else{
                adapter.removeAllFooterView()
                adapter.removeAllHeaderView()
                //setEmptyView(adapter)
            }
        }
    }

    fun <T> setEmptyView(adapter: BaseQuickAdapter<T, BaseViewHolder>){
        if (view != null){
            adapter.emptyView = view
        }
    }

    fun finishError(refresh:Boolean){
        if (refresh){
            smart?.finishRefresh(false)
        }else{
            smart?.finishLoadMore(false)
        }
    }
}