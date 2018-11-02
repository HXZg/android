package com.micropole.minemodule.util

import android.graphics.Color
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.ActivityUtils
import com.flyco.dialog.listener.OnBtnClickL
import com.flyco.dialog.widget.NormalDialog
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
        if (Constants.SHORT_TOKEN.isEmpty()){
            Constants.SHORT_TOKEN = Constants.getShotToken()
            action.invoke()
            return
        }
        Constants.loginOut()  //退出登录
        showLoginDialog()
        showToast("请重新登录")
    }else{
        showToast(msg)
    }
}

fun showLoginDialog(){
    val context = ActivityUtils.getTopActivity()
    var dialog = NormalDialog(context)
    dialog.style(NormalDialog.STYLE_TWO)
            .content("状态异常，请重新登录")
            .title("提示")
            .style(NormalDialog.STYLE_TWO)
            .contentTextSize(17f)
            .titleTextSize(17f)
            .contentTextColor(Color.parseColor("#888888"))
            .titleTextColor(Color.parseColor("#222222"))
            .btnNum(2)
            .btnText("取消","确定")
            .btnTextColor(Color.parseColor("#3078EF"), Color.parseColor("#3078EF"))
            .setCancelable(false)
    dialog.setCanceledOnTouchOutside(false)
    dialog.show()
    dialog.setOnBtnClickL(OnBtnClickL { dialog.dismiss() },OnBtnClickL {
        dialog.dismiss()
        ARouter.getInstance().build(ARouterConst.Login.LOGIN_ACTIVITY).navigation()
    })
}