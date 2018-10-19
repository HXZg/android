package com.micropole.minemodule.dapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.minemodule.R

/**
 * author: xiaoguagnfei
 * date: 2018/10/19
 * describe:
 */
class TripIntraAdapter(data:List<String>):BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_trip_intra) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: String?) {
    }

}