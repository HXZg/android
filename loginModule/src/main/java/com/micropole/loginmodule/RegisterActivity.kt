package com.micropole.loginmodule

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.bar_title.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        iv_back.setOnClickListener { finish() }
        tv_title.text="注册"
    }
    companion object {
        fun startRegisterActivity(context: Context){
            var intent=Intent(context,RegisterActivity::class.java)
            context.startActivity(intent)


        }
    }
}
