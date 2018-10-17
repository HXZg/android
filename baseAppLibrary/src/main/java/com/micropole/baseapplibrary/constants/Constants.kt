package com.micropole.baseapplibrary.constants

import com.blankj.utilcode.util.SPUtils

/**
 * @ClassName       Constants
 * @Description     常量存储
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/17 9:04
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
object Constants {

    const val MAIN_INDEX_ARG = "main_index"

    const val KEY_IS_LOGIN = "is_login_key"
    const val KEY_LOGIN_TOKEN = "login_token_key"
    const val KEY_LOCATION = "location_key"

    fun login(){SPUtils.getInstance().put(KEY_IS_LOGIN,true)}

    fun isLogin() : Boolean = SPUtils.getInstance().getBoolean(KEY_IS_LOGIN,false)

    fun loginOut(){SPUtils.getInstance().put(KEY_IS_LOGIN,false)}

    fun putToken(token : String){SPUtils.getInstance().put(KEY_LOGIN_TOKEN,token)}

    fun getToken() : String = SPUtils.getInstance().getString(KEY_LOGIN_TOKEN)

    /**
     * 存入经纬信息
     */
    fun putLocation(latitude: Double, longitude: Double, address: String) {
        SPUtils.getInstance().put(KEY_LOCATION, latitude.toString() + "," + longitude + "," + address)
    }

    /**
     * 获取经纬信息
     *
     * @return
     */
    fun getLocation(): Array<String> {
        return SPUtils.getInstance()
                .getString(KEY_LOCATION)
                .split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    }
}