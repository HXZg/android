package com.micropole.minemodule.mvp.contract

import com.micropole.minemodule.bean.ImageViewUri
import com.micropole.minemodule.bean.RefreshTokenBean
import com.micropole.minemodule.bean.UserInfo
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/24
 * describe:
 */
interface HouserOwnerContract {
    interface View:BaseMvpView{
        fun setImage(src:String)
        fun beHouse()

    }
    interface Model{
        fun setImage(img:String):Observable<BaseResponseEntity<ImageViewUri>>
        fun beHouse(token:String,lat:String,lng:String,a_nickname:String,a_idcard:String,a_front_idcard:String,a_verso_idcard:String):Observable<BaseResponseEntity<Any>>

    }
    abstract class Presenter:BaseMvpPresenter<Model,View>(){
        abstract fun setImage(img:String)
        abstract fun beHouse(a_nickname:String,a_idcard:String,a_front_idcard:String,a_verso_idcard:String)

    }
}