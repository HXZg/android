package com.micropole.loginmodule

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import com.micropole.loginmodule.bean.Code
import com.micropole.loginmodule.mvp.contract.ForgetContract
import com.micropole.loginmodule.mvp.presenter.ForgetPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_fotget.*
import kotlinx.android.synthetic.main.bar_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:忘记密码
 */
class FotgetActivity : BaseMvpActivity<ForgetPresenter>(),ForgetContract.View {

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
    override fun forget() {
        showToast("修改密码成功")
        dismissLoadingDialog()
        finish()
    }
    override fun getCode(code: Code) {
        dismissLoadingDialog()
        showToast("发送成功"+code.code)
    }

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
        tv_sure.setOnClickListener {
            showLoadingDialog("加载中...")
            getPresenter().forget(et_accout.text.toString(),et_password.text.toString(),et_passwordSure.text.toString(),et_code.text.toString())
        }
        tv_code.setOnClickListener {
            showLoadingDialog("加载中...")
            getPresenter().getCode(et_accout.text.toString())

        }
    }

    companion object {
        fun startFotgetActivity(context:Context){
            var intent=Intent(context, FotgetActivity::class.java)
            context.startActivity(intent)

        }
    }
}
