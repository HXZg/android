package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.micropole.minemodule.R
import com.micropole.minemodule.bean.Trip
import com.micropole.minemodule.dapter.TripIntraAdapter
import com.micropole.minemodule.mvp.contract.TripIntraContract
import com.micropole.minemodule.mvp.presenter.TripIntraPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_trip_intra.*
import kotlinx.android.synthetic.main.bar_title.*

class TripIntraActivity : BaseMvpActivity<TripIntraPresenter>(),TripIntraContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    override fun getTripList(trip: List<Trip>) {
        if (swipe_refresh.isRefreshing){
            swipe_refresh.isRefreshing=false
            adapter.setNewData(trip)
        }else if (adapter.isLoading){
            adapter.addData(trip)
            adapter.loadMoreComplete()
        }else{
            adapter.setNewData(trip)
        }
        if (trip.size==0){
            adapter.loadMoreEnd()
        }

    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): TripIntraPresenter =TripIntraPresenter()
    var current=1

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_trip_intra

    /**
     * 初始化数据状态
     */
    var adapter=TripIntraAdapter(arrayListOf())
    override fun initData() {
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
//        adapter.setNewData(arrayListOf("","","",""))
        tv_title.text="旅游基金"
        getPresenter().getTripList(""+current)
        adapter.setOnLoadMoreListener(this,recyclerView)

    }
    //上拉加载
    override fun onLoadMoreRequested() {
        current++
        getPresenter().getTripList(""+current)

    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
        swipe_refresh.setOnRefreshListener {
            current=1
            getPresenter().getTripList(""+current)
        }

    }
    companion object {
        fun  startTripIntraActivity(context: Context){
            var intent= Intent(context, TripIntraActivity::class.java)
            context.startActivity(intent)
        }
    }

}
