package com.micropole.homemodule.util

import cn.qqtheme.framework.util.DateUtils

/**
 * @ClassName       TimerUtil
 * @Description     时间工具
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/24 8:44
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
object TimerUtil {

    const val DATE_RANGE = 100

    /**
     * 日期自增一天
     */
    fun addDate(year : Int,month:Int,day:Int) : IntArray{
        var mDates = intArrayOf(year,month,day)
        val days = DateUtils.calculateDaysInMonth(year, month)
        if (day + 1 > days){
            if (month == 12){
                mDates[0] = ++mDates[0]
                mDates[1] = 1
                mDates[2] = 1
            }else{
                mDates[1] = ++mDates[1]
                mDates[2] = 1
            }
        }else{
            mDates[2] = ++mDates[2]
        }
        return mDates
    }
}