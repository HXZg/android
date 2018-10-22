package com.micropole.homemodule.order

import android.content.Intent
import com.alibaba.android.arouter.launcher.ARouter
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.CommitSucActivity
import com.micropole.homemodule.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_order_detail.*

/**
 * @ClassName       FillOrderActivity
 * @Description     填写订单
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 13:33
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class FillOrderActivity : BaseMvpViewActivity(){

    override fun getActivityLayoutId(): Int = R.layout.activity_order_detail

    override fun initData() {
        setTitleText("填写订单")
    }

    override fun initEvent() {

        stv_order_detail_btn.setOnClickListener {
            ARouter.getInstance().build(ARouterConst.Main.MAIN_PAY_CENTER).navigation(this,0x10)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0x10 && resultCode == 0x11){
            startActivityThenFinishSelf(CommitSucActivity::class.java)
        }
    }
}