package com.micropole.minemodule.util

import com.alibaba.android.arouter.launcher.ARouter
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.baseapplibrary.network.AppApi
import com.micropole.minemodule.network.AppService
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
fun BaseMvpView.refreshToken(msg:String, action:()->Unit = {}){
    if (msg == "333"){
        AppApi.Api<AppService>().refreshToken(Constants.getLongToken()).ui({
            Constants.SHORT_TOKEN = it?.data?.short_token!!
            action.invoke()},{refreshToken(it,action)})
    }else if (msg == "444"){
        Constants.loginOut()  //退出登录
        ARouter.getInstance().build(ARouterConst.Login.LOGIN_ACTIVITY).navigation()
        showToast("请重新登录")
    }else{
        showToast(msg)
    }
}