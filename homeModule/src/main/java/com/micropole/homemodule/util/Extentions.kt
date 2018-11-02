package com.micropole.homemodule.util

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import cn.qqtheme.framework.picker.DatePicker
import com.alibaba.android.arouter.launcher.ARouter
import com.bigkoo.convenientbanner.ConvenientBanner
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.BaseViewHolder
import com.flyco.dialog.listener.OnBtnClickL
import com.flyco.dialog.widget.NormalDialog
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.R
import com.micropole.homemodule.network.AppService
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.extensions.format
import com.xx.baseutilslibrary.extensions.loadImag
import com.xx.baseutilslibrary.extensions.ui
import java.math.BigDecimal
import java.util.*

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

fun BaseViewHolder.loadImg(id:Int,url:String?,isCornor:Int = 0,isCircle : Boolean = false){
    this.getView<ImageView>(id).loadImag(url,radio = isCornor,isCircle = isCircle)
}

fun DatePicker.setRanger(year:Int = 0, month : Int = 0, day : Int = 0){
    var myear = if (year == 0) Calendar.getInstance().get(Calendar.YEAR) else year
    var mmonth = if (month == 0) Calendar.getInstance().get(Calendar.MONTH) + 1 else month
    var mday = if (day == 0) Calendar.getInstance().get(Calendar.DATE) else day
    setRangeStart(myear,mmonth,mday)
    setRangeEnd(myear+TimerUtil.DATE_RANGE,mmonth,mday)
}

fun ConvenientBanner<*>.setTurnImage(mImgs:List<String>,isturn : Long = 2000) : ConvenientBanner<*>{
    this as ConvenientBanner<String>
    setPages( { ImageHolderView() } , mImgs)
            setPageIndicator(intArrayOf(R.drawable.shape_indicator_gray, R.drawable.shape_indicator_red))
            setPointViewVisible(true)
            setOnItemClickListener {
                /*activity?.bannerStart(data[position])*/
                ToastUtils.showShort(it.toString())
            }
    if (isturn != 0L) startTurning(isturn)
    return this
}

fun View.setCheckLoginListener(action: (view:View) -> Unit){
    this.setOnClickListener {
        if (Constants.isLogin()){
            action.invoke(it)
        }else{
            ARouter.getInstance().build(ARouterConst.Login.LOGIN_ACTIVITY).navigation()
        }
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
            .btnTextColor(Color.parseColor("#3078EF"),Color.parseColor("#3078EF"))
            .setCancelable(false)
    dialog.setCanceledOnTouchOutside(false)
    dialog.show()
    dialog.setOnBtnClickL(OnBtnClickL { dialog.dismiss() },OnBtnClickL {
        dialog.dismiss()
        ARouter.getInstance().build(ARouterConst.Login.LOGIN_ACTIVITY).navigation()
    })
}

fun String.changeKm() : String{
    if (this.toDouble() >= 1000){
        var d = this.toDouble() / 100.00
        return d.format(2)+"km"
    }else{
        return this + "m"
    }
}



