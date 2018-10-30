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
        getView()?.showLoadingDialog("")
        getModel().getStyleData(Constants.lat,Constants.lng).ui({
            getView()?.getStyleData(it.data)
        },{
            getView()?.showToast(it)
        })
    }

    override fun getSearchData(lat:String,lng:String,styleId:String,type:Int,page:Int,startTime:String,endTime:String,num:String) {
        if (lat.isEmpty() || lng.isEmpty() || styleId.isEmpty() || type == 0 || startTime.isEmpty() || endTime.isEmpty() || num.isEmpty()) return
        getView()?.showLoadingDialog("")
        getModel().getSearchData(lat,lng,styleId, type, page, startTime, endTime, num)
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