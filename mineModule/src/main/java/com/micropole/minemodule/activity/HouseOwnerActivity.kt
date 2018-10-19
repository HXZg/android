package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.minemodule.R
import kotlinx.android.synthetic.main.activity_house_owner.*
import kotlinx.android.synthetic.main.bar_title.*

class HouseOwnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_owner)
        iv_back.setOnClickListener { finish() }
        tv_title.text="成为房东"
        ll_note.setOnClickListener {
            NoteActivity.startNoteActivity(this)
        }
    }
    companion object {
        fun  startHouseOwnerActivity(context: Context){
            var intent= Intent(context, HouseOwnerActivity::class.java)
            context.startActivity(intent)
        }
    }

}
