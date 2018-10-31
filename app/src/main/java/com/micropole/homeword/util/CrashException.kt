package com.micropole.homeword.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ToastUtils
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.mContext

/**
 * @ClassName       CrashException
 * @Description     全局异常
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/9/13 17:15
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CrashException : Thread.UncaughtExceptionHandler {

    var applicationContext : Context? = null
    var crashing = false
    var mDefaultHandler : Thread.UncaughtExceptionHandler? = null

    fun initException(context: Context){
        applicationContext = context.getApplicationContext()
        crashing = false
        //获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        //设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(t: Thread?, e: Throwable?) {
        if (crashing){
            return
        }
        crashing = true
        ActivityUtils.finishAllActivities(true)
        if (e != null){
            mDefaultHandler?.uncaughtException(t,e)
        }
    }

    /**
     * 自定义错误处理,收集错误信息
     * 发送错误报告等操作均在此完成.
     * 开发者可以根据自己的情况来自定义异常处理逻辑
     * @param ex
     * @return true:如果处理了该异常信息;否则返回false
     */
    private fun handleException(ex : Throwable) : Boolean{
        if (ex == null) {
            Log.w("crash_exception", "handleException --- ex==null")
            return true
        }
        val msg = ex.localizedMessage ?: return false
        //使用Toast来显示异常信息
        Thread(Runnable { Looper.prepare();

            if(true){
                Log.d("", "异常信息->"+msg);
                val value: Toast = Toast . makeText (mContext, "程序出错，即将退出:\r\n" + msg,
                Toast.LENGTH_LONG);
                value.setGravity(Gravity.CENTER, 0, 0);
                value.show();

                //保存错误报告文件
               // LogToFile.w("my",msg);**//这句话可以先注释掉，这是我单独写的一个log写入类,下面已提供了该类**
            }
//              MsgPrompt.showMsg(mContext, "程序出错啦", msg+"\n点确认退出");
            Looper.loop(); }).start();
        //收集设备信息
        //collectCrashDeviceInfo(mContext);
        //保存错误报告文件
        //saveCrashInfoToFile(ex);
        //发送错误报告到服务器
        //sendCrashReportsToServer(mContext);
        return true;
    }

}