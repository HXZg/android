package com.micropole.minemodule.mvp.contract

import com.micropole.minemodule.bean.Code
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
interface SettingPWContract {
    interface View:BaseMvpView{
        fun setPW()
        fun getCode(code: Code)
    }
    interface Model{
        fun setPW(token:String,lat:String,lng:String,user_phone:String,code:String,new_user_pwd:String):Observable<BaseResponseEntity<Any>>
        fun getCode(phone:String): Observable<BaseResponseEntity<Code>>
    }
    abstract class Presenter:BaseMvpPresenter<Model,View>(){
        abstract fun setPW(user_phone:String,code:String,new_user_pwd:String,sure_PW:String)
        abstract fun getCode(phone:String)

    }
}