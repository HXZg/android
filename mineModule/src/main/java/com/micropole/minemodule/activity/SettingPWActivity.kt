package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import com.google.gson.Gson
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.minemodule.R
import com.micropole.minemodule.bean.Code
import com.micropole.minemodule.bean.UserInfo
import com.micropole.minemodule.mvp.contract.SettingPWContract
import com.micropole.minemodule.mvp.presenter.SettingPWPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_setting_pw.*
import kotlinx.android.synthetic.main.bar_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:修改密码
 */
class SettingPWActivity : BaseMvpActivity<SettingPWPresenter>(), SettingPWContract.View {
    private var time = 60//验证码时间
    private var mHandler : Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            time--
            if (time > 0) {
                tv_code.setText(time.toString() + " s")
                tv_code.setEnabled(false)
                sendEmptyMessageDelayed(1,1000)
            } else {
                tv_code.setText("重新获取")
                time = 60
                tv_code.setEnabled(true)
            }
        }
    }
    override fun getCode(code: Code) {
        showToast("发送成功"+code.code)
        mHandler.sendEmptyMessage(1)

    }

    override fun setPW() {
        showToast("修改成功")
        finish()
    }

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
        var info=Gson().fromJson(  Constants.getUserInfo(),UserInfo::class.java)
        iv_back.setOnClickListener { finish() }
        tv_code.setOnClickListener {
            getPresenter().getCode(info.user.user_phone)
        }
        tv_sure.setOnClickListener {
            getPresenter().setPW(info.user.user_phone,et_code.text.toString(),et_shengfenz.text.toString(),et_sure.text.toString())
        }
    }



    companion object {
        fun  startSettingPWActivity(context: Context){
            var intent= Intent(context, SettingPWActivity::class.java)
            context.startActivity(intent)
        }
    }

}
