package com.micropole.homemodule

import com.micropole.homemodule.order.FillOrderActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_house_detail.*
import kotlinx.android.synthetic.main.view_house_detail.*

/**
 * @ClassName       HouseDetailActivity
 * @Description     房间详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/19 14:10
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HouseDetailActivity : BaseMvpViewActivity(){
    override fun getActivityLayoutId(): Int = R.layout.activity_house_detail

    override fun initData() {
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