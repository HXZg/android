package com.micropole.homemodule.mvp.present

import com.micropole.homemodule.mvp.constract.HomeConstract
import com.micropole.homemodule.mvp.model.HomeModel
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       HomePresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 17:19
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HomePresent : HomeConstract.Present() {
    override fun getHomeData() {
        getModel().getHomeData("","","","").ui({getView()?.setData(it.data)},{})
    }

    override fun createModel(): HomeConstract.Model {
        return HomeModel()
    }
}