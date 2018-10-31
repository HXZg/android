package com.micropole.homemodule.mvp.present

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.mvp.constract.EvaluationConstract
import com.micropole.homemodule.mvp.model.EvaluationModel
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       EvaluationPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/26 15:08
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationPresent : EvaluationConstract.Present() {
    override fun upImage(image: String) {
        getModel().upImage(image).ui({getView()?.upImage(it.data!!)},{getView()?.showToast(it)})
    }

    override fun evaOrder(orderId: String, hId: String, score: String, content: String, pic: String) {
        if (content.isEmpty()){
            getView()?.showToast("评价内容不能为空")
            return
        }
        getModel().evaOrder(Constants.SHORT_TOKEN,Constants.getLocation()[0],Constants.getLocation()[1],orderId, hId, score, content, pic)
                .ui({
                    getView()?.showToast(it.msg)
                    getView()?.dismissLoadingDialog()
                },{
                    getView()?.refreshToken(it)
                    getView()?.dismissLoadingDialog()
                })
    }

    override fun createModel(): EvaluationConstract.Model = EvaluationModel()
}