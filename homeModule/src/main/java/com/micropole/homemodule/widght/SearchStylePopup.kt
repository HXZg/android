package com.micropole.homemodule.widght

import android.content.Context
import android.support.annotation.IdRes
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.flyco.dialog.widget.popup.base.BasePopup
import com.micropole.homemodule.R
import com.micropole.homemodule.entity.SearchStyleBean

/**
 * author: HuaiXianZhong
 * date: 2018/8/14
 * describe:
 */
class SearchStylePopup(context: Context,val data: List<SearchStyleBean>, val listener:(id:Int)->Unit) : BasePopup<SearchStylePopup>(context) {
    override fun setUiBeforShow() {
        var params = LinearLayout.LayoutParams(mAnchorView.width,LinearLayout.LayoutParams.WRAP_CONTENT)
        getView<LinearLayout>(R.id.ll_search_style).layoutParams = params
        val view = getView<RecyclerView>(R.id.rv_search_style)
        view.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        val adapter = object : BaseQuickAdapter<SearchStyleBean, BaseViewHolder>(R.layout.item_style_view, data) {
            override fun convert(helper: BaseViewHolder?, item: SearchStyleBean?) {
                helper?.setText(R.id.tv_style,item?.area_name)
            }
        }
        view.adapter = adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            listener.invoke(position)
            dismiss()
        }
    }

    override fun onCreatePopupView(): View {
        return View.inflate(mContext,R.layout.view_search_style,null)
    }

    fun <T: View> getView(@IdRes id: Int) = mWrappedView.findViewById<T>(id)

}