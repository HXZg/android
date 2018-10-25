package com.micropole.minemodule.dapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.minemodule.R
import com.micropole.minemodule.bean.Trip

/**
 * author: xiaoguagnfei
 * date: 2018/10/19
 * describe:
 */
class TripIntraAdapter(data:List<Trip>):BaseQuickAdapter<Trip,BaseViewHolder>(R.layout.item_trip_intra) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: Trip?) {
        helper?.setText(R.id.tv_name,item?.in_title)
        helper?.setText(R.id.tv_time,item?.add_time)
        if (item?.in_type.equals("1")){
            helper?.setText(R.id.tv_number,"+${item?.in_number}元")
        } else if (item?.in_type.equals("2")){
            helper?.setText(R.id.tv_number,"-${item?.in_number}元")
        }

    }

}