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
import com.micropole.homemodule.util.TimerUtil
import com.micropole.homemodule.util.setRanger
import com.micropole.homemodule.util.setTurnImage


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
            HouseDetailActivity.startHouseDetail(mContext,homeHouseAdapter.data[position].h_id)
        }

        stv_location.setOnClickListener {  }

        stv_settled_date.setOnClickListener { getDate(click = 1) }  //入驻时间
        stv_leave_store_date.setOnClickListener {
            val date = stv_settled_date.text.toString()
            val data = date.split("/")
            val addDate = TimerUtil.addDate(data[0].toInt(), data[1].toInt(), data[2].toInt())
            getDate(year = addDate[0],month = addDate[1],day = addDate[2],click = 2)
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
        rv_home_house.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        rv_home_house.adapter = homeHouseAdapter
        rv_home_house.isNestedScrollingEnabled = false

        setDate(Calendar.getInstance()[Calendar.YEAR],Calendar.getInstance()[Calendar.MONTH] + 1,Calendar.getInstance()[Calendar.DATE])

        presenter.getHomeData()
    }

    fun setDate(year: Int, month: Int, day: Int){
        stv_settled_date.text = "$year/$month/$day"
        val addDate = TimerUtil.addDate(year, month, day)
        stv_leave_store_date.text = "${addDate[0]}/${addDate[1]}/${addDate[2]}"
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
                cb_home.setTurnImage(mAdves)
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
        datePicker.setRanger(year, month, day)

        val date = if (click == 1) stv_settled_date.text.toString() else stv_leave_store_date.text.toString()
        val adata = date.split("/")
        datePicker.setSelectedItem(adata[0].toInt(),adata[1].toInt(),adata[2].toInt())

        datePicker.setOnDatePickListener(DatePicker.OnYearMonthDayPickListener { year, month, day ->
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
        picker.selectedIndex = 0 //默认选中项
        picker.setTextSize(18)
        picker.setOnOptionPickListener(object : OptionPicker.OnOptionPickListener() {
            override fun onOptionPicked(position: Int, option: String) {
                stv_settled_num.text = option //在文本框中显示选择的选项
            }
        })
        picker.show()

    }
}