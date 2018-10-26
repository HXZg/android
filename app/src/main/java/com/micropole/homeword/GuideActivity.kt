package com.micropole.homeword

import android.graphics.Color
import com.blankj.utilcode.util.ActivityUtils
import com.micropole.homeword.util.adapter.GuideAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_guide.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator

/**
 * @ClassName       GuideActivity
 * @Description     向导页
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/18 17:51
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class GuideActivity : BaseMvpViewActivity(){

    override fun getActivityLayoutId(): Int = R.layout.activity_guide

    override fun initData() {
        ActivityUtils.finishActivity(SplashActivity::class.java)
        vp_guide.adapter = GuideAdapter(supportFragmentManager, arrayListOf(GuideFragment.startGuide(0),GuideFragment.startGuide(1),GuideFragment.startGuide(2)))
        initMagicIndicator3()
    }

    override fun initEvent() {
    }

    private fun initMagicIndicator3() {
        val circleNavigator = CircleNavigator(this)
        circleNavigator.circleCount = 3
        circleNavigator.circleColor = Color.parseColor("#DDDDDD")
        circleNavigator.circleClickListener = CircleNavigator.OnCircleClickListener { index -> vp_guide.currentItem = index }
        magic_guide.navigator = circleNavigator
        ViewPagerHelper.bind(magic_guide, vp_guide)
    }


}