package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.minemodule.R
import com.micropole.minemodule.dailog.CamaraDialog
import com.micropole.minemodule.dailog.NickNameDialog
import com.micropole.minemodule.dailog.SexDialog
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.bar_title.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        tv_title.text="设置"
        iv_back.setOnClickListener { finish() }
        var nickNameDialog=NickNameDialog(this)
        nickNameDialog.setOnBtnClickListener(object : NickNameDialog.OnBtnClickListener {
            override fun sure() {

            }

            override fun cancel() {
                nickNameDialog.dismiss()
            }

        })
        ll_nickName.setOnClickListener {
            nickNameDialog.show()
        }
        var camaraDialog=CamaraDialog(this)
        camaraDialog.setOnBtnClickListener(object : CamaraDialog.OnBtnClickListener {
            override fun cancel() {
                camaraDialog.dismiss()
            }

            override fun one() {

            }

            override fun two() {

            }
        })
        ll_hand.setOnClickListener {
            camaraDialog.show()
        }
        var  sexDialog=SexDialog(this)
        sexDialog.setOnBtnClickListener(object : SexDialog.OnBtnClickListener {
            override fun one() {

            }

            override fun two() {
            }

            override fun cancel() {
                sexDialog.dismiss()
            }

        })
        ll_sex.setOnClickListener {
            sexDialog.show()
        }
        ll_phone.setOnClickListener {
            SettingPhoneActivity.startSettingPhoneActivity(this)
        }
        ll_password.setOnClickListener {
            SettingPWActivity.startSettingPWActivity(this)
        }
    }
    companion object {
        fun  startSettingActivity(context: Context){
            var intent= Intent(context, SettingActivity::class.java)
            context.startActivity(intent)
        }
    }

}
