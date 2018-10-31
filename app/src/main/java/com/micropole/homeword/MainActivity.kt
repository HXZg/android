package com.micropole.homeword

import android.content.Intent
import android.graphics.Color
import android.support.v4.app.Fragment
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.amap.api.services.geocoder.GeocodeQuery
import com.amap.api.services.geocoder.GeocodeResult
import com.amap.api.services.geocoder.GeocodeSearch
import com.amap.api.services.geocoder.RegeocodeResult
import com.blankj.utilcode.util.ActivityUtils
import com.micropole.baseapplibrary.R
import com.micropole.baseapplibrary.activity.BaseNavigationActivity
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homeword.util.LocationManagerUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView

@Route(path = ARouterConst.Main.MAIN_MAIN)
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
        mFragments.add(ARouter.getInstance().build(ARouterConst.Order.ORDERLIST_FRAGEMENT).navigation() as Fragment)
        mFragments.add(ARouter.getInstance().build(ARouterConst.Mine.MINE_FRAGMENT).navigation() as Fragment)
        return mFragments
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent) //重新启动 main activity
        val index = intent?.getIntExtra(Constants.MAIN_INDEX_ARG, 0)
        if (index != null) checkItem(index)
    }

    var isInvoke = false
    override fun startLocation(action: (s: String) -> Unit) {
        isInvoke = false
        LocationManagerUtil.getInstance().stopLocation()
        LocationManagerUtil.getInstance().locationClient?.setLocationListener{
            location ->
            run {
                if (location.errorCode == 0 && !isInvoke) {
                    Constants.putLocation(location.latitude, location.longitude, location.city)
                    action.invoke(location.city)
                } else if (!isInvoke){
                    action.invoke("无法定位")
                }else{
                    action.invoke(Constants.getLocation()[2])
                }
                isInvoke = true
            }
        }
        LocationManagerUtil.getInstance().locationClient?.startLocation()
    }

    override fun geocoderSearch(county: String, city: String, action: (lat: String, lng: String) -> Unit) {
        val geocodeSearch = GeocodeSearch(this)
        geocodeSearch.setOnGeocodeSearchListener(object : GeocodeSearch.OnGeocodeSearchListener {
            override fun onRegeocodeSearched(p0: RegeocodeResult?, p1: Int) {

            }

            override fun onGeocodeSearched(result: GeocodeResult?, code: Int) {
                if (code == 1000){
                    val geocodeAddressList = result?.geocodeAddressList
                    if (geocodeAddressList != null && geocodeAddressList.isNotEmpty()){
                        Log.e("location_Tag","${geocodeAddressList[0].latLonPoint.latitude},${geocodeAddressList[0].latLonPoint.longitude}")
                        action.invoke(geocodeAddressList[0].latLonPoint.latitude.toString(),geocodeAddressList[0].latLonPoint.longitude.toString())
                    }else{
                        action.invoke("","")
                    }
                }else{
                    action.invoke("","")
                }
            }

        })
        val geocodeQuery = GeocodeQuery(county, city)
        geocodeSearch.getFromLocationNameAsyn(geocodeQuery)
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
