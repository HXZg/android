package com.micropole.homemodule.mvp.present

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.mvp.constract.SearchStyleConstract
import com.micropole.homemodule.mvp.model.SearchStyleModel
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.handler
import com.xx.baseutilslibrary.extensions.start_finish
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       SearchStylePresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/23 14:17
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SearchStylePresent : SearchStyleConstract.Present() {
    override fun getStyleData() {
        getView()?.showLoadingDialog("正在获取")
        getModel().getStyleData(Constants.getLocation()[0],Constants.getLocation()[1]).ui({
            getView()?.getStyleData(it.data)
        },{
            getView()?.showToast(it)
        })
    }

    override fun getSearchData(styleId:String,type:Int,page:Int,startTime:String,endTime:String,num:String) {
        if (styleId.isEmpty() || startTime.isEmpty() || endTime.isEmpty() || num.isEmpty()){
            return
        }
        if (page == 1) getView()?.showLoadingDialog("正在获取")
        getModel().getSearchData(Constants.getLocation()[0],Constants.getLocation()[1],styleId, type, page, startTime, endTime, num)
                .ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.getSearchData(it.data!!)
                },{
                    getView()?.dismissLoadingDialog()
                    getView()?.showToast(it)
                })

    }

    override fun createModel(): SearchStyleConstract.Model = SearchStyleModel()
}