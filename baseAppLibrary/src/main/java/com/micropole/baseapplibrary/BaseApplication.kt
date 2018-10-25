package com.micropole.baseapplibrary

import android.support.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.Utils
import com.facebook.stetho.Stetho
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

        Retrofit2Manager.instance.apiConfigProvider = object : XxApiConfigProvider {
            override fun getReleaseHost(): String = BuildConfig.RELEASE_DOMAIN

            override fun getDebugHost(): String = BuildConfig.DEV_DOMAIN

            override fun getApiRelativePath(): String = "/api/"

            override fun isDebug(): Boolean = false
        }
    }
}