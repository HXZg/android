package com.micropole.homemodule.order

import android.os.Build.VERSION_CODES.O
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.micropole.homemodule.EvaluationActivity
import com.micropole.homemodule.R
import com.micropole.homemodule.adapter.OrderPriceAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_order_detail.*
import kotlinx.android.synthetic.main.view_order_detail_priced.*
import kotlinx.android.synthetic.main.view_order_msg.*

/**
 * @ClassName       OrderDetailActivity
 * @Description     订单详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 10:18
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderDetailActivity : BaseMvpViewActivity(){
    var mPriceAdapter = OrderPriceAdapter()
    override fun getActivityLayoutId(): Int = R.layout.activity_order_detail

    override fun initData() {
        iv_open_time.visibility = View.INVISIBLE
        iv_leave_time.visibility = View.INVISIBLE
        iv_settled_num.visibility = View.INVISIBLE

        et_order_settled_name.isEnabled = false
        et_order_id_card.isEnabled = false
        et_order_phone.isEnabled = false

        rv_order_price.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        rv_order_price.adapter = mPriceAdapter
        mPriceAdapter.setNewData(arrayListOf(Any(), Any(), Any(),Any()))
    }

    override fun initEvent() {

        stv_order_detail_btn.setOnClickListener { startActivity(EvaluationActivity::class.java) }
    }
}