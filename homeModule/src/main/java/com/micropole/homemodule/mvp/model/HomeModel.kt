package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.mvp.constract.HomeConstract
import com.micropole.homemodule.network.AppService

/**
 * @ClassName       HomeModel
 * @Description     首页
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 17:19
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HomeModel : HomeConstract.Model(){
    override fun getHomeData(lat:String,lng:String) =
            AppApi.Api<AppService>().homeData(lat, lng)
}