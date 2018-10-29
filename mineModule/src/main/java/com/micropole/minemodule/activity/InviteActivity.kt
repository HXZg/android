package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.minemodule.R
import kotlinx.android.synthetic.main.bar_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:我的好友
 */
class InviteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite)
        tv_title.text="邀请好友"
        iv_back.setOnClickListener { finish() }
    }
    companion object {
        fun  startInviteActivity(context: Context){
            var intent= Intent(context, InviteActivity::class.java)
            context.startActivity(intent)
        }
    }

}
