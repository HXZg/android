package com.micropole.homemodule.mvp.constract

import com.micropole.homemodule.entity.LandlordBean
import com.micropole.homemodule.entity.OrderDetailBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       CommitSucConstract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/29 9:54
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CommitSucConstract {

    interface View : BaseMvpView {
        fun getDetail(bean : OrderDetailBean)
        fun userPhone(bean : LandlordBean?)
    }

    abstract class Model{
        abstract fun orderDetail(token:String,lat:String,lng:String,orderId:String)  : Observable<BaseResponseEntity<OrderDetailBean>>
        abstract fun getUserPhone(token:String,lat:String,lng:String,h_id:String) : Observable<BaseResponseEntity<LandlordBean>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun orderDetail(orderId: String)
        abstract fun getUserPhone(h_id:String)
    }
}