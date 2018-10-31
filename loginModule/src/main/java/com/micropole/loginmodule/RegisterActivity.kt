package com.micropole.loginmodule

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import com.micropole.loginmodule.bean.Code
import com.micropole.loginmodule.mvp.contract.RegisterContract
import com.micropole.loginmodule.mvp.presenter.RegisterPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.bar_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:注册
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterContract.View {
    private var time = 10//验证码时间
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
                time = 10
                tv_code.setEnabled(true)
            }
        }
    }
    override fun getCode(code: Code) {
        showToast("发送成功"+code.code)
        dismissLoadingDialog()
        mHandler.sendEmptyMessage(1)
    }

    override fun register(msg: String) {
        showToast(msg)
        dismissLoadingDialog()
        finish()
    }

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
        tv_register.setOnClickListener {
            showLoadingDialog("加载中...")
            getPresenter().register(et_accout.text.toString(),et_password.text.toString(),et_password_two.text.toString(),et_code.text.toString(),et_nickname.text.toString())
        }
        tv_code.setOnClickListener {
            showLoadingDialog("加载中...")
            getPresenter().getCode(et_accout.text.toString())
        }

    }

    companion object {
        fun startRegisterActivity(context: Context){
            var intent=Intent(context,RegisterActivity::class.java)
            context.startActivity(intent)


        }
    }
}
