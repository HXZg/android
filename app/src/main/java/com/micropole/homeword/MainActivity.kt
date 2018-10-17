package com.micropole.homeword

import android.content.Intent
import android.support.v4.app.Fragment
import android.view.KeyEvent
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.ActivityUtils
import com.micropole.baseapplibrary.activity.BaseNavigationActivity
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.baseapplibrary.constants.Constants
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView

class MainActivity : BaseNavigationActivity() {

    override fun getDataSize(): Int = 3

    override fun getPagerTitleView(index: Int): net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView {
        return  ClipPagerTitleView(this)
    }

    override fun getFragments(): List<Fragment> {
        var mFragments = arrayListOf<Fragment>()
        mFragments.add(ARouter.getInstance().build(ARouterConst.Home.HOME_FRAGMENT).navigation() as Fragment)
        mFragments.add(ARouter.getInstance().build(ARouterConst.Order.ORDER_FRAGEMENT).navigation() as Fragment)
        mFragments.add(ARouter.getInstance().build(ARouterConst.Mine.MINE_FRAGMENT).navigation() as Fragment)
        return mFragments
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent) //重新启动 main activity
        val index = intent?.getIntExtra(Constants.MAIN_INDEX_ARG, 0)
        if (index != null) checkItem(index)
    }


    /**
     * 双击退出APP
     */
    var mBackTime = 0L
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mBackTime < 1500){
                ActivityUtils.finishAllActivities(true)
            }else{
                mBackTime = System.currentTimeMillis()
                showToast("再按一次回到桌面")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}
