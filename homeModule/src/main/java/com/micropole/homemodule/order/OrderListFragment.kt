package com.micropole.homemodule.order

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.R
import com.micropole.homemodule.adapter.OrderItemAdapter
import com.micropole.homemodule.entity.OrderListBean
import com.micropole.homemodule.mvp.constract.OrderListConstract
import com.micropole.homemodule.mvp.present.OrderListPresent
import com.xx.baseuilibrary.mvp.BaseMvpFragment

/**
 * @ClassName       OrderListFragment
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 9:40
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderListFragment : BaseMvpFragment<OrderListConstract.Model,OrderListConstract.View,OrderListConstract.Present>(),OrderListConstract.View {

    companion object {
        fun startOrderList(type:Int) : Fragment {
            val fragment = OrderListFragment()
            val bundle = Bundle()
            bundle.putInt("order_list_index",type)
            fragment.arguments = bundle
            return fragment
        }
    }

    val orderAdapter = OrderItemAdapter()
    var mCurrentPage = 1
    var mStaus = 7  //默认全部

    var mSwipe : SwipeRefreshLayout? = null
    var mRecycler : RecyclerView? = null
    override fun createPresenter(): OrderListConstract.Present = OrderListPresent()

    override fun getFragmentLayoutId(): Int = R.layout.view_refresh_recy

    override fun initView(view: View?) {
        mStaus = arguments?.getInt("order_list_index") ?: 7

        mSwipe = view?.findViewById(R.id.swipe_refresh)
        mRecycler = view?.findViewById(R.id.recycler_view)
    }

    override fun initEvent(view: View?) {

        orderAdapter.setOnItemClickListener { adapter, view, position ->
            OrderDetailActivity.startOrderDetail(mContext,orderAdapter.data[position].or_id)
        }
        orderAdapter.setOnLoadMoreListener({  //加载
            ++mCurrentPage
            loadData()
        },mRecycler)
        mSwipe?.setOnRefreshListener {  //刷新
            refreshLoad()
        }
    }

    fun loadData(){getPresenter().orderList(mStaus,mCurrentPage)}

    override fun initData() {
        mRecycler?.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        mRecycler?.adapter = orderAdapter
    }

    override fun onResume() {
        super.onResume()
        if (userVisibleHint){
            refreshLoad()
        }
    }

    fun refreshLoad(){
        mCurrentPage = 1
        loadData()
    }

    override fun setData(data: List<OrderListBean>?) {
        if (orderAdapter.isLoading){
            if (data != null && data.isNotEmpty()){
                orderAdapter.loadMoreComplete()
                orderAdapter.addData(data)
            }else{
                orderAdapter.loadMoreEnd(false)
            }
        }else{
            mSwipe?.isRefreshing = false
            orderAdapter.setNewData(data)
            if (data == null || data.isEmpty()){
                showToast("该列表没有数据")
            }
        }
    }

    override fun refreshError() {
        mSwipe?.isRefreshing = false
        orderAdapter.loadMoreEnd(true)
    }
}