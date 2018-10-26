package com.micropole.homemodule.mine

import com.alibaba.android.arouter.facade.annotation.Route
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.activity.BaseRecyclerActivity
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.R
import com.micropole.homemodule.adapter.MineNoticeAdapter
import com.micropole.homemodule.entity.NewsBean
import com.micropole.homemodule.mvp.constract.MineNoticeConstract
import com.micropole.homemodule.mvp.present.MineNoticePresent

/**
 * @ClassName       MineCollectActivity
 * @Description     我的消息列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 13:30
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Mine.MINE_NOTICE,extras = ARouterConst.LOGIN_EXTRA)
class MineNoticeActivity : BaseRecyclerActivity<NewsBean,MineNoticeConstract.Model,MineNoticeConstract.View,MineNoticeConstract.Present>(),MineNoticeConstract.View{
    override fun loadData(page: Int) {
        getPresenter().newsList(page)
    }

    override fun getAdapter(): BaseQuickAdapter<NewsBean, BaseViewHolder> = MineNoticeAdapter()

    override fun clickItem(position: Int) {
        if (mAdapter != null) NoticeDetailActivity.startNoticeDetail(mContext,mAdapter!!.data[position].new_content)
    }

    override fun createPresenter(): MineNoticeConstract.Present = MineNoticePresent()

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_list

    override fun initData() {
        super.initData()
        setTitleText("消息")
    }

    override fun newsList(data: List<NewsBean>?) {
        if (data != null) setData(data)
    }
}