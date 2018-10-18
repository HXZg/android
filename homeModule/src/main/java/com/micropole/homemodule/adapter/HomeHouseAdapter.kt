package com.micropole.homemodule.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.homemodule.R

/**
 * @ClassName       HomeHouseAdapter
 * @Description     首页为您推荐
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/18 16:27
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HomeHouseAdapter(data : List<Any>) : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.item_house_view,data){
    override fun convert(helper: BaseViewHolder?, item: Any?) {

    }
}