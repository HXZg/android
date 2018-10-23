package com.micropole.homemodule

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.qqtheme.framework.picker.DatePicker
import cn.qqtheme.framework.picker.DateTimePicker
import com.alibaba.android.arouter.facade.annotation.Route
import com.bigkoo.convenientbanner.ConvenientBanner
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.adapter.HomeHouseAdapter
import com.micropole.homemodule.entity.HomeBean
import com.micropole.homemodule.mvp.constract.HomeConstract
import com.micropole.homemodule.mvp.present.HomePresent
import com.micropole.homemodule.util.ImageHolderView
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_home.*
import kotlinx.android.synthetic.main.view_home_yd.*
import java.util.*
import cn.qqtheme.framework.picker.OptionPicker
import cn.qqtheme.framework.util.DateUtils
import com.blankj.utilcode.util.TimeUtils.getDate


/**
 * @ClassName       HomeFragment
 * @Description     首页
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/16 16:19
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Home.HOME_FRAGMENT)
class HomeFragment  : BaseMvpLcecFragment<View,HomeBean,HomeConstract.Model,HomeConstract.View,HomeConstract.Present>(),HomeConstract.View{
    var mPeopleNum = 0

    override fun createPresenter(): HomeConstract.Present = HomePresent()

    override fun loadData(refresh: Boolean) {
        presenter.getHomeData()
    }

    val homeHouseAdapter = HomeHouseAdapter()

    override fun getFragmentLayoutId(): Int = R.layout.fragment_home

    override fun initEvent(view: View?) {
        homeHouseAdapter.setOnItemClickListener { adapter, view, position ->
            startActivity(HouseDetailActivity::class.java)
        }

        stv_location.setOnClickListener {  }

        stv_settled_date.setOnClickListener { getDate(click = 1) }  //入驻时间
        stv_leave_store_date.setOnClickListener {
            val date = stv_settled_date.text.toString()
            var year = date.split("/")[0].toInt()
            var month = date.split("/")[1].toInt()
            var day = date.split("/")[2].toInt()
            val days = DateUtils.calculateDaysInMonth(year, month)
            if (day + 1 > days){
                if (month == 12){
                    ++year
                    month = 1
                    day = 1
                }else{
                    ++month
                    day = 1
                }
            }else{
                ++day
            }
            getDate(year = year,month = month,day = day,click = 2)
        } //离店时间
        stv_settled_num.setOnClickListener { getPNum(mPeopleNum) } //入驻人数

        stv_home_search.setOnClickListener {
            SearchActivity.startSearch(mContext,"23,113",
                    stv_settled_date.text.toString().replace("/",""),
                    stv_settled_num.text.toString().replace("/",""),
                    stv_settled_num.text.toString())
        }

        swipe_refresh.setOnRefreshListener {
            presenter.getHomeData()
        }
    }

    override fun initData() {
        showLoading()
        rv_home_house.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        rv_home_house.adapter = homeHouseAdapter
        rv_home_house.isNestedScrollingEnabled = false

        setDate(Calendar.getInstance()[Calendar.YEAR],Calendar.getInstance()[Calendar.MONTH] + 1,Calendar.getInstance()[Calendar.DATE])

        presenter.getHomeData()
    }

    fun setDate(year: Int, month: Int, day: Int){
        var year = year
        var month = month
        var day = day
        stv_settled_date.text = "$year/$month/$day"
        val days = DateUtils.calculateDaysInMonth(year, month)
        if (day + 1 > days){
            if (month == 12){
                ++year
                month = 1
                day = 1
            }else{
                ++month
                day = 1
            }
        }else{
            ++day
        }
        stv_leave_store_date.text = "$year/$month/$day"
    }

    override fun setData(data: HomeBean?) {
        if (data != null){
            showContent()
            swipe_refresh.isRefreshing = false
            if (data.adve.isNotEmpty()){
                var mAdves = arrayListOf<String>()
                for (i in data.adve.indices){
                    mAdves.add(data.adve[i].ad_img)
                }
                (cb_home as ConvenientBanner<String>).setPages( { ImageHolderView() } , mAdves)
                        ?.setPageIndicator(intArrayOf(R.drawable.shape_indicator_gray,R.drawable.shape_indicator_red))
                        ?.setPointViewVisible(true)
                        ?.setOnItemClickListener {
                            /*activity?.bannerStart(data[position])*/
                            showToast(it.toString())
                        }?.startTurning(2000)
            }

            if (data.project.isNotEmpty()){
                homeHouseAdapter.setNewData(data.project)
            }

            mPeopleNum = data.people_number.toInt()
        }
    }

    //时间选择器
    private fun getDate(year:Int = 0, month : Int = 0, day : Int = 0, click:Int){
        var datePicker = DatePicker(activity, DateTimePicker.YEAR_MONTH_DAY)
        var myear = if (year == 0) Calendar.getInstance().get(Calendar.YEAR) else year
        var mmonth = if (month == 0) Calendar.getInstance().get(Calendar.MONTH) + 1 else month
        var mday = if (day == 0) Calendar.getInstance().get(Calendar.DATE) else day
        datePicker.setRangeStart(myear,mmonth,mday)
        datePicker.setRangeEnd(myear+100,mmonth,mday)
        val date = if (click == 1) stv_settled_date.text.toString() else stv_leave_store_date.text.toString()
        var ayear = date.split("/")[0].toInt()
        var amonth = date.split("/")[1].toInt()
        var aday = date.split("/")[2].toInt()
        datePicker.setSelectedItem(ayear,amonth,aday)
        datePicker.setOnDatePickListener(DatePicker.OnYearMonthDayPickListener { year, month, day ->
            //getPresenter().updateInfo(SetAccountMsgActivity.mTypeList[4],birth = "$year-$month-$day")
            //tv_set_birth.text = "$year-$month-$day"
            if (click == 1){
                setDate(year.toInt(),month.toInt(),day.toInt())
            }else{
                stv_leave_store_date.text = "$year/$month/$day"
            }
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
        val picker = OptionPicker(activity, mNums) //list为选择器中的选项
        picker.setOffset(2)
        picker.selectedIndex = 1 //默认选中项
        picker.setTextSize(18)
        picker.setOnOptionPickListener(object : OptionPicker.OnOptionPickListener() {
            override fun onOptionPicked(position: Int, option: String) {
                stv_settled_num.text = option //在文本框中显示选择的选项
            }
        })
        picker.show()

    }
}