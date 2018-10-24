package com.micropole.homemodule.mvp.constract

import com.micropole.homemodule.entity.HouseDetailBean
import com.xx.baseuilibrary.mvp.lcec.BaseMvpLcecView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * @ClassName       HouseDetailConstract
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/23 19:03
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HouseDetailConstract {

    interface View:BaseMvpLcecView<HouseDetailBean?>{}

    abstract class Model{
        abstract fun getHouseDetail(token:String,lat:String,lng:String,h_id:String): Observable<BaseResponseEntity<HouseDetailBean>>
        abstract fun collectHouse(token:String,lat:String,lng:String,h_id:String) : Observable<BaseResponseEntity<Any>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun getHouseDetail(h_id: String)
        abstract fun collectHouse(h_id: String)
    }
}