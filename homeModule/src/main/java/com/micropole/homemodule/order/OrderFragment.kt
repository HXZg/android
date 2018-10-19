package com.micropole.homemodule.order

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.R
import com.micropole.homemodule.adapter.OrderItemAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_home.*
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

    override fun getFragmentLayoutId(): Int = R.layout.fragment_order

    override fun initView(view: View?) {

    }

    override fun initEvent(view: View?) {

        //tv_title.setOnClickListener { ARouter.getInstance().build(ARouterConst.Main.MAIN_PAY_CENTER).navigation() }
    }

    override fun initData() {
        tv_order_all.isSelected = true
        rv_order.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        rv_order.adapter = OrderItemAdapter(arrayListOf(Any(), Any(), Any(), Any(), Any()))
    }
}