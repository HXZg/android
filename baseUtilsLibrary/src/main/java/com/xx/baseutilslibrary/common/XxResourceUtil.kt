package com.xx.baseutilslibrary.common

import android.content.Context

/**
 * XxResourceUtil
 * 沉迷学习不能自拔
 * Describe：反射获取Android资源文件ID
 * Created by 雷小星🍀 on 2017/11/28 16:53.
 */

object XxResourceUtil {

    fun getLayoutId(paramContext: Context, paramString: String): Int {
        return paramContext.resources.getIdentifier(paramString, "layout",
                paramContext.packageName)
    }

    fun getStringId(paramContext: Context, paramString: String): Int {
        return paramContext.resources.getIdentifier(paramString, "string",
                paramContext.packageName)
    }

    fun getDrawableId(paramContext: Context, paramString: String): Int {
        return paramContext.resources.getIdentifier(paramString,
                "drawable", paramContext.packageName)
    }

    fun getStyleId(paramContext: Context, paramString: String): Int {
        return paramContext.resources.getIdentifier(paramString,
                "style", paramContext.packageName)
    }

    fun getId(paramContext: Context, paramString: String): Int {
        return paramContext.resources.getIdentifier(paramString,
                "id", paramContext.packageName)
    }

    fun getColorId(paramContext: Context, paramString: String): Int {
        return paramContext.resources.getIdentifier(paramString,
                "color", paramContext.packageName)
    }

    fun getArrayId(paramContext: Context, paramString: String): Int {
        return paramContext.resources.getIdentifier(paramString,
                "array", paramContext.packageName)
    }
}
