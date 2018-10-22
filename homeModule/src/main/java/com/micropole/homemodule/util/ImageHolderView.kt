package com.micropole.homemodule.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bigkoo.convenientbanner.holder.Holder
import com.xx.baseutilslibrary.extensions.loadImag

/**
 * author: HuaiXianZhong
 * date: 2018/8/16
 * describe:
 */
class ImageHolderView : Holder<String>{
    var imageview : ImageView? = null

    override fun UpdateUI(context: Context?, position: Int, data: String?) {
        imageview?.loadImag(data ?: "")
    }

    override fun createView(context: Context?): View {
        imageview = ImageView(context)
        imageview?.scaleType = ImageView.ScaleType.FIT_XY
        return imageview as View
    }
}