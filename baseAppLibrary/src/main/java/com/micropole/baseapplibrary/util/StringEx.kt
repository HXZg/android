package com.weibiaogan.bangbang.common

import android.content.Context
import android.location.*
import android.util.Log
import com.blankj.utilcode.util.*
import com.micropole.baseapplibrary.constants.Constants
import java.util.regex.Pattern

fun String.md5Salt():String = EncryptUtils.encryptMD5ToString(EncryptUtils.encryptMD5ToString(this + "mcjp")
                .toLowerCase()).toLowerCase()
fun Int.pxtodp(context: Context):Int{
    var scale = context.getResources().getDisplayMetrics().density
    return (this * scale + 0.5f).toInt()

}
fun String.isPhone():Boolean{
    // ^ 匹配输入字符串开始的位置
    // \d 匹配一个或多个数字，其中 \ 要转义，所以是 \\d
    // $ 匹配输入字符串结尾的位置
    var regExp = "^((13[0-9])|(15[0-3, 5-9])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$"
    var p = Pattern.compile(regExp)
    var m = p.matcher(this)
    return m.matches()
}
 fun String.isIDCard():Boolean{
     if (this.length!=18){
         return  false
     }
     if (!Pattern.matches("^\\d{15}$|^\\d{17}[0-9Xx]$",this)){
         return false
     }
    return true
}

fun getAddress(context: Context,location : Location,action : (s : String)-> Unit){
    val fromLocation = Geocoder(context).getFromLocation(location.latitude, location.longitude, 3)
    if (fromLocation.isNotEmpty()) {
        action.invoke(fromLocation[0].locality)
        Log.i("address_home_word",fromLocation[0].toString())
        Constants.putLocation(fromLocation[0].latitude,fromLocation[0].longitude,fromLocation[0].locality)
    }else{
        action.invoke("无法定位")
    }
}
