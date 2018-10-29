package com.micropole.minemodule.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.blankj.utilcode.util.EncodeUtils
import com.micropole.minemodule.R
import com.micropole.minemodule.bean.ImageViewUri
import com.micropole.minemodule.bean.UserInfo
import com.micropole.minemodule.dailog.CamaraDialog
import com.micropole.minemodule.dailog.NickNameDialog
import com.micropole.minemodule.dailog.SexDialog
import com.micropole.minemodule.mvp.contract.SettingContract
import com.micropole.minemodule.mvp.presenter.SettingPresenter
import com.micropole.minemodule.util.ImageChooseHelper
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.bar_title.*
import java.io.File
/**
 * author: xiaoguagnfei
 * date: 2018/10/23
 * describe:个人资料设置
 */
class SettingActivity : BaseMvpActivity<SettingPresenter>(),SettingContract.View {
    override fun setImageURI(imageUri: ImageViewUri) {
        getPresenter().setInfo("","",imageUri.imgUrl)
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): SettingPresenter =SettingPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_setting

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="设置"
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener { finish() }
        var nickNameDialog=NickNameDialog(this)
        ll_nickName.setOnClickListener {
            nickNameDialog.show()
        }
        nickNameDialog.setOnBtnClickListener(object : NickNameDialog.OnBtnClickListener {
            override fun sure() {

                if (nickNameDialog.content.isNullOrEmpty()){
                    showToast("昵称不能为空")
                }else{
                    getPresenter().setInfo(nickNameDialog.content,"","")
                    nickNameDialog.dismiss()

                }

            }

            override fun cancel() {
                nickNameDialog.dismiss()
            }
        })
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
        ll_hand.setOnClickListener {
            camaraDialog.show()
        }
        var  sexDialog=SexDialog(this)
        sexDialog.setOnBtnClickListener(object : SexDialog.OnBtnClickListener {
            override fun one() {
                sexDialog.dismiss()
                getPresenter().setInfo(nickNameDialog.content,"2","")//1是女，2是男

            }

            override fun two() {
                sexDialog.dismiss()
                getPresenter().setInfo("","1","")
            }

            override fun cancel() {
                sexDialog.dismiss()
            }

        })
        ll_sex.setOnClickListener {
            sexDialog.show()
        }
        ll_phone.setOnClickListener {
            SettingPhoneActivity.startSettingPhoneActivity(this)
        }
        ll_password.setOnClickListener {
            SettingPWActivity.startSettingPWActivity(this)
        }
    }

    override fun setInfo() {
        showToast("修改成功")
    }
    companion object {
        fun  startSettingActivity(context: Context){
            var intent= Intent(context, SettingActivity::class.java)
            context.startActivity(intent)
        }
    }
    private lateinit var imageChooseHelper: ImageChooseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageChooseHelper= ImageChooseHelper(this,{
            var uri=EncodeUtils.base64Encode2String(File(it.compressPath).readBytes())
            getPresenter().setImageUri(uri)

        })
        imageChooseHelper.takePhoto.onCreate(savedInstanceState)
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
        imageChooseHelper.takePhoto.onActivityResult(requestCode, resultCode, data)
    }
}
