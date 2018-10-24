package com.micropole.homemodule.mvp.constract

import com.micropole.homemodule.entity.OrderDetailBean
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       OrderDetailConstract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/24 16:53
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderDetailConstract {

    interface View : BaseMvpLcecView<OrderDetailBean?>{

    }

    abstract class Model{
        abstract fun orderDetail(token:String,lat:String,lng:String,orderId:String) : Observable<BaseResponseEntity<OrderDetailBean>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun orderDetail(orderId:String)
    }
}