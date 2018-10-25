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

    var SHORT_TOKEN = ""

    const val MAIN_INDEX_ARG = "main_index"

    const val KEY_IS_LOGIN = "is_login_key"
    const val KEY_LONG_TOKEN = "long_token_key"
    const val KEY_SHORT_TOKEN = "short_token_key"
    const val KEY_LOCATION = "location_key"
    const val KEY_IS_FIRST = "is_first"
    const val KEY_USER_ID = "user_id"
    const val KEY_USER_INFO = "user_info"


    fun isFirst() = SPUtils.getInstance().getBoolean(KEY_IS_FIRST,true)

    fun setNoFirst(){SPUtils.getInstance().put(KEY_IS_FIRST,false)}

    fun login(){SPUtils.getInstance().put(KEY_IS_LOGIN,true)}

    fun isLogin() : Boolean = SPUtils.getInstance().getBoolean(KEY_IS_LOGIN,false)

    fun loginOut(){SPUtils.getInstance().put(KEY_IS_LOGIN,false)}


    fun putLongToken(token : String){SPUtils.getInstance().put(KEY_LONG_TOKEN,token)}

    fun getLongToken() : String = SPUtils.getInstance().getString(KEY_LONG_TOKEN)

    fun putUserId(userId : String){SPUtils.getInstance().put(KEY_USER_ID,userId)}

    fun getUserId() : String = SPUtils.getInstance().getString(KEY_USER_ID)
    fun putUserInfo(userInfo: String){SPUtils.getInstance().put(KEY_USER_INFO,userInfo)}

    fun getUserInfo() : String {
        var user=SPUtils.getInstance().getString(KEY_USER_INFO)
        return user
    }

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