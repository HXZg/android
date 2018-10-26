package com.micropole.homemodule.mine

import android.content.Context
import android.content.Intent
import android.webkit.WebSettings
import com.micropole.homemodule.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_notice_detail.*

/**
 * @ClassName       NoticeDetailActivity
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/26 17:25
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class NoticeDetailActivity : BaseMvpViewActivity() {

    companion object {
        fun startNoticeDetail(context: Context,content:String){
            val intent = Intent(context, NoticeDetailActivity::class.java)
            intent.putExtra("notice_detail",content)
            context.startActivity(intent)
        }
    }

    override fun getActivityLayoutId(): Int = R.layout.activity_notice_detail

    override fun initData() {
        val detail = intent.getStringExtra("notice_detail")
        web_view.settings.javaScriptEnabled = true
        web_view.settings.domStorageEnabled = true
        web_view.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        web_view.settings.builtInZoomControls = true
        web_view.loadDataWithBaseURL("",detail,"text/html","utf-8","")
    }

    override fun initEvent() {
    }
}