package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.mvp.constract.SearchStyleConstract
import com.micropole.homemodule.network.AppService

/**
 * @ClassName       SearchStyleModel
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/23 14:17
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SearchStyleModel : SearchStyleConstract.Model() {
    override fun getStyleData(lat: String, lng: String) = AppApi.Api<AppService>().getStyleData(lat, lng)

    override fun getSearchData(lat:String,lng:String,styleId:String,type:Int,page:Int,startTime:String,endTime:String,num:String) =
            AppApi.Api<AppService>().getSearchData(lat, lng,styleId, type, page, startTime, endTime, num)
}