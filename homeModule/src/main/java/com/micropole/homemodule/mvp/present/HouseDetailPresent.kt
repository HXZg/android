package com.micropole.homemodule.mvp.present

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.mvp.constract.HouseDetailConstract
import com.micropole.homemodule.mvp.model.HouseDetailModel
import com.micropole.homemodule.network.AppService
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui
import com.xx.baseutilslibrary.network.exception.ApiFaileException

/**
 * @ClassName       HouseDetailPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/23 19:05
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HouseDetailPresent : HouseDetailConstract.Present() {

    override fun getUserPhone(h_id: String) {
        if (Constants.isLogin()){
            getView()?.showLoadingDialog("正在获取")
            getModel().getUserPhone(Constants.SHORT_TOKEN,Constants.getLocation()[0],Constants.getLocation()[1],h_id)
                    .ui({
                        getView()?.dismissLoadingDialog()
                        getView()?.userPhone(it.data)},{
                        getView()?.dismissLoadingDialog()
                        getView()?.refreshToken(it,{getUserPhone(h_id)})
                    })
        }else{
            getView()?.showToast("请先登录")
        }
    }

    override fun collectHouse(h_id: String) {
        if (Constants.isLogin()){
            getView()?.showLoadingDialog("正在收藏")
            getModel().collectHouse(Constants.SHORT_TOKEN,Constants.getLocation()[0],Constants.getLocation()[1],h_id)
                    .ui({
                        getView()?.collectSuc()
                        getView()?.dismissLoadingDialog()
                        getView()?.showToast(it.msg)},{
                        getView()?.dismissLoadingDialog()
                        getView()?.refreshToken(it,{collectHouse(h_id)})
                    })
        }else{
            getView()?.showToast("请先登录")
        }
    }

    override fun getHouseDetail(h_id: String,startTime:String,endTime:String) {
        val token = if (Constants.isLogin()) Constants.SHORT_TOKEN else ""
        getModel().getHouseDetail(token,Constants.getLocation()[0],Constants.getLocation()[1],h_id,startTime, endTime).ui({getView()?.setData(it.data)},{
            if (it == "333"){
                getView()?.refreshToken(it,{getHouseDetail(h_id,startTime,endTime)})
            } else if (it == "444"){
                Constants.loginOut()
                Constants.SHORT_TOKEN = ""
                getView()?.showToast("请重新登录")
                getHouseDetail(h_id,startTime, endTime)
            }else{
                getView()?.showError(ApiFaileException(it),true)
            }
        })
    }

    override fun createModel(): HouseDetailConstract.Model {
        return HouseDetailModel()
    }
}