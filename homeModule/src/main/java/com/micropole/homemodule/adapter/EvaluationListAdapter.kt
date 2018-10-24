package com.micropole.homemodule.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.homemodule.R
import com.micropole.homemodule.entity.EvaluationBean
import com.micropole.homemodule.util.loadImg

/**
 * @ClassName       EvaluationListAdapter
 * @Description     评论列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 11:19
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationListAdapter : BaseQuickAdapter<EvaluationBean,BaseViewHolder>(R.layout.item_evaluation_view){
    override fun convert(helper: BaseViewHolder?, item: EvaluationBean?) {
        helper?.run {
            loadImg(R.id.iv_evaluation_img,item?.user_arr?.user_img,isCircle = true)
            setText(R.id.tv_evaluation_name,item?.user_arr?.nickname)
            setText(R.id.tv_evaluation_score,item?.comment_score)
            setText(R.id.tv_evaluation_des,item?.com_content)
            setText(R.id.tv_evaluation_time,item?.add_time)

            if (item?.com_pic == null || item.com_pic.isEmpty()){
                setGone(R.id.iv_evaluation_one,false)
                setGone(R.id.iv_evaluation_two,false)
                setGone(R.id.iv_evaluation_three,false)
            }else{
                if (item.com_pic.size > 1) loadImg(R.id.iv_evaluation_two,item.com_pic[1])
                if (item.com_pic.size > 2) loadImg(R.id.iv_evaluation_three,item.com_pic[2])
                loadImg(R.id.iv_evaluation_one,item.com_pic[0])
            }
        }
    }
}