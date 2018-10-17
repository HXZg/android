package com.xx.baseutilslibrary.status_bar.bar;

import android.app.Activity;

/**
 * IStatusBar
 * (๑• . •๑)
 * 类描述:
 * Created by 雷小星🍀 on 2017/6/21 09:49
 */

public interface IStatusBar {
    /**
     * 设置状态栏字体颜色
     *
     * @param activity        需要修改状态蓝字体颜色的Activity
     * @param isFontColorDark 是否黑色字体
     */
    boolean setStatusBarLightMode(Activity activity, boolean isFontColorDark);
}
