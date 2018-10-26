package com.micropole.homemodule.mvp.model

import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.entity.UpImageBean
import com.micropole.homemodule.mvp.constract.EvaluationConstract
import com.micropole.homemodule.network.AppService
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       EvaluationModel
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/26 15:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationModel : EvaluationConstract.Model() {
    override fun upImage(image: String): Observable<BaseResponseEntity<UpImageBean>> {
        return AppApi.Api<AppService>().upImage(image)
    }

    override fun evaOrder(token: String, lat: String, lng: String, orderId: String, hId: String, score: String, content: String, pic: String): Observable<BaseResponseEntity<Any>> {
        return AppApi.Api<AppService>().evaluationOrder(token,lat,lng,orderId,hId,score,content,pic)
    }
}