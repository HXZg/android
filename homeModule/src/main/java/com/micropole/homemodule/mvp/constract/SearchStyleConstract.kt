package com.micropole.homemodule.mvp.constract

import com.micropole.homemodule.entity.SearchBean
import com.micropole.homemodule.entity.SearchStyleBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       SearchStyleConstract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/23 14:13
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SearchStyleConstract {
    interface View:BaseMvpView{
        fun getStyleData(data:List<SearchStyleBean>?)
        fun getSearchData(data:SearchBean)
        fun refreshError()
    }

    abstract class Model{
        abstract fun getStyleData(lat:String,lng:String) : Observable<BaseResponseEntity<List<SearchStyleBean>>>
        abstract fun getSearchData(lat:String,lng:String,styleId:String,type:Int,page:Int,startTime:String,endTime:String,num:String) : Observable<BaseResponseEntity<SearchBean>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun getStyleData()
        abstract fun getSearchData(lat:String,lng:String,styleId:String,type:Int,page:Int,startTime:String,endTime:String,num:String)
    }
}