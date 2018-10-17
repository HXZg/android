package com.xx.baseutilslibrary.extensions

import android.support.v4.view.ViewPropertyAnimatorUpdateListener
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.blankj.utilcode.util.ImageUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.request.RequestOptions
import com.xx.baseutilslibrary.network.retrofit.Retrofit2Manager
/**
 * author: Gubr
 * date: 2018/5/7
 * describe:
 */




/**
 * 加载图片
 */
fun ImageView.loadImag( url: String, tran: BitmapTransformation? = null, plach: Int = 0, error: Int = 0) {
    var urltemp=url
    if (url.length>1&&url[0].equals('/')) {
        urltemp=Retrofit2Manager.instance.apiConfigProvider?.debugHost+url
    }
    val options = RequestOptions().also {
        if (tran != null) it.transform(tran)
        if (plach != 0) it.placeholder(plach)
        if (error != 0) it.error(error)
    }
    Glide.with(this.context).applyDefaultRequestOptions(options).load(urltemp).into(this)
    /*Glide.with(this.context).load(urltemp).also {
        if (tran != null) {
            it.transform(tran)
        }
        if (plach != 0) {
            it.placeholder(plach)
        }
        if (error != 0) {
            it.error(error)
        }
    }.into(this)*/
}


fun TextView.setHtmlText(content: String) {
    this.text = Html.fromHtml(content)
}




