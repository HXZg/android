package com.micropole.homemodule.mvp.present

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.mvp.constract.OrderDetailConstract
import com.micropole.homemodule.mvp.model.OrderDetailModel
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       OrderDetailPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/24 17:02
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderDetailPresent : OrderDetailConstract.Present() {
    override fun refundOrder(orderId: String) {
        getView()?.showLoadingDialog("正在取消")
        getModel().refundOrder(Constants.SHORT_TOKEN,Constants.getLocation()[0],Constants.getLocation()[1],orderId)
                .ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.showToast(it.msg)
                    getView()?.finishActivity()
                },{
                    getView()?.dismissLoadingDialog()
                    getView()?.refreshToken(it,{refundOrder(orderId)})
                })
    }

    override fun orderDetail(orderId: String) {
        getModel().orderDetail(Constants.SHORT_TOKEN,Constants.getLocation()[0],Constants.getLocation()[1],orderId)
                .ui({getView()?.setData(it.data)},{getView()?.refreshToken(it,{orderDetail(orderId)})})
    }

    override fun createModel(): OrderDetailConstract.Model = OrderDetailModel()
}