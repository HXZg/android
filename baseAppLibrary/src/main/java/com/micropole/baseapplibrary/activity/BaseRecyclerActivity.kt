package com.micropole.baseapplibrary.activity

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import kotlinx.android.synthetic.main.view_refresh_recy.*

/**
 * @ClassName       BaseRecyclerActivity
 * @Description     刷新加载 activity
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 9:27
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
abstract class BaseRecyclerActivity<DATA,M,V : BaseMvpView,P:BaseMvpPresenter<M,V>> : BaseMvpActivity<M,V,P>(), SwipeRefreshLayout.OnRefreshListener {

    var mAdapter : BaseQuickAdapter<DATA,BaseViewHolder>? = null
    var mCurrentPage = 1
    val DEFAULT_SIZE = 10

    override fun initData() {
        if (swipe_refresh == null || recycler_view == null){
            throw RuntimeException("swipe refresh or recycler view must be not null")
        }

        swipe_refresh.setOnRefreshListener(this)

        setInitRv()
        loadData(mCurrentPage)
    }

    override fun initEvent() {
        mAdapter?.setOnLoadMoreListener({loadData(++mCurrentPage)},recycler_view)
        mAdapter?.setOnItemClickListener { adapter, view, position ->
            clickItem(position)
        }
    }

    fun setInitRv(layoutManager : LinearLayoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)){
        mAdapter = getAdapter()
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = mAdapter
    }

    fun setData(data : List<DATA>){
        if (mAdapter?.isLoading!!){
            if (data.isNotEmpty()){
                mAdapter?.addData(data)
                if (data.size == DEFAULT_SIZE){
                    mAdapter?.loadMoreComplete()
                }else{
                    mAdapter?.loadMoreEnd(true)
                }
            }else{
                mAdapter?.loadMoreEnd(true)
            }
        }else{
            swipe_refresh.isRefreshing = false
            mAdapter?.setEnableLoadMore(false)
            if (data.isNotEmpty()){
                if (data.size == DEFAULT_SIZE){
                    mAdapter?.setEnableLoadMore(true)
                }
                mAdapter?.setNewData(data)
            }
        }
    }

    //刷新
    override fun onRefresh() {
        mCurrentPage = 1
        loadData(mCurrentPage)
    }

    abstract fun loadData(page:Int)

    abstract fun getAdapter() : BaseQuickAdapter<DATA,BaseViewHolder>

    abstract fun clickItem(position:Int)
}