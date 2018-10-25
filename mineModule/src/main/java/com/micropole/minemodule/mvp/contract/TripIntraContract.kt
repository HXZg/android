package com.micropole.minemodule.mvp.contract

import com.micropole.minemodule.bean.Trip
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/24
 * describe:
 */
interface TripIntraContract {
    interface View:BaseMvpView{
        fun getTripList(trip:List<Trip>)

    }
    interface Model{
        fun getTripList(token:String,lat:String,lng:String ,page:String):Observable<BaseResponseEntity<List<Trip>>>

    }
    abstract class Presenter:BaseMvpPresenter<Model,View>(){
       abstract fun getTripList(page:String)
    }
}