package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.minemodule.R
import kotlinx.android.synthetic.main.activity_zhima.*
import kotlinx.android.synthetic.main.bar_title.*

class ZhimaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zhima)
        iv_back.setOnClickListener { finish() }
        tv_title.text="芝麻信用授权"
        tv_credit.setOnClickListener {
            CrediSuccessfulActivity.startCrediSuccessfulActivity(this)
        }
    }
    companion object {
        fun  startZhimaActivity(context: Context){
            var intent= Intent(context, ZhimaActivity::class.java)
            context.startActivity(intent)
        }
    }

}
