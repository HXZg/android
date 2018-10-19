package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.minemodule.R
import kotlinx.android.synthetic.main.bar_title.*

class NoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        iv_back.setOnClickListener { finish() }
        tv_title.text="房东申请协议"
    }
    companion object {
        fun  startNoteActivity(context: Context){
            var intent= Intent(context, NoteActivity::class.java)
            context.startActivity(intent)
        }
    }

}
