package com.micropole.homemodule.order

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.R
import com.micropole.homemodule.R.id.rv_order
import com.micropole.homemodule.R.id.tv_order_all
import com.micropole.homemodule.adapter.OrderItemAdapter
import com.micropole.homemodule.entity.OrderListBean
import com.micropole.homemodule.mvp.constract.OrderListConstract
import com.micropole.homemodule.mvp.present.OrderListPresent
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecFragment
import kotlinx.android.synthetic.main.fragment_order.*

/**
 * @ClassName       OrderFragment
 * @Description     订单列表
 * 1=支付成功，待确认，2=管理员确认预约，已预订，3=已经完成 4=已取消 5=退款中 7=全部订单 8=待评价
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/16 16:21
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Order.ORDER_FRAGEMENT)
class OrderFragment  : BaseMvpLcecFragment<View,List<OrderListBean>?,OrderListConstract.Model,OrderListConstract.View,OrderListConstract.Present>(),OrderListConstract.View{
    val orderAdapter = OrderItemAdapter()
    var mCurrentPage = 1
    var mStaus = 7  //默认全部
    var mTxtView : View? = null

    override fun getFragmentLayoutId(): Int = R.layout.fragment_order

    override fun createPresenter(): OrderListConstract.Present = OrderListPresent()

    override fun loadData(refresh: Boolean) {
        mCurrentPage = 1
        presenter.orderList(mStaus,mCurrentPage)
    }

    override fun initEvent(view: View?) {
        orderAdapter.setOnItemClickListener { adapter, view, position ->
            OrderDetailActivity.startOrderDetail(mContext,orderAdapter.data[position].or_id)
        }
        orderAdapter.setOnLoadMoreListener({  //加载
            ++mCurrentPage
            presenter.orderList(mStaus,mCurrentPage)
        },rv_order)
        swipe_refresh.setOnRefreshListener {  //刷新
            loadData(true)
        }

        tv_order_all.setOnClickListener {
            mStaus = 7
            clickItem(it)
        }  //全部
        tv_order_confirm.setOnClickListener {
            mStaus = 1
            clickItem(it)
        } //待确认
        tv_order_cancel.setOnClickListener {
            mStaus = 4
            clickItem(it)
        } //取消
        tv_order_complete.setOnClickListener {
            mStaus = 3
            clickItem(it)
        }  //已完成
        tv_order_evaluation.setOnClickListener {
            mStaus = 8
            clickItem(it)
        }  //待评价
        tv_order_refund.setOnClickListener {
            mStaus = 5
            clickItem(it)
        }  //退款中
        tv_order_reservation.setOnClickListener {
            mStaus = 2
            clickItem(it)
        } //已预订

    }

    override fun initData() {
        clickItem(tv_order_all)
        rv_order.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        rv_order.adapter = orderAdapter
    }

    override fun onResume() {
        super.onResume()
        if (!Constants.isLogin()){
            fl_order_login.visibility = View.VISIBLE
        }else{
            fl_order_login.visibility = View.GONE
            loadData(true)
        }
    }

    fun clickItem(view:View){
        if (mTxtView != view){
            mTxtView?.isSelected = false
            view.isSelected = true
            mTxtView = view
            loadData(true)
        }
    }

    override fun setData(data: List<OrderListBean>?) {
        showContent()
        if (orderAdapter.isLoading){
            if (data != null && data.isNotEmpty()){
                orderAdapter.loadMoreComplete()
                orderAdapter.addData(data)
            }else{
                orderAdapter.loadMoreEnd(false)
            }
        }else{
            swipe_refresh.isRefreshing = false
            orderAdapter.setNewData(data)
            if (data == null || data.isEmpty()){
                showToast("该列表没有数据")
            }
        }
    }
}