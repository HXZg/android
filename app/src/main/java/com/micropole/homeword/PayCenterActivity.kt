package com.micropole.homeword

import android.app.Activity
import android.view.KeyEvent
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.ActivityUtils
import com.micropole.baseapplibrary.constants.ARouterConst
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_pay_center.*

/**
 * @ClassName       PayCenterActivity
 * @Description     支付
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/17 14:34
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Main.MAIN_PAY_CENTER)
class PayCenterActivity : BaseMvpViewActivity(){
    override fun getActivityLayoutId(): Int = R.layout.activity_pay_center

    override fun initData() {
    }

    override fun initEvent() {
        tv_pay_wx.setOnClickListener { finish() }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        /*if (keyCode == KeyEvent.KEYCODE_BACK){
            return true
        }*/
        return super.onKeyDown(keyCode, event)
    }
}