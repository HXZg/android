package com.micropole.homemodule.mvp.constract

import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       ReportHouseConstract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/24 13:49
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ReportHouseConstract {

    interface View : BaseMvpView{}

    abstract class Model{
        abstract fun reportHotel(token:String,lat:String,lng:String,h_id:String,content:String) : Observable<BaseResponseEntity<Any>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun reportHotel(h_id:String,content:String)
    }
}