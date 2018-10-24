package com.weibiaogan.bangbang.common

import android.content.Context
import com.blankj.utilcode.util.EncryptUtils
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
