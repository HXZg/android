package com.micropole.homeword

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.micropole.baseapplibrary.constants.ARouterConst.Main.MAIN_SHARE
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.util.refreshToken
import com.micropole.homeword.entity.ShareHotlBean
import com.micropole.homeword.util.network.Appservice
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.extensions.ui
import kotlinx.android.synthetic.main.popup_share.*

/**
 * @ClassName       ShareActivity
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 14:54
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = MAIN_SHARE)
class ShareActivity : BaseMvpActivity<ShareConstract.Present>(),ShareConstract.View {

     var mHid : String?=null
    var platform = SHARE_MEDIA.QQ

    override fun initData() {
        mHid = intent.getStringExtra("h_id")
        window.getDecorView().setPadding(0, 0, 0, 0);
        // 获取Window的LayoutParams
        var attributes = window.getAttributes();
        attributes.width = LinearLayout.LayoutParams.MATCH_PARENT
        attributes.gravity = Gravity.BOTTOM
        // 一定要重新设置, 才能生效
        window.setAttributes(attributes);
    }

    override fun initEvent() {
        tv_share_weixin.setOnClickListener(clickListener)
        tv_share_moments.setOnClickListener(clickListener)
        tv_share_weibo.setOnClickListener(clickListener)
        tv_share_qq.setOnClickListener(clickListener)
        tv_share_qzone.setOnClickListener(clickListener)
        btn_share_cancel.setOnClickListener { finish() }
    }

    override fun onResume() {
        super.onResume()
        /*ShareAction(this).withText("hello").setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(shareListener).open()*/
    }

    override fun getActivityLayoutId(): Int {
        return R.layout.popup_share
    }

    override fun createPresenter(): ShareConstract.Present = ShareConstract.Present()

    override fun share(bean: ShareHotlBean?) {
        val url = intent.getStringExtra("share_url")
        var web = UMWeb(url)
        web.title = bean?.share?.share_title
        web.setThumb( UMImage(this, bean?.share?.share_img))
        web.description = bean?.share?.share_content
        ShareAction(this)
                .withText("waterTheGreat")
                .withMedia(web)
                .setPlatform(platform)
                .setCallback(shareListener).share()
    }

    private var clickListener = View.OnClickListener {
        if (mHid.isNullOrEmpty()){
            val bean = ShareHotlBean()
            bean.share = ShareHotlBean.ShareBean()
            bean.share.share_title = intent.getStringExtra("share_title")
            bean.share.share_img = intent.getStringExtra("share_img")
            bean.share.share_content = intent.getStringExtra("share_content")
            share(bean)
            return@OnClickListener
        }
        platform = when(it.id){
            R.id.tv_share_weixin -> SHARE_MEDIA.WEIXIN
            R.id.tv_share_moments -> SHARE_MEDIA.WEIXIN_CIRCLE
            R.id.tv_share_qzone -> SHARE_MEDIA.QZONE
            R.id.tv_share_weibo -> SHARE_MEDIA.SINA
            else -> SHARE_MEDIA.QQ
        }
        getPresenter().share(mHid!!)
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

class ShareConstract{
    interface View : BaseMvpView {
        fun share(bean : ShareHotlBean?)
    }

    class Present : BaseMvpPresenter<Any, View>(){
        override fun createModel(): Any {
            return Any()
        }

        fun share(h_id:String){
            if (!Constants.isLogin()){
                getView()?.showToast("请先登录")
                return
            }
            getView()?.showLoadingDialog("正在获取")
            AppApi.Api<Appservice>().share(Constants.SHORT_TOKEN, Constants.getLocation()[0], Constants.getLocation()[1],h_id)
                    .ui({
                        getView()?.dismissLoadingDialog()
                        getView()?.share(it.data)},{
                        getView()?.dismissLoadingDialog()
                        getView()?.refreshToken(it,{share(h_id)})})
        }
    }
}

