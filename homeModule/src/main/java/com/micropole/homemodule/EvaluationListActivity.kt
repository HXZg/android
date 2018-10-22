package com.micropole.homemodule

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.activity.BaseRecyclerActivity
import com.micropole.homemodule.adapter.EvaluationListAdapter
import com.micropole.homemodule.mvp.constract.EvaluationListConstract
import com.micropole.homemodule.mvp.present.EvaluationListPresent

/**
 * @ClassName       EvaluationListActivity
 * @Description     评价列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 11:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationListActivity : BaseRecyclerActivity<Any,EvaluationListConstract.Model,EvaluationListConstract.View,EvaluationListConstract.Present>(){
    override fun loadData(page: Int) {
        mAdapter?.setNewData(arrayListOf(Any(), Any(),Any()))
    }

    override fun getAdapter(): BaseQuickAdapter<Any, BaseViewHolder> = EvaluationListAdapter()

    override fun clickItem(position: Int) {
    }

    override fun createPresenter(): EvaluationListConstract.Present = EvaluationListPresent()

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_list

    override fun initData() {
        super.initData()
        setTitleText("评论")
    }

}