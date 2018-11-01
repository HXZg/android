package com.micropole.homemodule.mvp.constract

import com.micropole.homemodule.entity.BookingBean
import com.micropole.homemodule.entity.HouseDetailBean
import com.micropole.homemodule.entity.LandlordBean
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

    interface View:BaseMvpLcecView<HouseDetailBean?>{
        fun userPhone(bean:LandlordBean?)
        fun collectSuc(isFollow : Boolean)
    }

    abstract class Model{
        abstract fun getHouseDetail(token:String,lat:String,lng:String,h_id:String,startTime:String,endTime:String): Observable<BaseResponseEntity<HouseDetailBean>>
        abstract fun collectHouse(token:String,lat:String,lng:String,h_id:String,type:Int) : Observable<BaseResponseEntity<Any>>
        abstract fun getUserPhone(token:String,lat:String,lng:String,h_id:String) : Observable<BaseResponseEntity<LandlordBean>>
    }

    abstract class Present : BaseMvpPresenter<Model,View>(){
        abstract fun getHouseDetail(h_id: String,startTime:String,endTime:String)
        abstract fun collectHouse(h_id: String,type:Int)
        abstract fun getUserPhone(h_id:String)
    }
}