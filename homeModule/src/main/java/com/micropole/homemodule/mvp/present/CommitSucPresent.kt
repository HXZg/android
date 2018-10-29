package com.micropole.homemodule.mvp.present

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.mvp.constract.CommitSucConstract
import com.micropole.homemodule.mvp.model.CommitSucModel
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       CommitSucPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/29 9:57
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CommitSucPresent : CommitSucConstract.Present() {
    override fun getUserPhone(h_id: String) {
        getView()?.showLoadingDialog("正在获取")
        getModel().getUserPhone(Constants.SHORT_TOKEN,Constants.getLocation()[0],Constants.getLocation()[1],h_id)
                .ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.userPhone(it.data)},{
                    getView()?.dismissLoadingDialog()
                    getView()?.refreshToken(it,{getUserPhone(h_id)})
                })
    }

    override fun orderDetail(orderId: String) {
        getView()?.showLoadingDialog("")
        getModel().orderDetail(Constants.SHORT_TOKEN,Constants.getLocation()[0],Constants.getLocation()[1],orderId)
                .ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.getDetail(it.data!!)},{
                    getView()?.dismissLoadingDialog()
                    getView()?.refreshToken(it,{orderDetail(orderId)})})
    }

    override fun createModel(): CommitSucConstract.Model = CommitSucModel()
}