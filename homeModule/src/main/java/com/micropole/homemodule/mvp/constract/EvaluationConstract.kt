package com.micropole.homemodule.mvp.constract

import com.micropole.homemodule.entity.UpImageBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       EvaluationConstract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/26 15:02
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationConstract {

    interface View : BaseMvpView {
        fun upImage(bean : UpImageBean)
    }

    abstract class Model{
        abstract fun upImage(image:String) : Observable<BaseResponseEntity<UpImageBean>>
        abstract fun evaOrder(token:String,lat:String,lng:String,orderId:String,
                              hId:String,score:String,content:String,pic:String) : Observable<BaseResponseEntity<Any>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun upImage(image: String)
        abstract fun evaOrder(orderId:String, hId:String,score:String,content:String,pic:String)
    }
}