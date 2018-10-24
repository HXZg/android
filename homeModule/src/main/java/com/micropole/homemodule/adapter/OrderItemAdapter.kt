package com.micropole.homemodule.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.homemodule.R
import com.micropole.homemodule.entity.OrderListBean
import com.micropole.homemodule.util.loadImg

/**
 * @ClassName       OrderItemAdapter
 * @Description     订单
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/19 10:13
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderItemAdapter() : BaseQuickAdapter<OrderListBean,BaseViewHolder>(R.layout.item_order_view) {
    override fun convert(helper: BaseViewHolder?, item: OrderListBean?) {
        helper?.run {
            loadImg(R.id.iv_order_img,item?.h_imgs,isCornor = 16)
            setText(R.id.tv_order_name,item?.h_title)
            setText(R.id.tv_order_time,"${item?.start_time}-${item?.end_time} 共${item?.few_nights}晚")
            setText(R.id.tv_order_price,"¥${item?.real_price}")
            setText(R.id.tv_order_status,item?.or_stat_detail)
        }
    }
}