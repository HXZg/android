package com.micropole.homemodule

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.adapter.HomeHouseAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.view_home.*

/**
 * @ClassName       HomeFragment
 * @Description     首页
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/16 16:19
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Home.HOME_FRAGMENT)
class HomeFragment  : BaseMvpViewFragment(){
    override fun getFragmentLayoutId(): Int = R.layout.fragment_home

    override fun initView(view: View?) {
    }

    override fun initEvent(view: View?) {
    }

    override fun initData() {
        rv_home_house.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        rv_home_house.adapter = HomeHouseAdapter(arrayListOf(Any(), Any(),Any()))
        rv_home_house.isNestedScrollingEnabled = false
    }
}