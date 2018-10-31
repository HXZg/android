package com.micropole.homeword

import com.alibaba.android.arouter.launcher.ARouter
import com.micropole.baseapplibrary.BaseApplication
import com.micropole.baseapplibrary.BuildConfig
import com.micropole.homeword.util.CrashException
import com.micropole.homeword.util.LocationManagerUtil
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.PlatformConfig
import com.xx.anypay.WxAppIDProvider
import com.xx.anypay.XxAnyPay

/**
 * @ClassName       App
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 15:11
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class App : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
        LocationManagerUtil.getInstance().init(this)
        UMInit()
        CrashException().initException(this)
        XxAnyPay.intance.init(this)
        XxAnyPay.intance.wxAppIDProvider = object : WxAppIDProvider {
            override val weChatAppID: String
                get() = "wxe13c15b520e07f80"
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