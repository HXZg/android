package com.micropole.homemodule.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.homemodule.R

/**
 * @ClassName       OrderPriceAdapter
 * @Description     订单详情价格
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 16:34
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderPriceAdapter : BaseQuickAdapter<List<String>,BaseViewHolder>(R.layout.item_order_detail_price_view){
    override fun convert(helper: BaseViewHolder?, item: List<String>?) {
        helper?.run {
            if (item != null){
                setText(R.id.tv_price_name,item[0])
                setText(R.id.tv_price_t,item[1] + "元")
            }
        }
    }
}