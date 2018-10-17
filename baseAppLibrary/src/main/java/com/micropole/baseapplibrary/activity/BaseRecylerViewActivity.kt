package com.micropole.baseapplibrary.activity

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import kotlinx.android.synthetic.main.refresh_recycler_view.*

/**
 * author: HuaiXianZhong
 * date: 2018/8/3
 * describe:
 */
abstract class BaseRecylerViewActivity<T,M,V : BaseMvpView,P : BaseMvpPresenter<M,V>> : BaseMvpActivity<M,V,P>(), OnRefreshLoadMoreListener{

    var page = 1
    var size = 0
    var updata = false
    var layoutManager : RecyclerView.LayoutManager? = null

    var adapter : BaseQuickAdapter<T,BaseViewHolder>? = null

    var util = BaseRecylerViewUtil()

    override fun initData() {
        //smart_refresh.setEnableLoadMore(false)
        //smart_refresh.setEnableRefresh(true)
        page = 1
        loadData(page)
    }

    override fun initEvent() {
        swipe_refresh.setOnRefreshLoadMoreListener(this)
    }

    fun setRvLayout(layoutManager : RecyclerView.LayoutManager){
        this.layoutManager = layoutManager
        recyclerView.layoutManager = layoutManager
    }

    fun setRvAdapter(adapter: BaseQuickAdapter<T,BaseViewHolder>){
        this.adapter = adapter
        recyclerView.adapter = adapter
    }

    fun setHeaderView(@LayoutRes id:Int){
        var view = View.inflate(mContext, id, null)
        initHeadEvent(view)
        adapter?.addHeaderView(view)
    }

    fun addBottomView(@LayoutRes id: Int){
        var view = View.inflate(mContext, id, null)
        initFootEvent(view)
        adapter?.addFooterView(view)
    }

    open fun initHeadEvent(view: View){

    }

    open fun initFootEvent(view : View){

    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        loadData(++page)
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        page = 1
        loadData(page)
    }

    fun setRefreshLoad(refresh : Boolean,load : Boolean){
        util.setIsRefreshLoad(refresh, load)
    }

    abstract fun loadData(page : Int)

    fun setData(data : List<T>){
        /*if (updata){
            updata = false
            updataItemView(data)
            return
        }*/
        util.addRvData(adapter!!,data,swipe_refresh)
        /*if (page == 1 && data.isNotEmpty()){
            size = data.size
            swipe_refresh.setEnableLoadMore(size == 10 && util.mEnableLoadMore)
        }*/
    }

    fun updataItem(position:Int){
        var page = position / size
        updata = true
        loadData(page)
    }

    fun updataItemView(data: List<T>){}

}