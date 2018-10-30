package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.micropole.minemodule.R
import com.micropole.minemodule.bean.Share
import com.micropole.minemodule.mvp.contract.InviteContract
import com.micropole.minemodule.mvp.presenter.InvitePresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseutilslibrary.extensions.loadImag
import kotlinx.android.synthetic.main.activity_invite.*
import kotlinx.android.synthetic.main.bar_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:邀请好友
 */
class InviteActivity : BaseMvpActivity<InvitePresenter>(),InviteContract.View{
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): InvitePresenter = InvitePresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_invite

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="邀请好友"
        getPresenter().getShare()

    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener { finish() }
    }

    override fun getShare(share: Share) {
        iv_hand.loadImag(share.user_img)
        tv_name.text=share.nickname
        tv_phote.text=share.user_phone
        tv_yaoqingma.text=share.invite
        iv_iqcode.loadImag(share.user_qrcode)
        tv_web.text=share.url
    }

    companion object {
        fun  startInviteActivity(context: Context){
            var intent= Intent(context, InviteActivity::class.java)
            context.startActivity(intent)
        }
    }

}
