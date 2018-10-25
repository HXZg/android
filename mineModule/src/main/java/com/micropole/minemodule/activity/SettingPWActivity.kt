package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import com.micropole.minemodule.R
import com.micropole.minemodule.bean.UserInfo
import com.micropole.minemodule.mvp.contract.SettingContract
import com.micropole.minemodule.mvp.contract.SettingPWContract
import com.micropole.minemodule.mvp.presenter.SettingPWPresenter
import com.micropole.minemodule.mvp.presenter.SettingPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.bar_title.*

class SettingPWActivity : BaseMvpActivity<SettingPWPresenter>(), SettingPWContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): SettingPWPresenter =SettingPWPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_setting_pw

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="修改密码"

    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener { finish() }
    }



    companion object {
        fun  startSettingPWActivity(context: Context){
            var intent= Intent(context, SettingPWActivity::class.java)
            context.startActivity(intent)
        }
    }

}
