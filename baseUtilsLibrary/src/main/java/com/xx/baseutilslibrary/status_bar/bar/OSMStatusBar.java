package com.xx.baseutilslibrary.status_bar.bar;

import android.app.Activity;
import android.os.Build;
import android.view.View;

/**
 * OSMStatusBar
 * (๑• . •๑)
 * 类描述: Android M的状态栏
 * Created by 雷小星🍀 on 2017/6/21 10:28
 */

public class OSMStatusBar implements IStatusBar {
    /**
     * 版本不低于M时
     *
     * @param activity        需要修改状态蓝字体颜色的Activity
     * @param isFontColorDark 是否黑色字体
     * @return
     */
    @Override
    public boolean setStatusBarLightMode(Activity activity, boolean isFontColorDark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!isFontColorDark) {
                activity.getWindow().getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            } else {
                activity.getWindow().getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            return true;
        }
        return false;
    }
}
