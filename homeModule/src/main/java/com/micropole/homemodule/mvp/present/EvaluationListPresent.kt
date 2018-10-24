package com.micropole.homemodule.mvp.present

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.mvp.constract.EvaluationListConstract
import com.micropole.homemodule.mvp.model.EvaluationListModel
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       EvaluationListPresent
 * @Description     评论列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 11:15
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationListPresent : EvaluationListConstract.Present(){
    override fun getEvaluationData(h_id: String, page: Int) {
        if (h_id.isEmpty()) return   //房源id不为null
        getModel().getEvaluationData(Constants.getLocation()[0],Constants.getLocation()[1],h_id,page)
                .ui({getView()?.getEvaluationData(it.data)},{
                    getView()?.refreshError()
                    getView()?.showToast(it)})
    }

    override fun createModel(): EvaluationListConstract.Model {
        return EvaluationListModel()
    }
}