package com.micropole.loginmodule

import com.alibaba.android.arouter.facade.annotation.Route
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.loginmodule.bean.Login
import com.micropole.loginmodule.mvp.contract.LoginContract
import com.micropole.loginmodule.mvp.presenter.LoginPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.bar_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:登录
 */
@Route(path = ARouterConst.Login.LOGIN_ACTIVITY)
class LoginActivity : BaseMvpActivity<LoginPresenter>(),LoginContract.View {
    override fun login(login: Login) {
        Constants.login()
        Constants.putLongToken(login.long_token)
        Constants.putShortToken(login.short_token)
        Constants.SHORT_TOKEN=login.short_token
        finish()

    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): LoginPresenter =LoginPresenter()

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
        tv_login.setOnClickListener {
            showLoadingDialog("加载中...")
            getPresenter().login(et_accout.text.toString(),et_password.text.toString())
        }
    }
}
