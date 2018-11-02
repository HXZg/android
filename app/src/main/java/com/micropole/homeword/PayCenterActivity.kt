package com.micropole.homeword

import android.app.Activity
import android.view.KeyEvent
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.ActivityUtils
import com.google.gson.Gson
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homeword.R.id.*
import com.micropole.homeword.entity.PayBean
import com.micropole.homeword.util.network.Appservice
import com.xx.anypay.XxAnyPay
import com.xx.anypay.XxAnyPayResultCallBack
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.extensions.ui
import kotlinx.android.synthetic.main.activity_pay_center.*

/**
 * @ClassName       PayCenterActivity
 * @Description     支付
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/17 14:34
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Main.MAIN_PAY_CENTER)
class PayCenterActivity : BaseMvpActivity<PayCenterContract.Present>(),PayCenterContract.View{

    lateinit var mOid : String
    override fun getActivityLayoutId(): Int = R.layout.activity_pay_center

    override fun createPresenter(): PayCenterContract.Present {
        return PayCenterContract.Present()
    }

    override fun initData() {
        XxAnyPay.intance.init(this)
        mOid = intent.getStringExtra("or_id")
    }

    override fun initEvent() {
        tv_pay_wx.setOnClickListener {
            getPresenter().orderPay(mOid,1)
        }
        tv_pay_ali.setOnClickListener {
            getPresenter().orderPay(mOid,2)
        }
        fl_cancel.setOnClickListener { finish() }
    }

    override fun getPay(bean: PayBean?,type : Int) {
        XxAnyPay.intance
                .openAnyPay(if (type == 1) XxAnyPay.XXPAY_WX else XxAnyPay.XXPAY_ALI,if (type == 1) Gson().toJson(bean?.data) else bean?.data!!.sign, object : XxAnyPayResultCallBack {
                    override fun onPayFiale(error: String) {
                        showToast(error)
                    }

                    override fun onPaySuccess() {
                        showToast("支付成功")
                        setResult(0x11)
                        finish()
                    }
                })
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        /*if (keyCode == KeyEvent.KEYCODE_BACK){
            return true
        }*/
        return super.onKeyDown(keyCode, event)
    }
}

class PayCenterContract{
    interface View : BaseMvpView{
        fun getPay(bean : PayBean?,type: Int)
    }

    class Present : BaseMvpPresenter<Any,View>(){
        override fun createModel(): Any {
            return Any()
        }

        fun orderPay(or_id:String,type:Int){
            getView()?.showLoadingDialog("正在获取")
            AppApi.Api<Appservice>().orderPay(Constants.SHORT_TOKEN,Constants.getLocation()[0],Constants.getLocation()[1],or_id,type)
                    .ui({
                        getView()?.dismissLoadingDialog()
                        getView()?.getPay(it.data,type)
                    },{
                        getView()?.dismissLoadingDialog()
                        getView()?.showToast(it)})
        }
    }
}