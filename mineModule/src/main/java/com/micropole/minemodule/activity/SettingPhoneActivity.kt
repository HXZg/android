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
import com.micropole.minemodule.mvp.contract.SettingPhoneContract
import com.micropole.minemodule.mvp.presenter.SettingPhonePresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_setting_phone.*
import kotlinx.android.synthetic.main.bar_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:修改手机
 */
class SettingPhoneActivity : BaseMvpActivity<SettingPhonePresenter>(),SettingPhoneContract.View {
    private var time = 60//验证码时间
    private var times = 60//验证码时间
    private var mHandler : Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if (msg.what==1){
                time--
                if (time > 0) {
                    tv_old_code.setText(time.toString() + " s")
                    tv_old_code.setEnabled(false)
                    sendEmptyMessageDelayed(1,1000)
                } else {
                    tv_old_code.setText("重新获取")
                    time = 60
                    tv_old_code.setEnabled(true)
                }
            }else{
                times--
                if (times > 0) {
                    tv_code.setText(times.toString() + " s")
                    tv_code.setEnabled(false)
                    sendEmptyMessageDelayed(2,1000)
                } else {
                    tv_code.setText("重新获取")
                    times = 60
                    tv_code.setEnabled(true)
                }
            }

        }
    }

    override fun getCode(code: Code) {
        showToast("发送成功"+code.code)
              if (index==1){
        mHandler.sendEmptyMessage(1)
    }else{
        mHandler.sendEmptyMessage(2)
    }

}

    override fun setphone() {
        showToast("修改成功")
        finish()

    }


    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): SettingPhonePresenter =SettingPhonePresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_setting_phone

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="修改手机号"
    }

    /**
     * 初始化事件
     */
    var index=0//标记是哪个手机号码获取认证码
    override fun initEvent() {
        var info=Gson().fromJson(Constants.getUserInfo(),UserInfo::class.java)
        iv_back.setOnClickListener { finish() }
        tv_old_code.setOnClickListener {
            index=1
            getPresenter().getCode(info.user.user_phone)
        }
        tv_code.setOnClickListener {
            index=2
            getPresenter().getCode(et_phone.text.toString())
        }
        tv_sure.setOnClickListener {
            getPresenter().setPhone(info.user.user_phone,et_phone.text.toString(),et_new_code.text.toString(),et_old_code.text.toString())
        }
    }

    companion object {
        fun  startSettingPhoneActivity(context: Context){
            var intent= Intent(context, SettingPhoneActivity::class.java)
            context.startActivity(intent)
        }
    }

}
