package com.micropole.homemodule.mvp.present

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.mvp.constract.MineNoticeConstract
import com.micropole.homemodule.mvp.model.MineNoticeModel
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       MineColletPresent
 * @Description     消息列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 14:31
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineNoticePresent : MineNoticeConstract.Present(){
    override fun newsList(page: Int) {
        if (page == 1) getView()?.showLoadingDialog("加载中。。。")
        getModel().newslist(Constants.SHORT_TOKEN,Constants.getLocation()[0],Constants.getLocation()[1],page)
                .ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.newsList(it.data)
                },{
                    getView()?.dismissLoadingDialog()
                    if (it != "333") getView()?.refreshError()
                    getView()?.refreshToken(it,{newsList(page)})
                })
    }

    override fun createModel(): MineNoticeConstract.Model {
        return MineNoticeModel()
    }
}