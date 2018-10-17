package com.xx.baseutilslibrary.extensions

import android.app.Activity
import android.support.v4.app.Fragment

import android.widget.Toast

/**
 * author: Gubr
 * date: 2018/5/9
 * describe:
 */
fun Fragment.toast(content: String, duration: Int= Toast.LENGTH_SHORT){
    Toast.makeText(activity,content,duration).show()
}