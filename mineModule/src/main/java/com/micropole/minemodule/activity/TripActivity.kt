package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.minemodule.R
import com.micropole.minemodule.bean.UserInfo
import kotlinx.android.synthetic.main.activity_trip.*
import kotlinx.android.synthetic.main.bar_title.*

class TripActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip)
        tv_title.text="旅游基金"
        var userInfo=Gson().fromJson(Constants.getUserInfo(),UserInfo::class.java)
        tv_price.text=userInfo.user.balance
        iv_back.setOnClickListener {
            finish()
        }
        tv_ming.setOnClickListener {
            TripIntraActivity.startTripIntraActivity(this)
        }
        tv_invite.setOnClickListener {
            InviteActivity.startInviteActivity(this)
        }

    }
    companion object {
        fun  startTripActivity(context:Context){
            var intent=Intent(context, TripActivity::class.java)
            context.startActivity(intent)
        }
    }
}
