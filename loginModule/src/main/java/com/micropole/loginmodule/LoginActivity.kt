package com.micropole.loginmodule

import com.alibaba.android.arouter.facade.annotation.Route
import com.micropole.baseapplibrary.constants.ARouterConst
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity

@Route(path = ARouterConst.Login.LOGIN_ACTIVITY)
class LoginActivity : BaseMvpViewActivity() {
    override fun getActivityLayoutId(): Int = R.layout.activity_login

    override fun initData() {
    }

    override fun initEvent() {
    }
}
