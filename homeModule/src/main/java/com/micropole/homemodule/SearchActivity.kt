package com.micropole.homemodule

import android.support.v7.widget.LinearLayoutManager
import com.micropole.homemodule.adapter.HomeHouseAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_search.*

/**
 * @ClassName       SearchActivity
 * @Description     搜索
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/19 15:38
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SearchActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_search

    override fun initData() {
        recyclerView.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = HomeHouseAdapter(arrayListOf(Any(), Any(),Any()))
    }

    override fun initEvent() {
    }
}