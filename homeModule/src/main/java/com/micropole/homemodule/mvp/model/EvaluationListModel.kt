package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.entity.EvaluationBean
import com.micropole.homemodule.mvp.constract.EvaluationListConstract
import com.micropole.homemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       EvaluationListModel
 * @Description     评论列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 11:15
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationListModel : EvaluationListConstract.Model(){
    override fun getEvaluationData(lat: String, lng: String, h_id: String, page: Int): Observable<BaseResponseEntity<List<EvaluationBean>>> {
        return AppApi.Api<AppService>().getHouseComment(lat, lng, h_id, page)
    }
}