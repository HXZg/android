package com.micropole.homeword

import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import java.util.*

/**
 * @ClassName       SplashActivity
 * @Description     启动页
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/18 17:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SplashActivity : BaseMvpViewActivity(){
    override fun getActivityLayoutId(): Int = R.layout.activity_splash

    override fun initData() {

        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(MainActivity::class.java)
            }
        },1500)
    }

    override fun initEvent() {
    }
}