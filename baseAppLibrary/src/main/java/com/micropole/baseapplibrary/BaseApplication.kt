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
        Utils.init(this)
//        Stetho.initializeWithDefaults(this)

        Retrofit2Manager.instance.apiConfigProvider = object : XxApiConfigProvider {
            override fun getReleaseHost(): String = BuildConfig.RELEASE_DOMAIN

            override fun getDebugHost(): String = BuildConfig.DEV_DOMAIN

            override fun getApiRelativePath(): String = "/api/"

            override fun isDebug(): Boolean = false
        }
    }
}