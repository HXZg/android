package com.micropole.homemodule.mvp.present

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.mvp.constract.MineColletConstract
import com.micropole.homemodule.mvp.model.MineColletModel
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       MineColletPresent
 * @Description     收藏 足迹
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 14:31
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineColletPresent : MineColletConstract.Present(){
    override fun collectFootList(type: Int, page: Int) {
        if (page == 1) getView()?.showLoadingDialog("加载中。。。")
        val observable =
                if (type == 0) getModel().collectList(Constants.SHORT_TOKEN, Constants.getLocation()[0], Constants.getLocation()[1], page)
                else getModel().footList(Constants.SHORT_TOKEN, Constants.getLocation()[0], Constants.getLocation()[1], page)

        observable.ui({
            getView()?.dismissLoadingDialog()
            getView()?.setData(it.data)
        },{
            getView()?.dismissLoadingDialog()
            if (it != "333") getView()?.refreshError()
            getView()?.refreshToken(it,{collectFootList(type, page)})
        })
    }

    override fun createModel(): MineColletConstract.Model {
        return MineColletModel()
    }
}