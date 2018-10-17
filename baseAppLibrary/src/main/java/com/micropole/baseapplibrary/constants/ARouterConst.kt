package com.micropole.baseapplibrary.constants

/**
 * @ClassName       ARouterConst
 * @Description     arouter 常量
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/16 15:26
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
object ARouterConst {

    const val LOGIN_EXTRA = 1  //登录拦截 常量

    const val LOGIN = "/login"
    object Login{
        const val LOGIN_ACTIVITY = "$LOGIN/login_activity"
        const val REGISTER_ACTIVITY = "$LOGIN/register_activity"
    }

    const val HOME = "/home"
    object Home{
        const val HOME_FRAGMENT = "$HOME/home_fragment"
    }

    const val ORDER = "/order"
    object Order{
        const val ORDER_FRAGEMENT = "$ORDER/order_fragment"
    }

    const val MINE = "/mine"
    object Mine{
        const val MINE_FRAGMENT = "$MINE/mine_fragment"
    }
}