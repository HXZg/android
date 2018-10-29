package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.text.Html
import com.micropole.minemodule.R
import com.micropole.minemodule.bean.Note
import com.micropole.minemodule.mvp.contract.NoteContract
import com.micropole.minemodule.mvp.presenter.NotePresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_note.*
import kotlinx.android.synthetic.main.bar_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:成为房东须知
 */
class NoteActivity : BaseMvpActivity<NotePresenter>(),NoteContract.View {
    override fun getNote(note: Note) {
        tv_note.text=Html.fromHtml(note.content)
    }

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_note

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="房东申请协议"
        getPresenter().getNote()
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener { finish() }
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): NotePresenter = NotePresenter()

    companion object {
        fun  startNoteActivity(context: Context){
            var intent= Intent(context, NoteActivity::class.java)
            context.startActivity(intent)
        }
    }

}
