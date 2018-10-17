package com.xx.baseutilslibrary.status_bar.bar;

import android.app.Activity;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * MeizuStatusBar
 * (๑• . •๑)
 * 类描述:魅族手机状态栏字体颜色改变
 * Created by 雷小星🍀 on 2017/6/21 09:51
 */

public class MeizuStatusBar implements IStatusBar {
    @Override
    public boolean setStatusBarLightMode(Activity activity, boolean isFontColorDark) {
        boolean result = false;
        if (activity != null) {
            try {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (isFontColorDark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                activity.getWindow().setAttributes(lp);
                result = true;
            } catch (Exception ignored) {
            }
        }
        return result;
    }
}
