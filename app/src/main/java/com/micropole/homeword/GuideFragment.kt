package com.micropole.homeword

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.micropole.baseapplibrary.constants.ARouterConst
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.activity_guide.*
import kotlinx.android.synthetic.main.view_guide_vp.*

/**
 * @ClassName       GuideFragment
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 18:18
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class GuideFragment : BaseMvpViewFragment() {

    companion object {
        fun startGuide(type:Int) : GuideFragment{
            val fragment = GuideFragment()
            val bundle = Bundle()
            bundle.putInt("type",type)
            fragment.arguments = bundle
            return fragment
        }
    }
    var titles = arrayListOf("舒适酒店","旅游基金","发布房源")
    var dess = arrayListOf("订酒店就是这么简单","一场说走就走的旅行","发布房源 成为房东")
    var imgs = arrayListOf(R.drawable.bg_hotel,R.drawable.bg_tourism,R.drawable.ic_release)
    override fun getFragmentLayoutId(): Int = R.layout.view_guide_vp

    override fun initView(view: View?) {
        val index = arguments?.getInt("type")
        if (index != null && index < titles.size){
            iv_img.setImageResource(imgs[index])
            tv_title.text = titles[index]
            tv_des.text = dess[index]
            if (index == titles.size - 1){
                stv_btn.text = "开始体验"
            }
        }

        stv_btn.setOnClickListener {
            if (index == 2){
                activity?.startActivity(Intent(activity,MainActivity::class.java))
            }else if (index != null){
                (activity as GuideActivity).vp_guide.currentItem = index + 1
            }
        }
    }

    override fun initData() {

    }

    override fun initEvent(view: View?) {

    }
}