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
interface ForgetContract {
    interface View:BaseMvpView{
        fun  forget()
        fun getCode(code: Code)
    }
    interface Model{
        fun forget(phone:String,pwd:String,code:String): Observable<BaseResponseEntity<Any>>
        fun getCode(phone:String): Observable<BaseResponseEntity<Code>>
    }
    abstract class Presenter:BaseMvpPresenter<Model,View>(){
        abstract fun forget(phone:String,pwd:String,surePW:String,code:String)
        abstract fun getCode(phone:String)
    }
}