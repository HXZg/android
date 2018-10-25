package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.entity.NewsBean
import com.micropole.homemodule.mvp.constract.MineNoticeConstract
import com.micropole.homemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       MineColletModel
 * @Description     消息列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 14:32
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineNoticeModel : MineNoticeConstract.Model() {
    override fun newslist(token: String, lat: String, lng: String, page: Int): Observable<BaseResponseEntity<List<NewsBean>>> {
        return AppApi.Api<AppService>().newsList(token, lat, lng, page)
    }
}