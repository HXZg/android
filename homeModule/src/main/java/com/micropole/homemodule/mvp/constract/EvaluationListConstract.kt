package com.micropole.homemodule.mvp.constract

import com.micropole.homemodule.entity.EvaluationBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       EvaluationListConstract
 * @Description     评论列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 11:13
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationListConstract {

    interface View : BaseMvpView{
        fun getEvaluationData(data:List<EvaluationBean>?)
        fun refreshError()
    }

    abstract class Model{
        abstract fun getEvaluationData(lat:String,lng:String,h_id:String,page:Int) : Observable<BaseResponseEntity<List<EvaluationBean>>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){

        abstract fun getEvaluationData(h_id:String,page:Int)
    }
}