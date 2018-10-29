package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.EncodeUtils
import com.micropole.minemodule.R
import com.micropole.minemodule.dailog.CamaraDialog
import com.micropole.minemodule.mvp.contract.HouserOwnerContract
import com.micropole.minemodule.mvp.presenter.HouseOwmerPresenter
import com.micropole.minemodule.util.ImageChooseHelper
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_house_owner.*
import kotlinx.android.synthetic.main.bar_title.*
import java.io.File
/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:成为房东
 */
class HouseOwnerActivity : BaseMvpActivity<HouseOwmerPresenter>(),HouserOwnerContract.View {
    var zheng=""
    var fan=""
    var zhengs=""
    var fans=""
    var index=1
    var onTrout=1
    override fun setImage(src: String) {
        index++
        if (index==2){
            zhengs=src
            getPresenter().setImage(fan)

        }else{
            fans=src
            getPresenter().beHouse(et_name.text.toString(),et_shengfenz.text.toString(),zhengs,fans)
        }

    }

    override fun beHouse() {
        showToast("提交审核成功")
        finish()

    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): HouseOwmerPresenter = HouseOwmerPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_house_owner

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="成为房东"
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener { finish() }
        ll_note.setOnClickListener {
            NoteActivity.startNoteActivity(this)
        }
        tv_tijiao.setOnClickListener {
            index=1
            showLoadingDialog("加载中...")
            getPresenter().setImage(zheng)
        }
        ll_zheng.setOnClickListener {
            onTrout=1
            var camaraDialog= CamaraDialog(this)
            camaraDialog.setOnBtnClickListener(object : CamaraDialog.OnBtnClickListener {
                override fun cancel() {
                    camaraDialog.dismiss()
                }

                override fun one() {//相册
                    camaraDialog.dismiss()
                    imageChooseHelper.selectPicker()
                }

                override fun two() {//相机
                    camaraDialog.dismiss()
                    imageChooseHelper.takePhoto()
                }
            })
            camaraDialog.show()
        }
        ll_fan.setOnClickListener {
            onTrout=2
            var camaraDialog=CamaraDialog(this)
            camaraDialog.setOnBtnClickListener(object : CamaraDialog.OnBtnClickListener {
                override fun cancel() {
                    camaraDialog.dismiss()
                }

                override fun one() {//相册
                    camaraDialog.dismiss()
                    imageChooseHelper.selectPicker()
                }

                override fun two() {//相机
                    camaraDialog.dismiss()
                    imageChooseHelper.takePhoto()
                }
            })
            camaraDialog.show()
        }

    }
    lateinit var imageChooseHelper: ImageChooseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageChooseHelper= ImageChooseHelper(this,{
            if (onTrout==1){
                iv_zhen.visibility=View.GONE
                tv_tishiz.visibility=View.GONE
                zheng=EncodeUtils.base64Encode2String(File(it.compressPath).readBytes())
                iv_zhenmian.setImageURI(Uri.parse(it.compressPath))
            }else{
                iv_fan.visibility=View.GONE
                tv_tishif.visibility=View.GONE
                fan=EncodeUtils.base64Encode2String(File(it.compressPath).readBytes())
                iv_fanmian.setImageURI(Uri.parse(it.compressPath))
            }


        })

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        imageChooseHelper.takePhoto.onSaveInstanceState(outState)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        imageChooseHelper.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        imageChooseHelper.takePhoto.onActivityResult(requestCode, resultCode, data)
    }
    companion object {
        fun  startHouseOwnerActivity(context: Context){
            var intent= Intent(context, HouseOwnerActivity::class.java)
            context.startActivity(intent)
        }
    }

}
