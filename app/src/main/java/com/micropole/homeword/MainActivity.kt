package com.micropole.homeword

import android.content.Intent
import android.graphics.Color
import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.ActivityUtils
import com.micropole.baseapplibrary.R
import com.micropole.baseapplibrary.activity.BaseNavigationActivity
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.baseapplibrary.constants.Constants
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView

class MainActivity : BaseNavigationActivity() {

    override fun getDataSize(): Int = 3

    override fun getPagerTitleView(index: Int): net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView {
        val commonPagerTitleView = CommonPagerTitleView(this)
        // load custom layout
        val mBottomDrawable = arrayListOf(R.drawable.ic_homepage_n,R.drawable.ic_placeanorder_n,R.drawable.ic_my_n)
        val mBottomDrawables = arrayListOf(R.drawable.ic_homepage_s,R.drawable.ic_placeanorder_s,R.drawable.ic_my_s)
        val mBottomTitle = arrayListOf("首页","订单","个人中心")
        val customLayout = LayoutInflater.from(this).inflate(R.layout.simple_pager_title_layout, null)
        val titleImg = customLayout.findViewById<View>(R.id.title_img) as ImageView
        val titleText = customLayout.findViewById<View>(R.id.title_text) as TextView
        titleImg.setImageResource(mBottomDrawable[index])
        titleText.text = mBottomTitle[index]
        commonPagerTitleView.setContentView(customLayout)

        commonPagerTitleView.onPagerTitleChangeListener = object : CommonPagerTitleView.OnPagerTitleChangeListener {

            override fun onSelected(index: Int, totalCount: Int) {
                titleImg.setImageResource(mBottomDrawables[index])
            }

            override fun onDeselected(index: Int, totalCount: Int) {
                titleImg.setImageResource(mBottomDrawable[index])
            }

            override fun onLeave(index: Int, totalCount: Int, leavePercent: Float, leftToRight: Boolean) {
            }

            override fun onEnter(index: Int, totalCount: Int, enterPercent: Float, leftToRight: Boolean) {
            }
        }

        commonPagerTitleView.setOnClickListener {
            checkItem(index)
        }

        return commonPagerTitleView
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
