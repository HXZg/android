package com.micropole.homemodule.order

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.alibaba.android.arouter.launcher.ARouter
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.CommitSucActivity
import com.micropole.homemodule.R
import com.micropole.homemodule.adapter.OrderPriceAdapter
import com.micropole.homemodule.entity.BookingBean
import com.micropole.homemodule.entity.CommitOrderBean
import com.micropole.homemodule.mvp.constract.FillOrderConstract
import com.micropole.homemodule.mvp.present.FillOrderPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseutilslibrary.extensions.loadImag
import kotlinx.android.synthetic.main.activity_order_detail.*
import kotlinx.android.synthetic.main.view_order_detail_priced.*
import kotlinx.android.synthetic.main.view_order_msg.*

/**
 * @ClassName       FillOrderActivity
 * @Description     填写订单
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 13:33
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class FillOrderActivity : BaseMvpActivity<FillOrderConstract.Present>(),FillOrderConstract.View{

    companion object {
        fun startFillOrder(context: Context,h_id:String,start : String,end:String){
            val intent = Intent(context, FillOrderActivity::class.java)
            intent.putExtra("fill_order_start",start)
            intent.putExtra("fill_order_end",end)
            intent.putExtra("fill_order_hid",h_id)
            context.startActivity(intent)
        }
    }

    val mPriceAdapter = OrderPriceAdapter()
    var mStartTime = ""
    var mEndTime = ""
    var mHid = ""
    var mNum = 1
    var mBalance = 1

    override fun getActivityLayoutId(): Int = R.layout.activity_order_detail

    override fun createPresenter(): FillOrderConstract.Present {
        return FillOrderPresent()
    }

    override fun initData() {
        mStartTime = intent.getStringExtra("fill_order_start")
        mEndTime = intent.getStringExtra("fill_order_end")
        mHid = intent.getStringExtra("fill_order_hid")
        setTitleText("填写订单")
        rv_order_price.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false)
        rv_order_price.adapter = mPriceAdapter

        tv_order_open_time.text = mStartTime
        tv_order_leave_time.text = mEndTime
        getPresenter().bookingHouse(mHid,mStartTime,mEndTime,1,2)
    }

    override fun initEvent() {

        stv_order_detail_btn.setOnClickListener {
            getPresenter().commitOrder(mHid,tv_order_open_time.text.toString(),tv_order_leave_time.text.toString(),
                    mNum,mBalance,et_order_settled_name.text.toString(),et_order_id_card.text.toString(),et_order_phone.text.toString())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0x10 && resultCode == 0x11){
            startActivityThenFinishSelf(CommitSucActivity::class.java)
        }
    }

    override fun bookingSuc(bean: BookingBean?) {
        if (bean != null){
            iv_order_detail_img.loadImag(bean.h_imgs,radio = 16)
            tv_order_detail_name.text = bean.h_title
            tv_order_detail_address.text = bean.h_address                //房间信息


            val arr = bean.other_price_arr
            if (bean.or_balance_arr != null && bean.or_balance_arr.have == "1") arr.add(arrayListOf("使用旅行基金","-${bean.or_balance_arr.balance_price}"))
            mPriceAdapter.setNewData(arr)
        }
    }

    override fun commit(bean: CommitOrderBean?) {
        ARouter.getInstance().build(ARouterConst.Main.MAIN_PAY_CENTER).navigation(this,0x10)
    }
}