package com.xx.baseutilslibrary.extensions

import android.os.Debug

import com.xx.baseutilslibrary.BuildConfig

/**
 * author: Gubr
 * date: 2018/6/6
 * describe:
 */
val isDebug= BuildConfig.DEBUG

fun Debug.run(back:(()->Unit)) {
    if (isDebug) {
        back.invoke()
    }
}