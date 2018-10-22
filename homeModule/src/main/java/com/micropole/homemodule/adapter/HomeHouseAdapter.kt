package com.micropole.homemodule.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.homemodule.R
import com.micropole.homemodule.entity.HomeBean

/**
 * @ClassName       HomeHouseAdapter
 * @Description     首页为您推荐
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/18 16:27
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HomeHouseAdapter : BaseQuickAdapter<HomeBean.ProjectBean,BaseViewHolder>(R.layout.item_house_view){
    override fun convert(helper: BaseViewHolder?, item: HomeBean.ProjectBean?) {

    }
}