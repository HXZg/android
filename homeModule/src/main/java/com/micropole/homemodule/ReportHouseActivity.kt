package com.micropole.homemodule

import android.content.Context
import android.content.Intent
import com.micropole.homemodule.mvp.constract.ReportHouseConstract
import com.micropole.homemodule.mvp.present.ReportHousePresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_report_house.*

/**
 * @ClassName       ReportHouseActivity
 * @Description     举报该房源
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/19 14:34
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ReportHouseActivity : BaseMvpActivity<ReportHouseConstract.Present>(),ReportHouseConstract.View{

    companion object {
        fun startReportHotel(context: Context,h_id:String){
            val intent = Intent(context, ReportHouseActivity::class.java)
            intent.putExtra("house_id",h_id)  //房源id
            context.startActivity(intent)
        }
    }

    var mHid = ""

    override fun getActivityLayoutId(): Int = R.layout.activity_report_house

    override fun initData() {
        mHid = intent.getStringExtra("house_id")
    }

    override fun initEvent() {
        stv_report_commit.setOnClickListener { getPresenter().reportHotel(mHid,et_put_report.text.toString()) }
    }

    override fun createPresenter(): ReportHouseConstract.Present {
        return ReportHousePresent()
    }
}