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

    const val MAIN = "/main"
    object Main{
        const val MAIN_PAY_CENTER = "$MAIN/pay_center_activity"
        const val MAIN_MAP = "$MAIN/map_activity"
    }

    const val HOME = "/home"
    object Home{
        const val HOME_FRAGMENT = "$HOME/home_fragment"
    }

    const val ORDER = "/order"
    object Order{
        const val ORDER_FRAGEMENT = "$HOME/order_fragment"
        const val ORDERLIST_FRAGEMENT = "$HOME/orderlist_fragment"
    }

    const val MINE = "/mine"
    object Mine{
        const val MINE_FRAGMENT = "$MINE/mine_fragment"
        const val MINE_COLLECT = "$HOME/mine_collect_activity"
        const val MINE_NOTICE = "$HOME/mine_notice_activity"
    }
}