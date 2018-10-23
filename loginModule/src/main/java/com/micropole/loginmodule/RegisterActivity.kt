package com.micropole.loginmodule

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.loginmodule.R.id.iv_back
import com.micropole.loginmodule.mvp.presenter.RegisterPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.bar_title.*

class RegisterActivity : BaseMvpActivity<RegisterPresenter>() {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): RegisterPresenter =RegisterPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_register

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="注册"
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener { finish() }

    }

    companion object {
        fun startRegisterActivity(context: Context){
            var intent=Intent(context,RegisterActivity::class.java)
            context.startActivity(intent)


        }
    }
}
