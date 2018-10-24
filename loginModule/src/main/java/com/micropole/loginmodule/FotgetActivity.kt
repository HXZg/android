package com.micropole.loginmodule

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.loginmodule.mvp.presenter.ForgetPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.bar_title.*

class FotgetActivity : BaseMvpActivity<ForgetPresenter>() {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): ForgetPresenter = ForgetPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_fotget

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="忘记密码"
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener { finish() }
    }

    companion object {
        fun startFotgetActivity(context:Context){
            var intent=Intent(context, FotgetActivity::class.java)
            context.startActivity(intent)

        }
    }
}
