package com.micropole.homemodule.order

import android.content.Context
import android.content.Intent
import android.os.Build.VERSION_CODES.O
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.micropole.homemodule.EvaluationActivity
import com.micropole.homemodule.R
import com.micropole.homemodule.R.id.*
import com.micropole.homemodule.adapter.OrderPriceAdapter
import com.micropole.homemodule.entity.OrderDetailBean
import com.micropole.homemodule.mvp.constract.OrderDetailConstract
import com.micropole.homemodule.mvp.present.OrderDetailPresent
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecActivity
import com.xx.baseutilslibrary.extensions.loadImag
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
class OrderDetailActivity : BaseMvpLcecActivity<View,OrderDetailBean?,OrderDetailConstract.Model,OrderDetailConstract.View,OrderDetailConstract.Present>(),OrderDetailConstract.View{

    companion object {
        fun startOrderDetail(context: Context,orderId : String){
            val intent = Intent(context, OrderDetailActivity::class.java)
            intent.putExtra("order_id",orderId)
            context.startActivity(intent)
        }
    }

    var mPriceAdapter = OrderPriceAdapter()
    var mOrderId = ""
    var mStat = "7"
    var bean : OrderDetailBean? = null

    override fun getActivityLayoutId(): Int = R.layout.activity_order_detail

    override fun createPresenter(): OrderDetailConstract.Present {
        return OrderDetailPresent()
    }

    override fun loadData(refresh: Boolean) {
        presenter.orderDetail(mOrderId)
    }

    override fun initData() {
        mOrderId = intent.getStringExtra("order_id")
        iv_open_time.visibility = View.INVISIBLE
        iv_leave_time.visibility = View.INVISIBLE
        iv_settled_num.visibility = View.INVISIBLE

        et_order_settled_name.isEnabled = false
        et_order_id_card.isEnabled = false
        et_order_phone.isEnabled = false
        super.initData()

        rv_order_price.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        rv_order_price.adapter = mPriceAdapter
        loadData(true)
    }

    override fun initEvent() {

        stv_order_detail_btn.setOnClickListener {
            if (stv_order_detail_btn.text.toString() == "去评价" && bean != null){
                EvaluationActivity.startEvaluation(mContext,mOrderId,bean!!.h_id,bean!!.h_imgs,bean!!.h_title,bean!!.h_address)
            }else if (mStat == "2" || mStat == "1"){
                presenter.refundOrder(mOrderId)
            }
        }
    }

    override fun setData(data: OrderDetailBean?) {
        showContent()
        if (data != null){
            bean = data
            mOrderId = data.or_id

            tv_order_detail_price.text = "¥${data.real_price}"
            mStat = data.or_stat
            when(data.or_stat){
                "1" -> stv_order_detail_btn.text = "退款"
                "2" -> stv_order_detail_btn.text = "退款"
                "3" -> {
                    if (data.is_comment != "1") stv_order_detail_btn.text = "去评价"
                    else stv_order_detail_btn.text = data.or_stat_detail
                }
                else -> stv_order_detail_btn.text = data.or_stat_detail
            }

            iv_order_detail_img.loadImag(data.h_imgs,radio = 16)
            tv_order_detail_name.text = data.h_title
            tv_order_detail_address.text = data.h_address                //房间信息

            tv_order_open_time.text = data.start_time
            tv_order_leave_time.text = data.end_time
            tv_order_settled_num.text = "${data.people_number}人"
            et_order_settled_name.setText(data.or_nickname)
            et_order_id_card.setText(data.or_idcard)
            et_order_phone.setText(data.or_phone)                      //订单信息

            val arr = data.or_other_price_arr
            if (!data.balance_pay.isEmpty()) arr.add(arrayListOf("使用旅行基金","-${data.balance_pay}"))
            mPriceAdapter.setNewData(arr)
        }
    }
}