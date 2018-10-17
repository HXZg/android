package com.xx.baseutilslibrary.status_bar.bar;

import android.app.Activity;
import android.view.Window;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * MiuiStatusbar
 * (๑• . •๑)
 * 类描述:小米手机状态栏字体颜色改变
 * Created by 雷小星🍀 on 2017/6/21 09:52
 */

public class MiuiStatusbar implements IStatusBar {
    /**
     * 设置状态栏字体图标为深色，需要MIUI6以上
     *
     * @param isFontColorDark 是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    @Override
    public boolean setStatusBarLightMode(Activity activity, boolean isFontColorDark) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(activity.getWindow(), isFontColorDark ? darkModeFlag : 0, darkModeFlag);
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }
}
