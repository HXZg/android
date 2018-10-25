package com.micropole.homemodule.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import android.view.ViewGroup

/**
 * @ClassName       OrderListFragmentAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 9:41
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class OrderListFragmentAdapter(fm: FragmentManager, val list:ArrayList<Fragment>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int = list.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    }
}