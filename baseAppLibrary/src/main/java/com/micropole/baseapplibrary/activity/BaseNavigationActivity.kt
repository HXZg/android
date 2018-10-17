package com.micropole.baseapplibrary.activity

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.micropole.baseapplibrary.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_navigation.*
import net.lucode.hackware.magicindicator.FragmentContainerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView

/**
 * @ClassName       BaseNavigationActivity
 * @Description     底部导航栏 fragment activity
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/16 16:32
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
abstract class BaseNavigationActivity : BaseMvpViewActivity() {

    val mFragmentContainerHelper = FragmentContainerHelper()

    var mFragments : List<Fragment>? = null

    override fun getActivityLayoutId(): Int = R.layout.activity_navigation

    override fun initData() {
        initNavigation()
        if (getFragments().size == getDataSize()) mFragments = getFragments() else throw RuntimeException("fragment size must be equal data size")
        checkItem(0)
    }

    fun checkItem(index: Int) {
        mFragmentContainerHelper.handlePageSelected(index, false)
        swithPagers(index)
    }

    override fun initEvent() {
    }

    fun initNavigation(){
        val commonNavigator = CommonNavigator(this)
        commonNavigator.isAdjustMode = true
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getTitleView(p0: Context?, p1: Int): IPagerTitleView? {
                return getDefaultPagerTitleView(p1)
            }

            override fun getCount(): Int {
                return getDataSize()
            }

            override fun getIndicator(p0: Context?): IPagerIndicator? {
                return null
            }
        }
        navigation_magic.navigator = commonNavigator
        mFragmentContainerHelper.attachMagicIndicator(navigation_magic)
    }

    abstract fun getDataSize() : Int

    abstract fun getPagerTitleView(index : Int) : IPagerTitleView

    abstract fun getFragments() : List<Fragment>

    fun getDefaultPagerTitleView(index : Int) : IPagerTitleView{
        val commonPagerTitleView = CommonPagerTitleView(this)
        // load custom layout
        val customLayout = LayoutInflater.from(this).inflate(R.layout.simple_pager_title_layout, null)
        val titleImg = customLayout.findViewById<View>(R.id.title_img) as ImageView
        val titleText = customLayout.findViewById<View>(R.id.title_text) as TextView
        titleImg.setImageResource(R.mipmap.ic_launcher)
        titleText.text = "title$index"
        commonPagerTitleView.setContentView(customLayout)

        commonPagerTitleView.onPagerTitleChangeListener = object : CommonPagerTitleView.OnPagerTitleChangeListener {

            override fun onSelected(index: Int, totalCount: Int) {
                titleText.setTextColor(Color.BLACK)
            }

            override fun onDeselected(index: Int, totalCount: Int) {
                titleText.setTextColor(Color.GRAY)
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

    fun swithPagers(index : Int){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        var fragment: Fragment
        var i = 0
        val j = mFragments!!.size
        while (i < j) {
            if (i == index) {
                i++
                continue
            }
            fragment = mFragments!![i]
            if (fragment.isAdded) {
                fragmentTransaction.hide(fragment)
            }
            i++
        }
        fragment = mFragments!![index]
        if (fragment.isAdded) {
            fragmentTransaction.show(fragment)
        } else {
            fragmentTransaction.add(R.id.fl_content, fragment)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }

}