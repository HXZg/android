package com.micropole.homemodule.mvp.present

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.mvp.constract.ReportHouseConstract
import com.micropole.homemodule.mvp.model.ReportHouseModel
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       ReportHousePresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/24 13:50
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ReportHousePresent : ReportHouseConstract.Present() {
    override fun reportHotel(h_id: String, content: String) {
        if (h_id.isEmpty() || content.isEmpty()) {
            getView()?.showToast("举报内容不能为空")
            return
        }
        getView()?.showLoadingDialog("正在举报")
        getModel().reportHotel(Constants.SHORT_TOKEN,Constants.getLocation()[0],Constants.getLocation()[1],h_id,content)
                .ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.showToast(it.msg)
                    getView()?.finishActivity()
                },{
                    getView()?.dismissLoadingDialog()
                    getView()?.refreshToken(it,{reportHotel(h_id, content)})
                })
    }

    override fun createModel(): ReportHouseConstract.Model = ReportHouseModel()
}