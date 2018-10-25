package com.micropole.homemodule.mvp.present

import com.blankj.utilcode.util.DeviceUtils.getModel
import com.blankj.utilcode.util.SnackbarUtils.getView
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.mvp.constract.FillOrderConstract
import com.micropole.homemodule.mvp.model.FillOrderModel
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       FillOrderPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 17:04
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class FillOrderPresent : FillOrderConstract.Present(){
    override fun commitOrder(h_id: String, startTime: String, endTime: String, num: Int, balance: Int, nickName: String, idCard: String, phone: String) {
        getView()?.showLoadingDialog("正在提交")
        getModel()?.commitOrder(Constants.SHORT_TOKEN, Constants.getLocation()[0], Constants.getLocation()[1],h_id,startTime, endTime, num, balance,nickName, idCard, phone)
                .ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.commit(it.data)
                },{
                    getView()?.dismissLoadingDialog()
                    getView()?.refreshToken(it,{commitOrder(h_id, startTime, endTime, num, balance, nickName, idCard, phone)})
                })
    }

    override fun bookingHouse(h_id: String, startTime: String, endTime: String, num: Int, balance: Int) {
        if (Constants.isLogin()){
            getView()?.showLoadingDialog("正在预订")
            getModel().bookingHouse(Constants.SHORT_TOKEN, Constants.getLocation()[0], Constants.getLocation()[1],h_id,startTime, endTime, num, balance)
                    .ui({
                        getView()?.dismissLoadingDialog()
                        getView()?.bookingSuc(it.data)
                    },{
                        getView()?.dismissLoadingDialog()
                        getView()?.refreshToken(it,{bookingHouse(h_id, startTime, endTime, num, balance)})
                    })
        }else{
            getView()?.showToast("请先登录")
        }
    }

    override fun createModel(): FillOrderConstract.Model {
        return FillOrderModel()
    }
}