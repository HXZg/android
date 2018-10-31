package com.micropole.homeword

import android.Manifest
import android.util.Log
import com.blankj.utilcode.util.PermissionUtils
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.baseapplibrary.util.LocationUtils
import com.micropole.homeword.util.LocationManagerUtil
import com.weibiaogan.bangbang.common.getAddress
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import java.util.*

/**
 * @ClassName       SplashActivity
 * @Description     启动页
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/18 17:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SplashActivity : BaseMvpViewActivity(){
    override fun getActivityLayoutId(): Int = R.layout.activity_splash

    override fun initData() {
        PermissionUtils.permission(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CHANGE_WIFI_STATE).callback(object : PermissionUtils.SimpleCallback {
            override fun onGranted() {
                Log.e("location_Tag","权限")
                startMain()
            }

            override fun onDenied() {
                Log.e("location_Tag","没权限")
                startMain()
            }

        }).rationale { it.again(true) }.request()

    }

    fun startMain(){
        LocationManagerUtil.getInstance().startLocation()
        Timer().schedule(object : TimerTask() {
            override fun run() {
                if (Constants.isFirst()) startActivity(GuideActivity::class.java)
                else startActivity(MainActivity::class.java)
            }
        },1500)
    }

    override fun initEvent() {
    }
}