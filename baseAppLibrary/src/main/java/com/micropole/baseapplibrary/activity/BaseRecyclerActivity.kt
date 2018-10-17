package com.micropole.baseapplibrary.activity

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.common.XxResourceUtil

/**
 * @ClassName       BaseRecyclerActivity
 * @Description     recycler view activity
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/17 15:12
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
abstract class BaseRecyclerActivity : BaseMvpViewActivity(), OnRefreshLoadMoreListener {
    override fun onLoadMore(refreshLayout: RefreshLayout) {

    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
    }

    var mRefresh : SmartRefreshLayout? = null
    var mRecycler : RecyclerView? = null

    override fun initData() {
        var id = XxResourceUtil.getId(mContext,"swipe_refresh")
        var idr = XxResourceUtil.getId(mContext,"recyclerView")
        mRefresh = findViewById(id)
        mRecycler = findViewById(idr)

        if (mRefresh == null || mRecycler == null){
            throw RuntimeException()
        }

    }

    override fun initEvent() {
        mRefresh?.setOnRefreshLoadMoreListener(this)
    }
}