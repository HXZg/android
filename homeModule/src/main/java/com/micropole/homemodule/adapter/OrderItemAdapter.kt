package com.micropole.homemodule.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.homemodule.R

/**
 * @ClassName       OrderItemAdapter
 * @Description     订单
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/19 10:13
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderItemAdapter(data : List<Any>) : BaseQuickAdapter<Any,BaseViewHolder>(R.layout.item_order_view,data) {
    override fun convert(helper: BaseViewHolder?, item: Any?) {

    }
}