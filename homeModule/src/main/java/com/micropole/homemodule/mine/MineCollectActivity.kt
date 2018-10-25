package com.micropole.homemodule.mine

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.activity.BaseRecyclerActivity
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.HouseDetailActivity
import com.micropole.homemodule.R
import com.micropole.homemodule.adapter.MineColletAdapter
import com.micropole.homemodule.entity.HouseDetailBean
import com.micropole.homemodule.entity.SearchBean
import com.micropole.homemodule.mvp.constract.MineColletConstract
import com.micropole.homemodule.mvp.present.MineColletPresent

/**
 * @ClassName       MineCollectActivity
 * @Description     我的收藏，足迹
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 13:30
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Mine.MINE_COLLECT,extras = ARouterConst.LOGIN_EXTRA)
class MineCollectActivity : BaseRecyclerActivity<SearchBean.ProjectBean,MineColletConstract.Model,MineColletConstract.View,MineColletConstract.Present>(),MineColletConstract.View{
    var type = 0

    override fun loadData(page: Int) {
        getPresenter().collectFootList(type,page)
    }

    override fun getAdapter(): BaseQuickAdapter<SearchBean.ProjectBean, BaseViewHolder> = MineColletAdapter()

    override fun clickItem(position: Int) {
        if (mAdapter != null) HouseDetailActivity.startHouseDetail(mContext,mAdapter!!.data[position].h_id)
    }

    override fun createPresenter(): MineColletConstract.Present = MineColletPresent()

    override fun getActivityLayoutId(): Int = R.layout.activity_refresh_list

    override fun initData() {
        type = intent.getIntExtra("type",0)
        super.initData()
        setTitleText(if (type == 0) "我的收藏" else "我的足迹")
    }

    override fun setData(data: SearchBean?) {
        if (data != null) setData(data.project)
    }
}