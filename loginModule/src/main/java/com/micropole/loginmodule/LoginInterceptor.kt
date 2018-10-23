package com.micropole.loginmodule

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.baseapplibrary.constants.Constants

/**
 * @ClassName       LoginInterceptor
 * @Description     登录拦截器
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/9/19 10:57
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Interceptor(priority = 1,name = "login")
class LoginInterceptor : IInterceptor {
    var mContext : Context? = null
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        if (postcard?.extra == ARouterConst.LOGIN_EXTRA && !Constants.isLogin()){
            ARouter.getInstance().build(ARouterConst.Login.LOGIN_ACTIVITY).navigation()
            callback?.onInterrupt(null)
        }else{
            callback?.onContinue(postcard)
        }
    }

    override fun init(context: Context?) {
        mContext = context
    }
}