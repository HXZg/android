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
interface SettingPhoneContract {
    interface View:BaseMvpView{
        fun setphone()
        fun getCode(code: Code)
    }
    interface Model{
        fun setPhone(token:String,lat:String,lng:String,old_user_phone:String,new_user_phone:String,new_code:String,old_code:String): Observable<BaseResponseEntity<Any>>
        fun getCode(phone:String): Observable<BaseResponseEntity<Code>>
    }
    abstract class Presenter:BaseMvpPresenter<Model,View>(){
        abstract fun setPhone(old_user_phone:String,new_user_phone:String,new_code:String,old_code:String)
        abstract fun getCode(phone:String)

    }
}