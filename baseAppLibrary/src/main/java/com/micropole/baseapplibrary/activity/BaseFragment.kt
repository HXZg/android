package com.micropole.baseapplibrary.activity

import android.view.View
import com.micropole.baseapplibrary.R
import com.xx.baseuilibrary.mvp.lcec.BaseLcecFragment

/**
 * @ClassName       BaseFragment
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/26 9:50
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class BaseFragment : BaseLcecFragment<View,Any>() {
    override fun loadData(refresh: Boolean) {
    }

    override fun setData(data: Any?) {
    }

    override fun getFragmentLayoutId(): Int {
        return R.layout.fragment_base
    }

    override fun initEvent(view: View?) {
    }

    override fun initData() {
    }
}