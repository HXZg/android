package com.xx.baseutilslibrary.status_bar;

import android.app.Activity;

import com.xx.baseutilslibrary.status_bar.bar.MeizuStatusBar;
import com.xx.baseutilslibrary.status_bar.bar.MiuiStatusbar;
import com.xx.baseutilslibrary.status_bar.bar.OSMStatusBar;


/**
 * StatusBarUtils
 * (๑• . •๑)
 * 类描述:状态栏字体颜色修改工具
 * Created by 雷小星🍀 on 2017/6/21 09:52
 */

public class StatusBarUtils {
    /**
     * 对Activity应用字体颜色
     *
     * @param activity   要修改状态栏字体颜色的Activity
     * @param isDarkFont 是否黑色字体
     */
    public static boolean apply(Activity activity, boolean isDarkFont) {
        if (new MiuiStatusbar().setStatusBarLightMode(activity, isDarkFont)) {
            return true;
        } else if (new MeizuStatusBar().setStatusBarLightMode(activity, isDarkFont)) {
            return true;
        } else if (new OSMStatusBar().setStatusBarLightMode(activity, isDarkFont)) {
            return true;
        }
        return false;
    }
}
