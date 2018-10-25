package com.micropole.homeword.util.adapter

import android.media.Image
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.micropole.homeword.R

/**
 * @ClassName       GuideAdapter
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 17:51
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class GuideAdapter(fm:FragmentManager,val list: List<Fragment>) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

}