package com.micropole.homemodule

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.EncodeUtils
import com.blankj.utilcode.util.ScreenUtils
import com.bumptech.glide.Glide
import com.coorchice.library.SuperTextView
import com.micropole.baseapplibrary.widght.ImageChooseDialog
import com.micropole.baseapplibrary.util.ImageChooseHelper
import com.micropole.homemodule.R.id.ll_add_img
import com.micropole.homemodule.entity.UpImageBean
import com.micropole.homemodule.mvp.constract.EvaluationConstract
import com.micropole.homemodule.mvp.present.EvaluationPresent
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import com.xx.baseutilslibrary.extensions.loadImag
import kotlinx.android.synthetic.main.activity_evaluation.*
import java.io.File

/**
 * @ClassName       EvaluationActivity
 * @Description     评价
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/19 18:04
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class EvaluationActivity : BaseMvpActivity<EvaluationConstract.Present>(),EvaluationConstract.View {

    companion object {
        fun startEvaluation(context: Context,orderId:String,hId:String,himg:String,htitle:String,haddress:String){
            val intent = Intent(context, EvaluationActivity::class.java)
            intent.putExtra("eva_or_id",orderId)
            intent.putExtra("eva_h_id",hId)
            intent.putExtra("hotel_img",himg)
            intent.putExtra("hotel_title",htitle)
            intent.putExtra("hotel_address",haddress)
            context.startActivity(intent)
        }
    }

    var mTag = 0
    val mImgs = arrayListOf<String>()
    val mUpImages = arrayListOf<String>()
    var mViews = arrayListOf<SuperTextView>()
    var mScore = -1
    lateinit var imageHelper : ImageChooseHelper
    override fun getActivityLayoutId(): Int = R.layout.activity_evaluation

    override fun createPresenter(): EvaluationConstract.Present {
        return EvaluationPresent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageHelper = ImageChooseHelper(this, {
            for (i in it.images.indices) {
                mImgs.add(EncodeUtils.base64Encode2String(File(it.images[i].compressPath).readBytes()))
                ll_add_img.removeView(ll_add_img.getChildAt(mTag - 1))
                ll_add_img.addView(getEvaluateImgView(it.images[i].compressPath), mTag - 1)
                if (ll_add_img.childCount < 3) {
                    ll_add_img.addView(getEvaluateImgView(null))
                }
            }
        })
        imageHelper.takePhoto.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        imageHelper.takePhoto.onSaveInstanceState(outState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        imageHelper.takePhoto.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        imageHelper.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun initData() {
        iv_evaluation_img.loadImag(intent.getStringExtra("hotel_img"),radio = 16)
        tv_evaluation_name.text = intent.getStringExtra("hotel_title")
        tv_evaluation_address.text = intent.getStringExtra("hotel_address")
        ll_add_img.addView(getEvaluateImgView(null))

        mViews.add(stv_score_one)
        mViews.add(stv_score_two)
        mViews.add(stv_score_three)
        mViews.add(stv_score_four)
        mViews.add(stv_score_five)
    }

    override fun initEvent() {

        stv_evaluation_commit.setOnClickListener {
            for (i in mImgs.indices){
                getPresenter().upImage(mImgs[i])
            }
        }

        stv_score_one.setOnClickListener { lightScore(0) }
        stv_score_two.setOnClickListener {lightScore(1)  }
        stv_score_three.setOnClickListener { lightScore(2) }
        stv_score_four.setOnClickListener { lightScore(3) }
        stv_score_five.setOnClickListener { lightScore(4) }
    }

    fun lightScore(index : Int){
        if (mScore != index){
            if (mScore < index){
                for (i in 0..index){
                    if (i > mScore) mViews[i].solid = Color.parseColor("#FF4E2B")
                }
            }else{
                for (i in index..mScore){
                    if (i != index) mViews[i].solid = Color.parseColor("#D9D9D9")
                }
            }
            mScore = index
        }
    }

    fun showImageChooseDialog(){
        ImageChooseDialog(this,{
            if (it == 0){  //拍照
                imageHelper.takePhoto()
            }else if (it == 1){
                imageHelper.selectPicker()
            }
        }).show()
    }

    override fun upImage(bean: UpImageBean) {
        mUpImages.add(bean.imgUrl)
        if (mUpImages.size == mImgs.size){   //评价
            evaOrder()
        }
    }

    fun evaOrder(){
        val oid = intent.getStringExtra("eva_or_id")
        val hid = intent.getStringExtra("eva_h_id")
        if (!oid.isNullOrEmpty() && !hid.isNullOrEmpty()){
            val stringBuilder = StringBuilder()
            for (i in mUpImages.indices){
                stringBuilder.append(mUpImages[i])
                if (i < mUpImages.size - 1){
                    stringBuilder.append(",")
                }
            }
            getPresenter().evaOrder(oid,hid,(mScore+1).toString(),et_put_content.text.toString(),stringBuilder.toString())
        }
    }

    /**
     * 上传显示图片
     */
    fun getEvaluateImgView(bitmap: String?) : View {
        val width = (ScreenUtils.getScreenWidth() - 2 * ConvertUtils.dp2px(14f)) / 3
        var layoutParams = LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.MATCH_PARENT)
        var layoutParams1 = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        layoutParams.rightMargin = ConvertUtils.dp2px(4f)
        var layoutParams2 = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        layoutParams2.gravity = Gravity.RIGHT
        var viewG = FrameLayout(mContext)
        viewG.layoutParams = layoutParams
        var iv = ImageView(mContext)
        iv.layoutParams = layoutParams1
        var p = ConvertUtils.dp2px(4f)
        iv.setPadding(0,p,p,0)
        if (bitmap == null){
            iv.setBackgroundDrawable(mContext.resources.getDrawable(R.drawable.shape_gray_r3))
            iv.setImageResource(R.drawable.ic_camera_n)
            iv.scaleType = ImageView.ScaleType.CENTER_INSIDE
            iv.setOnClickListener {
                showImageChooseDialog()
                mTag = ll_add_img.childCount
            }
        }else{
            iv.setImageURI(Uri.fromFile(File(bitmap)))
            iv.scaleType = ImageView.ScaleType.FIT_XY
        }
        var iClose = ImageView(mContext)
        iClose.layoutParams = layoutParams2
        iClose.setImageResource(R.drawable.ic_close_red)
        iClose.setOnClickListener {
            var indexOfChild = ll_add_img.indexOfChild(viewG)
            mImgs.removeAt(indexOfChild)
            if (ll_add_img.childCount == 3 && mTag == 3){
                ll_add_img.removeView(viewG)
                ll_add_img.addView(getEvaluateImgView(null))
                mTag = 2
            }else{
                ll_add_img.removeView(viewG)
            }
        }
        viewG.addView(iv)
        if (bitmap != null) viewG.addView(iClose)
        return viewG
    }
}