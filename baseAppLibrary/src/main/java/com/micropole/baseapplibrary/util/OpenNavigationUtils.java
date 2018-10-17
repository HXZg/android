package com.micropole.baseapplibrary.util;

import android.content.Intent;

import com.blankj.utilcode.util.Utils;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by JacobHHH on 2018/4/26.
 * 打开第三方导航
 */

public class OpenNavigationUtils {

    private static String mPackNames[] = {"com.autonavi.minimap", "com.baidu.BaiduMap"};
    private static String mMapNames[] = {"高德地图", "百度地图"};


    /**
     * 百度地图
     *
     * @param currentLatitude
     * @param currentLongitude
     */
    public static void openBaidu(String currentLatitude, String currentLongitude) {
        try {
            Intent naviIntent = new Intent("android.intent.action.VIEW",
                    android.net.Uri.parse("baidumap://map/geocoder?location=" + currentLatitude + "," + currentLongitude));
            naviIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Utils.getApp().startActivity(naviIntent);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 打开地图
     * @param map
     * @param currentLatitude
     * @param currentLongitude
     */
    public static void openMap(String map, String currentLatitude, String currentLongitude){
        if (mMapNames[0].equals(map)) {
            openGaode(currentLatitude, currentLongitude);
        } else if (mMapNames[1].equals(map)) {
            openBaidu(currentLatitude, currentLongitude);
        }
    }

    /**
     * 高德地图
     *
     * @param currentLatitude
     * @param currentLongitude
     */
    public static void openGaode(String currentLatitude, String currentLongitude) {
        try {

            Intent intent = new Intent("android.intent.action.VIEW", android.net.Uri.parse(
                    "androidamap://route?sourceApplication=appName&slat=&slon=&sname=我的位置&dlat="
                            + currentLatitude
                            + "&dlon="
                            + currentLongitude
                            + "&dname=目的地&dev=0&t=2"));


            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Utils.getApp().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 检测是否有安装相关的第三方地图
     *
     * @param packageName
     * @return
     */
    public static boolean isInstallByread(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }


    public static ArrayList<String> getInstatllMapSet() {
        final ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < mPackNames.length; i++) {
            final boolean installByread = isInstallByread(mPackNames[i]);
            if (installByread) {
                strings.add(mMapNames[i]);
            }
        }
        return strings;
    }

    /**
     * 高德转百度经纬度
     *
     * @param gd_lon
     * @param gd_lat
     * @return
     */
    public static double[] gaoDeToBaidu(double gd_lon, double gd_lat) {
        double[] bd_lat_lon = new double[2];
        double PI = 3.14159265358979324 * 3000.0 / 180.0;
        double x = gd_lon, y = gd_lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * PI);
        bd_lat_lon[0] = z * Math.cos(theta) + 0.0065;
        bd_lat_lon[1] = z * Math.sin(theta) + 0.006;
        return bd_lat_lon;
    }
}
