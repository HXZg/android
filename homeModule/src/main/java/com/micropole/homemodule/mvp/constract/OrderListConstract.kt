package com.micropole.homemodule.mvp.constract

import com.micropole.homemodule.entity.OrderListBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       OrderListConstract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/24 15:45
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderListConstract {

    interface View : BaseMvpLcecView<List<OrderListBean>?>{

    }

    abstract class Model{
        abstract fun orderList(token:String,lat:String,lng:String,staut: Int,page : Int) : Observable<BaseResponseEntity<List<OrderListBean>>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun orderList(staut: Int,page: Int)
    }
}