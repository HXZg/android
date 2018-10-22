package com.micropole.homemodule

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.qqtheme.framework.picker.DatePicker
import cn.qqtheme.framework.picker.DateTimePicker
import com.alibaba.android.arouter.facade.annotation.Route
import com.bigkoo.convenientbanner.ConvenientBanner
import com.flyco.dialog.widget.ActionSheetDialog
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.adapter.HomeHouseAdapter
import com.micropole.homemodule.entity.HomeBean
import com.micropole.homemodule.mvp.constract.HomeConstract
import com.micropole.homemodule.mvp.present.HomePresent
import com.micropole.homemodule.util.ImageHolderView
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecFragment
import kotlinx.android.synthetic.main.view_home.*
import kotlinx.android.synthetic.main.view_home_yd.*
import java.util.*

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

        stv_home_search.setOnClickListener {
            getPNum(100)
            //startActivity(SearchActivity::class.java)
        }
    }

    override fun initData() {
        showLoading()
        rv_home_house.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        rv_home_house.adapter = homeHouseAdapter
        rv_home_house.isNestedScrollingEnabled = false

        presenter.getHomeData()
    }

    override fun setData(data: HomeBean?) {
        if (data != null){
            showContent()
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
                        }
            }

            if (data.project.isNotEmpty()){
                homeHouseAdapter.setNewData(data.project)
            }
        }
    }

    //时间选择器
    private fun getDate(start:Int = 0,end : Int = 0,click:Int){
        var datePicker = DatePicker(activity, DateTimePicker.YEAR_MONTH_DAY)
        datePicker.setRangeStart(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH)+1, Calendar.getInstance()[Calendar.DATE] + start)
        datePicker.setRangeEnd(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH)+1, Calendar.getInstance()[Calendar.DATE] + end)
        datePicker.setOnDatePickListener(DatePicker.OnYearMonthDayPickListener { year, month, day ->
            //getPresenter().updateInfo(SetAccountMsgActivity.mTypeList[4],birth = "$year-$month-$day")
            //tv_set_birth.text = "$year-$month-$day"
        })
        datePicker.show()
    }

    //入驻人数选择
    private fun getPNum(num:Int){
        val mNums = arrayListOf<String>()
        for (i in 0..num){
            mNums.add(i.toString())
        }
        val actionSheetDialog = ActionSheetDialog(mContext, mNums.toArray() as Array<out String>, null)
        actionSheetDialog.show()
        actionSheetDialog.setOnOperItemClickL { parent, view, position, id ->

        }
    }
}