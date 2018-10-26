package com.micropole.homemodule.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.homemodule.R
import com.micropole.homemodule.entity.NewsBean

/**
 * @ClassName       EvaluationListAdapter
 * @Description     消息列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 11:19
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineNoticeAdapter : BaseQuickAdapter<NewsBean,BaseViewHolder>(R.layout.item_notice_view){
    override fun convert(helper: BaseViewHolder?, item: NewsBean?) {
            helper?.run {
                setText(R.id.tv_notice_status,item?.new_title)
                setText(R.id.tv_notice_des,item?.new_text)
            }
    }
}