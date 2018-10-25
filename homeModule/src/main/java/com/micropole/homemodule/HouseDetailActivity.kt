package com.micropole.homemodule

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.qqtheme.framework.picker.DatePicker
import cn.qqtheme.framework.picker.DateTimePicker
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.PhoneUtils
import com.flyco.dialog.listener.OnBtnClickL
import com.flyco.dialog.widget.NormalDialog
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.adapter.DetailDeviceAdapter
import com.micropole.homemodule.entity.BookingBean
import com.micropole.homemodule.entity.HouseDetailBean
import com.micropole.homemodule.entity.LandlordBean
import com.micropole.homemodule.mvp.constract.HouseDetailConstract
import com.micropole.homemodule.mvp.present.HouseDetailPresent
import com.micropole.homemodule.order.FillOrderActivity
import com.micropole.homemodule.util.TimerUtil
import com.micropole.homemodule.util.setCheckLoginListener
import com.micropole.homemodule.util.setRanger
import com.micropole.homemodule.util.setTurnImage
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecActivity
import com.xx.baseutilslibrary.extensions.loadImag
import com.xx.baseutilslibrary.extensions.setHtmlText
import kotlinx.android.synthetic.main.activity_house_detail.*
import kotlinx.android.synthetic.main.view_house_detail.*
import kotlinx.android.synthetic.main.view_house_detail_device.*
import kotlinx.android.synthetic.main.view_house_detail_evaluation.*
import kotlinx.android.synthetic.main.view_house_detail_landlord.*
import kotlinx.android.synthetic.main.view_house_detail_msg.*
import kotlinx.android.synthetic.main.view_house_detail_notice_entity.*
import kotlinx.android.synthetic.main.view_house_detail_price.*
import java.util.*

/**
 * @ClassName       HouseDetailActivity
 * @Description     房间详情
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/19 14:10
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HouseDetailActivity : BaseMvpLcecActivity<View,HouseDetailBean?,HouseDetailConstract.Model,HouseDetailConstract.View,HouseDetailConstract.Present>(),HouseDetailConstract.View{

    companion object {
        fun startHouseDetail(context: Context,id:String){
            val intent = Intent(context, HouseDetailActivity::class.java)
            intent.putExtra("house_id",id)  //房源id
            context.startActivity(intent)
        }
    }

    override fun createPresenter(): HouseDetailConstract.Present = HouseDetailPresent()

    override fun loadData(refresh: Boolean) {
        presenter.getHouseDetail(mHId)
    }

    override fun setData(data: HouseDetailBean?) {
        if (data != null){
            showContent()
            mHId = data.h_id
            val mImgs = arrayListOf<String>()
            for (i in data.h_imgs.indices){
                mImgs.add(data.h_imgs[i])
            }
            cb_house_img.setTurnImage(mImgs)

            tv_house_detail_name.text = data.h_title
            tv_house_detail_address.text = data.h_address
            tv_house_detail_des.text = "距离${data.distance}米"   //名字，地址，距离

            tv_detail_ev_num.text = "${data.comment_num}条评论"
            tv_detail_ev_score.text = data.comment_score             //评论分数，条数

            tv_detail_msg.setHtmlText(data.property)                 //房源信息

            mDeviceAdapter.setNewData(data.facility_services_arr)    //设施服务

            tv_detail_notice.text = "入住时间：${data.check_in_time}\n退房时间：${data.check_out_time}\n接待时间：${data.reception_time}\n取消规则：${data.cancel_rules}"

            val price = StringBuilder()
            for (i in data.other_price_arr.indices){
                price.append(data.other_price_arr[i][0] + "："+data.other_price_arr[i][1] + "\n")
            }
            price.append("额外房客：${data.additional_tip}\n")
            price.append("入驻押金：线下支付押金${data.cash_pledge}元(实际以到店为准)")
            tv_detail_price.text = price.toString()                                       //其它价格

            iv_landlord_img.loadImag(data.hotel_user.user_img,isCircle = true)
            tv_landlord_name.text = data.hotel_user.nickname
            tv_landlord_phone.text = data.hotel_user.user_phone
            tv_landlord_des.text = data.wishes                                           //房东寄语

            tv_house_detail_price.text = "¥"+data.or_all_price                          //总价
        }
    }

    var mDeviceAdapter = DetailDeviceAdapter()
    var mHId = ""

    override fun getActivityLayoutId(): Int = R.layout.activity_house_detail

    override fun initData() {
        mHId = intent.getStringExtra("house_id")
        super.initData()
        rv_detail_device.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false)
        rv_detail_device.adapter = mDeviceAdapter

        setDate(Calendar.getInstance()[Calendar.YEAR], Calendar.getInstance()[Calendar.MONTH] + 1, Calendar.getInstance()[Calendar.DATE])


        presenter.getHouseDetail(mHId)
    }


    override fun initEvent() {
        stv_settled_time.setOnClickListener { getDate(click = 1) }
        stv_leave_time.setOnClickListener {
            val date = stv_settled_time.text.toString()
            val data = date.split("/")
            val addDate = TimerUtil.addDate(data[0].toInt(), data[1].toInt(), data[2].toInt())
            getDate(year = addDate[0],month = addDate[1],day = addDate[2],click = 2)
        }
        ll_msg.setOnClickListener {
            ARouter.getInstance().build(ARouterConst.Main.MAIN_MAP).navigation()
        }
        iv_right.setOnClickListener {
            ARouter.getInstance().build(ARouterConst.Main.MAIN_MAP).navigation()
        }
        view_evaluation.setOnClickListener {
            EvaluationListActivity.startEvaluationList(mContext,mHId)
        }
        fl_report.setCheckLoginListener { ReportHouseActivity.startReportHotel(mContext,mHId) }  //举报该房源

        iv_detail_telephone.setOnClickListener { presenter.getUserPhone(mHId) }  //联系房东

        iv_detail_follow.setOnClickListener { presenter.collectHouse(mHId) }  //收藏

        iv_detail_share.setOnClickListener { ARouter.getInstance().build(ARouterConst.Main.MAIN_SHARE).navigation() }  //分享

        stv_detail_booking.setOnClickListener { FillOrderActivity.startFillOrder(mContext,mHId,stv_settled_time.text.toString(),stv_leave_time.text.toString()) }  //预订
    }

    fun setDate(year: Int, month: Int, day: Int){
        stv_settled_time.text = "$year/$month/$day"
        val addDate = TimerUtil.addDate(year, month, day)
        stv_leave_time.text = "${addDate[0]}/${addDate[1]}/${addDate[2]}"
    }

    override fun userPhone(bean: LandlordBean?) {
        if (bean != null) callPhone(bean.user_phone)
    }

    fun callPhone(phone:String){
        val normalDialog = NormalDialog(mContext)
        normalDialog.style(NormalDialog.STYLE_TWO)
        normalDialog.isTitleShow(false)
        normalDialog.content(phone)
        normalDialog.btnText("取消","呼叫")
        normalDialog.btnTextColor(resources.getColor(R.color.btn_bg),resources.getColor(R.color.btn_bg))
        normalDialog.setOnBtnClickL(OnBtnClickL { normalDialog.dismiss() }, OnBtnClickL {
            PhoneUtils.call(phone)
            normalDialog.dismiss()
        })
        normalDialog.show()
    }

    //时间选择器
    private fun getDate(year:Int = 0, month : Int = 0, day : Int = 0, click:Int){
        var datePicker = DatePicker(this, DateTimePicker.YEAR_MONTH_DAY)
        datePicker.setRanger(year, month, day)
        val date = if (click == 1) stv_settled_time.text.toString() else stv_leave_time.text.toString()
        val adata = date.split("/")
        datePicker.setSelectedItem(adata[0].toInt(),adata[1].toInt(),adata[2].toInt())
        datePicker.setOnDatePickListener(DatePicker.OnYearMonthDayPickListener { year, month, day ->
            if (click == 1){
                setDate(year.toInt(),month.toInt(),day.toInt())
            }else{
                stv_leave_time.text = "$year/$month/$day"
            }
        })
        datePicker.show()
    }
}