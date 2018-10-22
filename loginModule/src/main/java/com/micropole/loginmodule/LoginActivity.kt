package com.micropole.loginmodule

import com.alibaba.android.arouter.facade.annotation.Route
import com.micropole.baseapplibrary.constants.ARouterConst
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.bar_title.*

@Route(path = ARouterConst.Login.LOGIN_ACTIVITY)
class LoginActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_login

    override fun initData() {
        tv_title.text="登录"
    }

    override fun initEvent() {
        iv_back.setOnClickListener { finish() }
        tv_register.setOnClickListener {
            RegisterActivity.startRegisterActivity(this)
        }
        tv_forget.setOnClickListener {
            FotgetActivity.startFotgetActivity(this)
        }
    }
}
