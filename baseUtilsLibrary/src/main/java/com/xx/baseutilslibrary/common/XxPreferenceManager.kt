package com.xx.baseutilslibrary.common

import android.content.Context
import android.content.SharedPreferences

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.xx.baseutilslibrary.entity.BaseGsonEntity

/**
 * XxPreferenceManager
 * (๑• . •๑)
 * 类描述: SharedPreferences管理类
 * Created by 雷小星🍀 on 2017/6/20 13:41
 */

object XxPreferenceManager {
    /**
     * 默认SharedPreferences存储文件名称
     */
    private val DefaultSharedPreferencesName = "default"

    /**
     * 获取SharedPreferences
     *
     * @param context 上下文对象
     * @param spName  SharedPreferences存储文件名
     * @return SharedPreferences
     */
    fun getSharedPreferences(context: Context, spName: String): SharedPreferences {
        return context.getSharedPreferences(spName, Context.MODE_PRIVATE)
    }

    /**
     * 获取默认SharedPreferences存储文件
     *
     * @param context 上下文对象
     * @return SharedPreferences
     */
    fun getDefaultSharedPreferences(context: Context): SharedPreferences {
        return getSharedPreferences(context, DefaultSharedPreferencesName)
    }

    /**
     * 存入数据
     *
     * @param sharedPreferences SharedPreferences对象
     * @param key               键
     * @param value             值
     */
    fun putValue(sharedPreferences: SharedPreferences, key: String, value: Any) {
        val editor = sharedPreferences
                .edit()
        if (value is String) {
            editor.putString(key, value).apply()
        } else if (value is Int) {
            editor.putInt(key, value).apply()
        } else if (value is Float) {
            editor.putFloat(key, value).apply()
        } else if (value is Long) {
            editor.putLong(key, value).apply()
        } else if (value is Boolean) {
            editor.putBoolean(key, value).apply()
        } else if (value is BaseGsonEntity) {
            //存入的是对象，使用gson序列化存入
            val toJson = Gson().toJson(value)
            editor.putString(key, toJson)
        }
    }

    fun <T> getValue(sharedPreferences: SharedPreferences, key: String, defValue: T): T? {
        if (defValue is String) {
            return sharedPreferences.getString(key, defValue as String) as T
        } else if (defValue is Int) {
            return sharedPreferences.getInt(key, defValue as Int) as T
        } else if (defValue is Float) {
            return sharedPreferences.getFloat(key, defValue as Float) as T
        } else if (defValue is Long) {
            return sharedPreferences.getLong(key, defValue as Long) as T
        } else if (defValue is Boolean) {
            return sharedPreferences.getBoolean(key, defValue as Boolean) as T
        } else if (defValue is BaseGsonEntity) {
            val string = sharedPreferences.getString(key, "")
            return Gson().fromJson(string, object : TypeToken<T>() {
            }.type) as T
        }
        return null
    }

    /**
     * 清空SharedPreferences对象中存储的数据
     *
     * @param sharedPreferences SharedPreferences对象
     */
    fun clear(sharedPreferences: SharedPreferences) {
        sharedPreferences
                .edit()
                .clear()
                .apply()
    }

}
