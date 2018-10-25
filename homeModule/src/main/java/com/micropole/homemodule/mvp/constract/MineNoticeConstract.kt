package com.micropole.homemodule.mvp.constract

import com.micropole.homemodule.entity.NewsBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       MineColletConstract
 * @Description     收藏，足迹
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 14:29
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class MineNoticeConstract {

    interface View:BaseMvpView{
        fun newsList(data : List<NewsBean>?)
        fun refreshError()
    }

    abstract class Model {
        abstract fun newslist(token:String,lat:String,lng:String,page : Int) : Observable<BaseResponseEntity<List<NewsBean>>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun newsList(page : Int)
    }
}