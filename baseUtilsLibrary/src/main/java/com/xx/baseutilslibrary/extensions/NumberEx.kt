package com.xx.baseutilslibrary.extensions

/**
* author: Gubr
* date: 2018/3/2
* describe:
*/
fun Number.format(digits:Int):kotlin.String{
    return String.format("%.${digits}f", this.toDouble())
}