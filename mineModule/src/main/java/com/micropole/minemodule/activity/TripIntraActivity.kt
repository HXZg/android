package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.micropole.minemodule.R
import com.micropole.minemodule.dapter.TripIntraAdapter
import kotlinx.android.synthetic.main.activity_trip_intra.*
import kotlinx.android.synthetic.main.bar_title.*

class TripIntraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_intra)
        recyclerView.layoutManager=LinearLayoutManager(this)
        var adapter=TripIntraAdapter(arrayListOf())
        recyclerView.adapter=adapter
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        adapter.setNewData(arrayListOf("","","",""))
        tv_title.text="旅游基金"
        iv_back.setOnClickListener{
            finish()
        }
    }
    companion object {
        fun  startTripIntraActivity(context: Context){
            var intent= Intent(context, TripIntraActivity::class.java)
            context.startActivity(intent)
        }
    }

}
