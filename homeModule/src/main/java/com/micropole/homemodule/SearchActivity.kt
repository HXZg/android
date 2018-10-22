package com.micropole.homemodule

import android.support.constraint.Group
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
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
    var mOldGroup : TextView? = null

    override fun getActivityLayoutId(): Int = R.layout.activity_search

    override fun initData() {
        recyclerView.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = HomeHouseAdapter(arrayListOf(Any(), Any(),Any()))

        clickSort(tv_search_distance)
    }

    override fun initEvent() {
        tv_search_distance.setOnClickListener { clickSort(tv_search_distance) }
        tv_search_price.setOnClickListener { clickSort(tv_search_price) }
        tv_search_score.setOnClickListener { clickSort(tv_search_score) }
    }

    fun clickSort(view: TextView){
        if (mOldGroup != view){
            changeSort(mOldGroup)
            changeSort(view,true)
            mOldGroup = view
        }
    }

    /**
     * 排序，点击改变
     */
    fun changeSort(view:TextView?,isSelect : Boolean = false){
        when(view){
            tv_search_distance -> {
                iv_distance_lower.isSelected = isSelect
                iv_distance_upper.isSelected = isSelect
            }
            tv_search_price -> {
                iv_price_lower.isSelected = isSelect
                iv_price_upper.isSelected = isSelect
            }
            tv_search_score -> {
                iv_score_lower.isSelected = isSelect
                iv_score_upper.isSelected = isSelect
            }
        }
    }
}