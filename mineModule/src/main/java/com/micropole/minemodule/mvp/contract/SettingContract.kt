package com.micropole.minemodule.mvp.contract

import com.micropole.minemodule.bean.ImageViewUri
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
interface SettingContract {
    interface View:BaseMvpView{
        fun setInfo()
        fun setImageURI(imageUri:ImageViewUri)

    }
    interface Model{
        fun setInfo(token:String,lat:String,lng:String,nickname:String,user_sex:String,user_img	:String):Observable<BaseResponseEntity<Any>>
        fun setImageUri(img:String):Observable<BaseResponseEntity<ImageViewUri>>
    }
    abstract class Presenter:BaseMvpPresenter<Model,View>(){
       abstract fun setInfo(nickname:String,user_sex:String,user_img:String)
        abstract fun setImageUri(img:String)
    }
}