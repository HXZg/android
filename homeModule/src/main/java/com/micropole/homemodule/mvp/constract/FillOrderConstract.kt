package com.micropole.homemodule.mvp.constract

import com.micropole.homemodule.entity.BookingBean
import com.micropole.homemodule.entity.CommitOrderBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       FillOrderConstract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 16:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class FillOrderConstract {

    interface View : BaseMvpView{
        fun bookingSuc(bean : BookingBean?)
        fun commit(bean : CommitOrderBean?)
    }

    abstract class Model{
        abstract fun bookingHouse(token:String,lat:String,lng:String,h_id:String,
                                  startTime:String,endTime:String,num:Int,balance:Int) : Observable<BaseResponseEntity<BookingBean>>
        abstract fun commitOrder(token:String,lat:String,lng:String,h_id:String,
                                 startTime:String,endTime:String,num:Int,balance:Int,
                                 nickName:String,idCard:String,phone:String) : Observable<BaseResponseEntity<CommitOrderBean>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun bookingHouse(h_id: String,startTime:String,endTime:String,num:Int,balance:Int)
        abstract fun commitOrder(h_id:String, startTime:String,endTime:String,num:Int,balance:Int,
                                 nickName:String,idCard:String,phone:String)
    }
}