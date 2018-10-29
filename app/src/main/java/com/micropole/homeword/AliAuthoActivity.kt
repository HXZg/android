package com.micropole.homeword

import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ToastUtils
import com.micropole.baseapplibrary.constants.ARouterConst
import java.util.*

/**
 * @ClassName       AliAuthoActivity
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/29 14:04
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Main.MAIN_AUTHO)
class AliAuthoActivity : AppCompatActivity(){

    override fun onResume() {
        super.onResume()
        ToastUtils.showShort("auth activity")

        Timer().schedule(object : TimerTask() {
            override fun run() {
                setResult(0x11)
                finish()
            }
        },1500)
    }
}