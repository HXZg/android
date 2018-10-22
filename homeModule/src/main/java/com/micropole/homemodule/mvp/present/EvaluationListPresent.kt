package com.micropole.homemodule.mvp.present

import com.micropole.homemodule.mvp.constract.EvaluationListConstract
import com.micropole.homemodule.mvp.model.EvaluationListModel

/**
 * @ClassName       EvaluationListPresent
 * @Description     评论列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 11:15
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationListPresent : EvaluationListConstract.Present(){
    override fun createModel(): EvaluationListConstract.Model {
        return EvaluationListModel()
    }
}