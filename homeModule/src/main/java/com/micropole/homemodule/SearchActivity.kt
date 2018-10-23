package com.micropole.homemodule

import android.content.Context
import android.content.Intent
import android.support.constraint.Group
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.activity.BaseRecyclerActivity
import com.micropole.homemodule.R.id.*
import com.micropole.homemodule.adapter.HomeHouseAdapter
import com.micropole.homemodule.adapter.SearchAdapter
import com.micropole.homemodule.entity.SearchBean
import com.micropole.homemodule.entity.SearchStyleBean
import com.micropole.homemodule.mvp.constract.SearchStyleConstract
import com.micropole.homemodule.mvp.present.SearchStylePresent
import com.micropole.homemodule.widght.SearchStylePopup
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_search.*
import kotlin.math.ln

/**
 * @ClassName       SearchActivity
 * @Description     搜索
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/19 15:38
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SearchActivity : BaseRecyclerActivity<SearchBean.ProjectBean,SearchStyleConstract.Model,SearchStyleConstract.View,SearchStyleConstract.Present>(),SearchStyleConstract.View {

    companion object {
        fun startSearch(context:Context,location:String,startTime:String,endTime:String,num:String){
            val intent = Intent(context, SearchActivity::class.java)
            intent.putExtra("search_location",location)
            intent.putExtra("search_startTime", startTime)
            intent.putExtra("search_endTime",endTime)
            intent.putExtra("search_num",num)
            context.startActivity(intent)
        }
    }

    var lat = ""
    var lng = ""
    var startTime = ""
    var endTime = ""
    var num = ""
    var mstyleId = ""

    var mData:List<SearchStyleBean>? = null

    override fun loadData(page: Int) {
        getPresenter().getSearchData(lat, lng,mstyleId,mOldType,page,startTime,endTime,num)
    }

    override fun clickItem(position: Int) {
    }

    override fun createPresenter(): SearchStyleConstract.Present = SearchStylePresent()

    var mOldType : Int = 0

    override fun getActivityLayoutId(): Int = R.layout.activity_search

    override fun getAdapter(): BaseQuickAdapter<SearchBean.ProjectBean, BaseViewHolder> = SearchAdapter()

    override fun initData() {
        clickSort(1)
        lat = intent.getStringExtra("search_location").split(",")[0]
        lng = intent.getStringExtra("search_location").split(",")[1]
        startTime = intent.getStringExtra("search_startTime")
        endTime = intent.getStringExtra("search_endTime")
        num = intent.getStringExtra("search_num")
        super.initData()
        getPresenter().getStyleData()
    }

    override fun initEvent() {
        super.initEvent()
        tv_search_distance.setOnClickListener { clickSort(1) }
        tv_search_price.setOnClickListener { clickSort(3) }
        tv_search_score.setOnClickListener { clickSort(5) }

        fl_search_type.setOnClickListener {
            if (mData != null){
                SearchStylePopup(mContext,mData!!,{
                    mstyleId = mData!![it].area_id
                    tv_search_style.text = mData!![it].area_name
                    onRefresh()
                }).anchorView(fl_search_type).gravity(Gravity.BOTTOM).alignCenter(true).show()
            }
        }
    }

    override fun getSearchData(data: SearchBean) {
        setData(data.project)
    }

    override fun getStyleData(data: List<SearchStyleBean>?) {
        if (data != null && data.isNotEmpty()){
            mData = data
            mstyleId = data[0].area_id
            onRefresh()
        }
    }

    fun clickSort(type: Int){
        changeSort(mOldType)
        changeSort(type,true)
    }

    /**
     * 排序，点击改变
     */
    fun changeSort(type:Int,isSelect : Boolean = false){
        when(type){
            1,2 -> {
                if (isSelect) {
                    val selected = mOldType == 1
                    iv_distance_lower.isSelected = selected
                    iv_distance_upper.isSelected = !selected
                    mOldType = if (!selected) 1 else 2
                }else if (!isSelect){
                    iv_distance_lower.isSelected = isSelect
                    iv_distance_upper.isSelected = isSelect
                }
            }
            3,4 -> {
                if (isSelect){
                    val selected = mOldType == 3
                    iv_price_lower.isSelected = selected
                    iv_price_upper.isSelected = !selected
                    mOldType = if (!selected) 3 else 4
                }else{
                    iv_price_lower.isSelected = isSelect
                    iv_price_upper.isSelected = isSelect
                }
            }
            5,6 -> {
                if (isSelect){
                    val selected = mOldType == 5
                    iv_score_lower.isSelected = selected
                    iv_score_upper.isSelected = !selected
                    mOldType = if (!selected) 5 else 6
                }else{
                    iv_score_lower.isSelected = isSelect
                    iv_score_upper.isSelected = isSelect
                }
            }
        }
    }
}