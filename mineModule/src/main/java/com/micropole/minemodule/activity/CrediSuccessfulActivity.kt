package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.minemodule.R
import kotlinx.android.synthetic.main.bar_title.*

class CrediSuccessfulActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credi_successful)
        tv_title.text=="芝麻信用授权"
        iv_back.setOnClickListener { finish() }
    }
    companion object {
        fun  startCrediSuccessfulActivity(context: Context){
            var intent= Intent(context, CrediSuccessfulActivity::class.java)
            context.startActivity(intent)
        }
    }

}
