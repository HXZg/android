package com.micropole.homemodule.order

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.R
import com.micropole.homemodule.adapter.OrderListFragmentAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_order.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView

/**
 * @ClassName       OrderFragment
 * @Description     订单列表
 * 1=支付成功，待确认，2=管理员确认预约，已预订，3=已经完成 4=已取消 5=退款中 7=全部订单 8=待评价
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/16 16:21
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Order.ORDERLIST_FRAGEMENT)
class OrderFragment  : BaseMvpViewFragment(){

    val mfragments = arrayListOf(OrderListFragment.startOrderList(7),OrderListFragment.startOrderList(1),OrderListFragment.startOrderList(2)
    ,OrderListFragment.startOrderList(8),OrderListFragment.startOrderList(4),OrderListFragment.startOrderList(5),OrderListFragment.startOrderList(3))

    var mData : Array<String>? = null

    override fun getFragmentLayoutId(): Int = R.layout.fragment_order

    override fun initView(view: View?) {

    }

    override fun initEvent(view: View?) {
        vp_order_list.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                Log.i("select","$position")
                (mfragments[position] as OrderListFragment).refreshLoad()
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
        stv_order_login.setOnClickListener { ARouter.getInstance().build(ARouterConst.Login.LOGIN_ACTIVITY).navigation() }
    }

    fun initMagic(){
        val commonNavigator = CommonNavigator(mContext)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getTitleView(p0: Context?, index: Int): IPagerTitleView {
                val simplePagerTitleView = SimplePagerTitleView(context)
                simplePagerTitleView.text = mData!![index]
                simplePagerTitleView.normalColor = resources.getColor(R.color.colorWhite)
                simplePagerTitleView.selectedColor = resources.getColor(R.color.text_black)
                simplePagerTitleView.textSize = 14f
                simplePagerTitleView.setOnClickListener { vp_order_list.currentItem = index }
                return simplePagerTitleView
            }

            override fun getCount(): Int = mData!!.size

            override fun getIndicator(p0: Context?): IPagerIndicator? {
                return null
            }
        }
        magic_indicator.navigator = commonNavigator
        ViewPagerHelper.bind(magic_indicator,vp_order_list)
    }

    override fun initData() {
        mData = resources.getStringArray(R.array.order_list_title)
        vp_order_list.adapter = OrderListFragmentAdapter(childFragmentManager,mfragments)
        initMagic()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        checkLogin()
    }

    override fun onResume() {
        super.onResume()
        checkLogin()
    }

    fun checkLogin(){
        if (!isHidden){
            if (!Constants.isLogin()){
                fl_order_login.visibility = View.VISIBLE
            }else{
                fl_order_login.visibility = View.GONE
                if ((mfragments[vp_order_list.currentItem] as OrderListFragment).isResumed)
                (mfragments[vp_order_list.currentItem] as OrderListFragment).refreshLoad()
            }
        }
    }
}