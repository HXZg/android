package com.micropole.homemodule.util

import android.widget.ImageView
import com.alibaba.android.arouter.launcher.ARouter
import com.chad.library.adapter.base.BaseViewHolder
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.network.AppService
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.extensions.loadImag

/**
 * @ClassName       Extentions
 * @Description     方法扩展
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/23 9:39
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
fun BaseMvpView.refreshToken(msg:String,action:()->Unit = {}){
    if (msg == "333"){
        AppApi.Api<AppService>()
    }else if (msg == "444"){
        Constants.loginOut()  //退出登录
        ARouter.getInstance().build(ARouterConst.Login.LOGIN_ACTIVITY).navigation()
        showToast("请重新登录")
    }else{
        showToast(msg)
    }
}

fun BaseViewHolder.loadImg(id:Int,url:String?,isCornor:Int = 0){
    this.getView<ImageView>(id).loadImag(url,radio = isCornor)
}



