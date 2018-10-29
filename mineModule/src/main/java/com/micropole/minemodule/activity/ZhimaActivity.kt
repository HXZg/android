package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.minemodule.R
import kotlinx.android.synthetic.main.activity_zhima.*
import kotlinx.android.synthetic.main.bar_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:芝麻信用授权
 */
@Route(path = ARouterConst.Mine.MINE_ALIAUTHO)
class ZhimaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zhima)
        iv_back.setOnClickListener { finish() }
        tv_title.text="芝麻信用授权"
        tv_credit.setOnClickListener {
            ARouter.getInstance().build(ARouterConst.Main.MAIN_AUTHO).navigation(this,0x10)
        }
    }
    companion object {
        fun  startZhimaActivity(context: Context){
            var intent= Intent(context, ZhimaActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        CrediSuccessfulActivity.startCrediSuccessfulActivity(this)
    }

}
