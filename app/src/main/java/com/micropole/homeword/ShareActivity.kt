package com.micropole.homeword

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.micropole.baseapplibrary.constants.ARouterConst
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity

/**
 * @ClassName       ShareActivity
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 14:54
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Main.MAIN_SHARE)
class ShareActivity : BaseMvpViewActivity() {
    override fun initData() {
        window.getDecorView().setPadding(0, 0, 0, 0);
        // 获取Window的LayoutParams
        var attributes = window.getAttributes();
        attributes.width = LinearLayout.LayoutParams.MATCH_PARENT
        attributes.gravity = Gravity.BOTTOM
        // 一定要重新设置, 才能生效
        window.setAttributes(attributes);
    }

    override fun initEvent() {
    }

    override fun onResume() {
        super.onResume()
        /*ShareAction(this).withText("hello").setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(shareListener).open()*/
    }

    override fun getActivityLayoutId(): Int {
        return R.layout.popup_share
    }

    private var  shareListener = object : UMShareListener {
        override fun onResult(p0: SHARE_MEDIA?) {

        }

        override fun onCancel(p0: SHARE_MEDIA?) {
        }

        override fun onError(p0: SHARE_MEDIA?, p1: Throwable?) {
        }

        override fun onStart(p0: SHARE_MEDIA?) {
        }

    }


}