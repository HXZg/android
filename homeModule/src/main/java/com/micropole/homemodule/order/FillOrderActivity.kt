package com.micropole.homemodule.order

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import cn.qqtheme.framework.picker.DatePicker
import cn.qqtheme.framework.picker.DateTimePicker
import cn.qqtheme.framework.picker.OptionPicker
import cn.qqtheme.framework.util.DateUtils
import com.alibaba.android.arouter.launcher.ARouter
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.CommitSucActivity
import com.micropole.homemodule.R
import com.micropole.homemodule.adapter.OrderPriceAdapter
import com.micropole.homemodule.entity.BookingBean
import com.micropole.homemodule.entity.CommitOrderBean
import com.micropole.homemodule.mvp.constract.FillOrderConstract
import com.micropole.homemodule.mvp.present.FillOrderPresent
import com.micropole.homemodule.util.TimerUtil
import com.micropole.homemodule.util.setRanger
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

    var mPriceAdapter = OrderPriceAdapter(true)
    var mStartTime = ""
    var mEndTime = ""
    var mHid = ""
    var mNum = 1
    var mBalance = 2

    var mMaxPeoPleNum = 1

    var mOrderId = ""

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
        mStartTime = mStartTime.replace("/","")
        mEndTime = mEndTime.replace("/","")
        getPresenter().bookingHouse(mHid,mStartTime,mEndTime,mNum,mBalance)
    }

    override fun initEvent() {
        tv_order_open_time.setOnClickListener { getDate(click = 1) }
        tv_order_leave_time.setOnClickListener {
            val date = tv_order_open_time.text.toString()
            val data = date.split("/")
            val addDate = TimerUtil.addDate(data[0].toInt(), data[1].toInt(), data[2].toInt())
            getDate(year = addDate[0],month = addDate[1],day = addDate[2],click = 2)
        }
        tv_order_settled_num.setOnClickListener { getPNum(mMaxPeoPleNum) }

        stv_order_detail_btn.setOnClickListener {
            getPresenter().commitOrder(mHid,tv_order_open_time.text.toString(),tv_order_leave_time.text.toString(),
                    mNum,mBalance,et_order_settled_name.text.toString(),et_order_id_card.text.toString(),et_order_phone.text.toString())
        }

        mPriceAdapter.setOnItemChildClickListener { adapter, view, position ->
            if (view.id == R.id.stv_zmm){
                ARouter.getInstance().build(ARouterConst.Mine.MINE_ALIAUTHO).navigation()
            }else if (view.id == R.id.iv_slide_btn){
                val selected = view.isSelected
                view.isSelected = !selected
                mBalance = if (selected) 2 else 1
                getPresenter().bookingHouse(mHid,mStartTime,mEndTime,mNum,mBalance)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0x10 && resultCode == 0x11){
            CommitSucActivity.startCommitSuc(mContext,mOrderId)
            finish()
        }
    }

    override fun bookingSuc(bean: BookingBean?) {
        if (bean != null){
            mPriceAdapter.isFree = bean.deposit_free
            mMaxPeoPleNum = bean.max_people.toInt()
            iv_order_detail_img.loadImag(bean.h_imgs,radio = 16)
            tv_order_detail_name.text = bean.h_title
            tv_order_detail_address.text = bean.h_address                //房间信息

            tv_order_detail_price.text = "合计 ¥${bean.or_all_price}"

            val arr = bean.other_price_arr
            val s = if (mBalance == 2) "" else "-"
            if (bean.or_balance_arr != null && bean.or_balance_arr.have == "1") arr.add(arrayListOf("使用旅行基金","$s${bean.or_balance_arr.balance_price}"))
            mPriceAdapter.setNewData(arr)
        }
    }

    override fun commit(bean: CommitOrderBean?) {
        if (bean != null){
            mOrderId = bean.or_id
            if (bean.stat == "2")
                ARouter.getInstance().build(ARouterConst.Main.MAIN_PAY_CENTER).withString("or_id",bean.or_id).navigation(this,0x10)
            else{
                CommitSucActivity.startCommitSuc(mContext,mOrderId)
                finish()
            }
        }
    }

    /**
     * 设置入住离店日期
     */
    fun setDate(year: Int, month: Int, day: Int){
        tv_order_open_time.text = "$year/${DateUtils.fillZero(month)}/${DateUtils.fillZero(day)}"
        val addDate = TimerUtil.addDate(year, month, day)
        tv_order_leave_time.text = "${addDate[0]}/${DateUtils.fillZero(addDate[1])}/${DateUtils.fillZero(addDate[2])}"
        mStartTime = tv_order_open_time.text.toString().replace("/","")
        mEndTime = tv_order_leave_time.text.toString().replace("/","")
    }

    //时间选择器
    private fun getDate(year:Int = 0, month : Int = 0, day : Int = 0, click:Int){
        var datePicker = DatePicker(this, DateTimePicker.YEAR_MONTH_DAY)
        datePicker.setRanger(year, month, day)

        val date = if (click == 1) tv_order_open_time.text.toString() else tv_order_leave_time.text.toString()
        val adata = date.split("/")
        datePicker.setSelectedItem(adata[0].toInt(),adata[1].toInt(),adata[2].toInt())

        datePicker.setOnDatePickListener(DatePicker.OnYearMonthDayPickListener { year, month, day ->
            if (click == 1){
                setDate(year.toInt(),month.toInt(),day.toInt())
            }else{
                tv_order_leave_time.text = "$year/$month/$day"
                mEndTime = "$year$month$day"
            }
            getPresenter().bookingHouse(mHid,mStartTime,mEndTime,mNum,mBalance)
        })
        datePicker.show()
    }

    //入驻人数选择
    private fun getPNum(num:Int){
        if (num <= 0) return
        var mNums = arrayListOf<String>()
        for (i in 1..num){
            mNums.add(i.toString())
        }
        val picker = OptionPicker(this, mNums) //list为选择器中的选项
        picker.setOffset(2)
        picker.selectedIndex = 0 //默认选中项
        picker.setTextSize(18)
        picker.setOnOptionPickListener(object : OptionPicker.OnOptionPickListener() {
            override fun onOptionPicked(position: Int, option: String) {
                tv_order_settled_num.text = "${option}人" //在文本框中显示选择的选项
                mNum = option.toInt()
                getPresenter().bookingHouse(mHid,mStartTime,mEndTime,mNum,mBalance)
            }
        })
        picker.show()
    }
}