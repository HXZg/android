package com.micropole.homemodule

import android.content.Context
import android.content.Intent
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.activity.BaseRecyclerActivity
import com.micropole.homemodule.adapter.EvaluationListAdapter
import com.micropole.homemodule.entity.EvaluationBean
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
class EvaluationListActivity : BaseRecyclerActivity<EvaluationBean,EvaluationListConstract.Model,EvaluationListConstract.View,EvaluationListConstract.Present>(),EvaluationListConstract.View{

    companion object {
        fun startEvaluationList(context: Context,h_id:String){
            val intent = Intent(context, EvaluationListActivity::class.java)
            intent.putExtra("house_id",h_id)  //房源id
            context.startActivity(intent)
        }
    }

    var mHId = ""
    override fun loadData(page: Int) {
        getPresenter().getEvaluationData(mHId,page)
    }

    override fun getAdapter(): BaseQuickAdapter<EvaluationBean, BaseViewHolder> = EvaluationListAdapter()

    override fun clickItem(position: Int) {
    }

    override fun createPresenter(): EvaluationListConstract.Present = EvaluationListPresent()

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_list

    override fun initData() {
        mHId = intent.getStringExtra("house_id")
        super.initData()
        setTitleText("评论")
    }

    override fun getEvaluationData(data: List<EvaluationBean>?) {
        if (data != null) setData(data)
    }

}