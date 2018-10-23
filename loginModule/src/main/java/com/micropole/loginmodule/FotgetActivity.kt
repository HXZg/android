package com.micropole.loginmodule

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.bar_title.*

class FotgetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fotget)
        iv_back.setOnClickListener { finish() }
        tv_title.text="忘记密码"
    }
    companion object {
        fun startFotgetActivity(context:Context){
            var intent=Intent(context, FotgetActivity::class.java)
            context.startActivity(intent)

        }
    }
}
