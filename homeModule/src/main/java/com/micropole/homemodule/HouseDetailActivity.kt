package com.micropole.homemodule

import android.support.v7.widget.LinearLayoutManager
import com.micropole.homemodule.adapter.DetailDeviceAdapter
import com.micropole.homemodule.order.FillOrderActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_house_detail.*
import kotlinx.android.synthetic.main.view_house_detail.*
import kotlinx.android.synthetic.main.view_house_detail_device.*

/**
 * @ClassName       HouseDetailActivity
 * @Description     房间详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/19 14:10
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HouseDetailActivity : BaseMvpViewActivity(){
    var mDeviceAdapter = DetailDeviceAdapter()

    override fun getActivityLayoutId(): Int = R.layout.activity_house_detail

    override fun initData() {
        rv_detail_device.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false)
        rv_detail_device.adapter = mDeviceAdapter
        mDeviceAdapter.setNewData(arrayListOf(Any(), Any(), Any(), Any(),Any()))
    }

    override fun initEvent() {
        ll_msg.setOnClickListener {

        }
        iv_right.setOnClickListener {

        }
        view_evaluation.setOnClickListener {
            startActivity(EvaluationListActivity::class.java)
        }
        fl_report.setOnClickListener { startActivity(ReportHouseActivity::class.java) }  //举报该房源

        stv_detail_booking.setOnClickListener { startActivity(FillOrderActivity::class.java) }
    }
}