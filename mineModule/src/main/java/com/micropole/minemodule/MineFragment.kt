package com.micropole.minemodule

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.micropole.baseapplibrary.constants.ARouterConst
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment

/**
 * @ClassName       MineFragment
 * @Description     个人中心
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/16 16:23
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Mine.MINE_FRAGMENT)
class MineFragment : BaseMvpViewFragment() {
    override fun getFragmentLayoutId(): Int = R.layout.fragment_mine

    override fun initView(view: View?) {
    }

    override fun initEvent(view: View?) {
    }

    override fun initData() {
    }
}