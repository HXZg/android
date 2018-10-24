package com.micropole.loginmodule.mvp.contract

import com.micropole.loginmodule.bean.Code
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:
 */
interface RegisterContract {
    interface View :BaseMvpView{
        fun register(msg:String)
        fun getCode(code:Code)
    }
    interface Model{
        fun register(phone:String,pwd:String,yzm:String,nickname:String): Observable<BaseResponseEntity<Any>>
        fun getCode(phone:String): Observable<BaseResponseEntity<Code>>
    }
    abstract class Presenter:BaseMvpPresenter<Model,View>(){
        abstract fun register(phone:String,pwd:String,surePW:String,yzm:String,nickname:String)
        abstract fun getCode(phone:String)
    }
}