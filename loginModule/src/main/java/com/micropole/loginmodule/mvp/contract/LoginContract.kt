package com.micropole.loginmodule.mvp.contract

import com.micropole.loginmodule.bean.Login
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:
 */
interface LoginContract {
    interface View:BaseMvpView{
        fun login(login:Login)

    }
    interface Model{
        fun login(phone:String,sign:String): Observable<BaseResponseEntity<Login>>

    }
    abstract class Presenter:BaseMvpPresenter<Model,View>(){
        abstract fun login(phone:String,sign:String)

    }
}