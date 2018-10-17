package com.xx.baseutilslibrary.network;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;

/**
 * ConnectivitiesUtils
 * 类描述:网络连接工具类
 * 上次更新内容:
 * 上次更新时间:
 * 上次更新作者:
 * 作者: LeiXiaoXing on 2016/12/29 09:56
 */
@SuppressLint("MissingPermission")
public class ConnectivitiesUtils {
    private static ConnectivitiesUtils connectivitiesUtils;
    private Context context;

    private ConnectivitiesUtils() {
    }

    /**
     * 单例模式获取对象
     *
     * @return
     */
    public static ConnectivitiesUtils getIntance() {

        if (connectivitiesUtils == null) {
            connectivitiesUtils = new ConnectivitiesUtils();

        }
        return connectivitiesUtils;
    }

    public Context getContext() {
        return context;
    }

    /**
     * 全局的Context
     *
     * @param context
     */
    public void init(Context context) {
        this.context = context;
    }

    /**
     * 检查当前WIFI是否连接，两层意思——是否连接，连接是不是WIFI
     *
     * @return true表示当前网络处于连接状态，且是WIFI，否则返回false
     */
    public boolean isWifiConnected() {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null && info.isConnected()
                && ConnectivityManager.TYPE_WIFI == info.getType()) {
            return true;
        }
        return false;
    }

    /**
     * 检查当前GPRS是否连接，两层意思——是否连接，连接是不是GPRS
     *
     * @return true表示当前网络处于连接状态，且是GPRS，否则返回false
     */
    public boolean isGprsConnected() {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null && info.isConnected()
                && ConnectivityManager.TYPE_MOBILE == info.getType()) {
            return true;
        }
        return false;
    }

    /**
     * 检查当前是否连接
     *
     * @return true表示当前网络处于连接状态，否则返回false
     */
    public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            return true;
        }
        return false;
    }

    /**
     * 对大数据传输时，需要调用该方法做出判断，如果流量敏感，应该提示用户
     *
     * @return true表示流量敏感，false表示不敏感
     */

    public boolean isActiveNetworkMetered() {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return ConnectivityManagerCompat.isActiveNetworkMetered(cm);
    }

    public Intent registerReceiver(
            ConnectivityChangeReceiver receiver) {
        return context.registerReceiver(receiver,
                ConnectivityChangeReceiver.FILTER);
    }

    public void unregisterReceiver(
            ConnectivityChangeReceiver receiver) {
        context.unregisterReceiver(receiver);
    }


    public static abstract class ConnectivityChangeReceiver extends
            BroadcastReceiver {
        public static final IntentFilter FILTER = new IntentFilter(
                ConnectivityManager.CONNECTIVITY_ACTION);

        @Override
        public final void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo wifiInfo = cm
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo gprsInfo = cm
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            // 判断是否是Connected事件
            boolean wifiConnected = false;
            boolean gprsConnected = false;
            if (wifiInfo != null && wifiInfo.isConnected()) {
                wifiConnected = true;
            }
            if (gprsInfo != null && gprsInfo.isConnected()) {
                gprsConnected = true;
            }
            if (wifiConnected || gprsConnected) {
                onConnected();
                return;
            }

            // 判断是否是Disconnected事件，注意：处于中间状态的事件不上报给应用！上报会影响体验
            boolean wifiDisconnected = false;
            boolean gprsDisconnected = false;
            if (wifiInfo == null || wifiInfo != null
                    && wifiInfo.getState() == NetworkInfo.State.DISCONNECTED) {
                wifiDisconnected = true;
            }
            if (gprsInfo == null || gprsInfo != null
                    && gprsInfo.getState() == NetworkInfo.State.DISCONNECTED) {
                gprsDisconnected = true;
            }
            if (wifiDisconnected && gprsDisconnected) {
                onDisconnected();
                return;
            }
        }

        protected abstract void onDisconnected();

        protected abstract void onConnected();
    }
}
