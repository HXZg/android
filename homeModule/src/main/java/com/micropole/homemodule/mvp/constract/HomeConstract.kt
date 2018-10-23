package com.micropole.homemodule.mvp.constract

import com.micropole.homemodule.entity.HomeBean
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       HomeConstract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 17:18
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HomeConstract {

    interface View : BaseMvpLcecView<HomeBean>{

    }

    abstract class Model{
        abstract fun getHomeData(token:String,lat:String,lng:String) : Observable<BaseResponseEntity<HomeBean>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun getHomeData()
    }
}