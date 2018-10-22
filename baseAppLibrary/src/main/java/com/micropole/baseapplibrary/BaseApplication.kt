package com.micropole.baseapplibrary

import android.support.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.Utils
import com.facebook.stetho.Stetho
import com.micropole.baseapplibrary.util.LocationManagerUtil
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.PlatformConfig
import com.xx.baseutilslibrary.network.provider.XxApiConfigProvider
import com.xx.baseutilslibrary.network.retrofit.Retrofit2Manager

//import com.alibaba.android.arouter.launcher.ARouter


/**
 * BaseApplication
 * 沉迷学习不能自拔
 * Describe：
 * Created by 雷小星🍀 on 2018/6/11 14:56.
 */
open class BaseApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
        Utils.init(this)
        Stetho.initializeWithDefaults(this)
        LocationManagerUtil.getInstance().init(this)

//        UMInit()

        Retrofit2Manager.instance.apiConfigProvider = object : XxApiConfigProvider {
            override fun getReleaseHost(): String = BuildConfig.RELEASE_DOMAIN

            override fun getDebugHost(): String = BuildConfig.DEV_DOMAIN

            override fun getApiRelativePath(): String = "/api/"

            override fun isDebug(): Boolean = false
        }
    }

    private fun UMInit() {
        //初始化友盟
        UMConfigure.init(this, "5b4c573e8f4a9d233f000140"
                , "umeng", UMConfigure.DEVICE_TYPE_PHONE, "")//  5af105248f4a9d6df300028a
        //PlatformConfig.setWeixin("wxd08a9b205494c248", "35c0bcca128270bd9b7ec01812fc97fa")
        PlatformConfig.setWeixin("wx97bb14db1693f6cf", "a217a89c349fa1fa4b4574dacb6a935b")
        PlatformConfig.setSinaWeibo("520026000", "0d858f5828e954e57ebd795782036c74", "http://v1.xj-yl.com/api/User/ThirdLogin")
        PlatformConfig.setQQZone("101492282", "75b744ba4e5febd8b9dcf581685d0557")
        //PlatformConfig.setAlipay("2018080860920512")
        //PlatformConfig.setQQZone("1106602798", "gDWIr2lY4PT4OIVa")
    }
}