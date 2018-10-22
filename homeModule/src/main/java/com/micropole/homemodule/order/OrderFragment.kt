package com.micropole.homemodule.order

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.R
import com.micropole.homemodule.adapter.OrderItemAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_order.*

/**
 * @ClassName       OrderFragment
 * @Description     订单列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/16 16:21
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Order.ORDER_FRAGEMENT)
class OrderFragment  : BaseMvpViewFragment(){
    val orderAdapter = OrderItemAdapter(arrayListOf(Any(), Any(), Any(), Any(), Any()))
    var mCurrentPage = 1
    var mTxtView : View? = null

    override fun getFragmentLayoutId(): Int = R.layout.fragment_order

    override fun initView(view: View?) {

    }

    override fun initEvent(view: View?) {
        orderAdapter.setOnItemClickListener { adapter, view, position ->
            startActivity(OrderDetailActivity::class.java)
        }
        orderAdapter.setOnLoadMoreListener({  //加载
            ++mCurrentPage
        },rv_order)
        swipe_refresh.setOnRefreshListener {  //刷新
            mCurrentPage = 1
        }

        tv_order_all.setOnClickListener {  }  //全部
    }

    override fun initData() {
        clickItem(tv_order_all)
        rv_order.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        rv_order.adapter = orderAdapter
    }

    fun clickItem(view:View){
        if (mTxtView != view){
            mTxtView?.isSelected = false
            view.isSelected = true
            mTxtView = view

        }
    }
}