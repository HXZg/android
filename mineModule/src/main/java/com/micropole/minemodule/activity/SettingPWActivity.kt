package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.minemodule.R
import kotlinx.android.synthetic.main.bar_title.*

class SettingPWActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_pw)
        iv_back.setOnClickListener { finish() }
        tv_title.text="修改密码"
    }
    companion object {
        fun  startSettingPWActivity(context: Context){
            var intent= Intent(context, SettingPWActivity::class.java)
            context.startActivity(intent)
        }
    }

}