package com.micropole.homemodule.mvp.present

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.mvp.constract.OrderListConstract
import com.micropole.homemodule.mvp.model.OrderListModel
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui
import com.xx.baseutilslibrary.network.exception.ApiFaileException

/**
 * @ClassName       OrderListPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/24 15:49
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderListPresent : OrderListConstract.Present() {
    override fun createModel(): OrderListConstract.Model {
        return OrderListModel()
    }

    override fun orderList(staut: Int, page: Int) {
        if (page == 1)getView()?.showLoadingDialog("正在获取")
        getModel().orderList(Constants.SHORT_TOKEN,Constants.getLocation()[0],Constants.getLocation()[1],staut, page)
                .ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.setData(it.data)},{
                    getView()?.dismissLoadingDialog()
                    if (it == "444" && !Constants.SHORT_TOKEN.isEmpty()) getView()?.loginOut()
                    else if (it != "333") {
                        getView()?.refreshError()
                        getView()?.refreshToken(it,{orderList(staut,page)})
                    }else{
                        getView()?.refreshToken(it,{orderList(staut,page)})
                    }
                })
    }
}