package com.micropole.baseapplibrary.util

import android.app.Activity
import android.net.Uri
import android.os.Environment
import org.devio.takephoto.app.TakePhoto
import org.devio.takephoto.app.TakePhotoImpl
import org.devio.takephoto.compress.CompressConfig
import org.devio.takephoto.model.*
import org.devio.takephoto.permission.InvokeListener
import org.devio.takephoto.permission.PermissionManager
import org.devio.takephoto.permission.TakePhotoInvocationHandler
import org.devio.takephoto.uitl.TFileUtils
import java.io.File
import java.util.*


/**
 * @ClassName       ImageChooseHelper
 * @Description     图片选择
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/8 11:43
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ImageChooseHelper(val activity : Activity, val action : (image : TResult) -> Unit) : TakePhoto.TakeResultListener, InvokeListener {
    var takePhoto : TakePhoto = TakePhotoInvocationHandler.of(this).bind(TakePhotoImpl(activity, this)) as TakePhoto

    var invokeParam : InvokeParam? = null

    /**
     * 成功回调
     */
    override fun takeSuccess(result: TResult?) {
        if (result != null) {
            action.invoke(result)
            //删除压缩后的图片
            for (i in result.images.indices){
                TFileUtils.delete(result.images[i].compressPath)
            }
        }
    }

    override fun takeFail(result: TResult?, msg: String?) {
        //失败
    }

    override fun takeCancel() {
        //取消
    }

    override fun invoke(invokeParam: InvokeParam?): PermissionManager.TPermissionType {
        val type = PermissionManager.checkPermission(TContextWrap.of(activity), invokeParam?.method!!)
        if (PermissionManager.TPermissionType.WAIT == type) {
            this.invokeParam = invokeParam
        }
        return type
    }

    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //以下代码为处理Android6.0、7.0动态权限所需
        val type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionManager.handlePermissionsResult(activity, type, invokeParam, this)
    }

    fun selectPicker(limit : Int = 1){
        configCompress(takePhoto)
        configTakePhotoOption(takePhoto)
        if (limit > 1) takePhoto.onPickMultipleWithCrop(limit,getCropOptions()) //多图选择并裁切
        /*
        //多图选择临时存储文件路劲
        val filesDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if (!filesDir!!.exists()) {
            filesDir!!.mkdirs()
        }
        val photoFile = File(filesDir, UUID.randomUUID().toString() + "." + ".jpg==")*/
        takePhoto.onPickFromGalleryWithCrop(getUri(), getCropOptions())  //从相册选择单张图片
    }

    /**
     * 拍照并裁切
     */
    fun takePhoto(){
        configCompress(takePhoto)
        configTakePhotoOption(takePhoto)
        takePhoto.onPickFromCaptureWithCrop(getUri(), getCropOptions())
    }

    fun getUri() : Uri{
        val filesDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if (!filesDir!!.exists()) {
            filesDir!!.mkdirs()
        }
        val photoFile = File(filesDir, UUID.randomUUID().toString() + "." + "jpg")
        //val file = File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg")
        if (!photoFile.parentFile.exists()) {
            photoFile.parentFile.mkdirs()
        }
        return Uri.fromFile(photoFile)
    }

    private fun configCompress(takePhoto: TakePhoto) {
        val maxSize = 102400
        val width = 800
        val height = 800
        val showProgressBar = true
        val enableRawFile = false
        val config: CompressConfig
        config = CompressConfig.Builder().setMaxSize(maxSize)
                .setMaxPixel(width)
                .enableReserveRaw(enableRawFile)
                .create()
        takePhoto.onEnableCompress(config, showProgressBar)
    }

    private fun configTakePhotoOption(takePhoto: TakePhoto) {
        val builder = TakePhotoOptions.Builder()
        builder.setCorrectImage(true)
        takePhoto.setTakePhotoOptions(builder.create())
    }

    private fun getCropOptions(): CropOptions? {
        val height = 200
        val width = 200
        val withWonCrop = false

        val builder = CropOptions.Builder()

        builder.setOutputX(width).setOutputY(height)
        builder.setWithOwnCrop(withWonCrop)
        return builder.create()
    }
}