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
class OrderPriceAdapter(val isFillOrder : Boolean = false) : BaseQuickAdapter<List<String>,BaseViewHolder>(R.layout.item_order_detail_price_view){
    var isFree : String = "2"
    override fun convert(helper: BaseViewHolder?, item: List<String>?) {
        helper?.run {
            if (item != null){
                if (isFillOrder){
                    if (item[1].contains("-")){
                        setGone(R.id.iv_slide_btn,true)
                        addOnClickListener(R.id.iv_slide_btn)
                    }
                    if (item[0].contains("押金") && isFree == "1"){
                        setGone(R.id.stv_zmm,true)
                        addOnClickListener(R.id.stv_zmm)
                    }
                }
                setText(R.id.tv_price_name,item[0])
                setText(R.id.tv_price_t,item[1] + "元")
            }
        }
    }
}