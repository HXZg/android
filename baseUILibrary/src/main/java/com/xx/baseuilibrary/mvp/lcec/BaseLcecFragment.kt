package com.xx.baseuilibrary.mvp.lcec

import android.content.Intent
import android.support.annotation.CallSuper
import android.support.v7.app.AlertDialog
import android.view.View
import com.xx.baseuilibrary.R
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import com.xx.baseutilslibrary.common.XxResourceUtil
import java.net.ConnectException
import java.util.*


/**
 * BaseFragment
 * (๑• . •๑)
 * 类描述:
 * Created by 雷小星🍀 on 2017/6/13 18:10
 */

abstract class BaseLcecFragment<ContentView : View, Data> : BaseMvpViewFragment() {
    private var viewLoading: View? = null
    /**
     * 获取内容视图
     *
     * @return 内容视图
     */
    protected var contentView: ContentView? = null
        private set
    private var viewError: View? = null
    private var viewCheckNet: View? = null
    private var mViews: ArrayList<View>? = null


    @CallSuper
    public override fun initView(view: View?) {
        initLcecView(view!!)
    }

    /**
     * 初始化Lcec
     */
    private fun initLcecView(view: View) {

        viewLoading = view.findViewById(XxResourceUtil.getId(view.context, "view_loading"))
        contentView = view.findViewById(XxResourceUtil.getId(view.context, "view_content")) as ContentView
        viewError = view.findViewById(XxResourceUtil.getId(view.context, "view_error"))
        viewCheckNet = view.findViewById(XxResourceUtil.getId(view.context, "view_check_net"))

        if (viewLoading == null) {
            throw NullPointerException("viewLoading没有被设置在布局中")
        }
        if (contentView == null) {
            throw NullPointerException("view_content没有被设置在布局中")
        }
        if (viewError == null) {
            throw NullPointerException("view_error没有被设置在布局中")
        }
        if (viewCheckNet == null) {
            throw NullPointerException("view_check_net没有被设置在布局中")
        }
        //----------
        mViews = ArrayList()
        mViews!!.add(viewLoading as View)
        mViews!!.add(contentView as ContentView)
        mViews!!.add(viewError as View)
        mViews!!.add(viewCheckNet as View)
        //--------------
        view.findViewById<View>(R.id.view_error).setOnClickListener {
            //点击错误重新加载页面
            showLoading()
            loadData(true)
        }

        view.findViewById<View>(R.id.tv_no_net).setOnClickListener {
            // 点击没有网络跳转到系统设置界面
            showNoNetWorkDlg()
        }
        //初始显示加载中对话框
        showLoading()
    }

    /**
     * 当判断当前手机没有网络时选择是否打开网络设置
     */
    fun showNoNetWorkDlg() {
        val builder = AlertDialog.Builder(context!!)
        builder.setMessage("当前无网络")
                .setPositiveButton("设置") { _, _ -> goSettings() }.setNegativeButton("知道了", null).show()
    }

    /**
     * 跳转到设置界面
     */
    fun goSettings() {
        // 跳转到系统的网络设置界面
        val intent = Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (mViews != null) {
            mViews!!.clear()
            mViews = null
        }
    }

    /**
     * 控制显示的View
     *
     * @param view 需要显示的View
     */
    protected fun showView(view: View?) {
        for (v in mViews!!) {
            v.visibility = if (v === view) View.VISIBLE else View.GONE
        }
    }

    /**
     * 显示加载中布局
     */
    protected fun showLoading() {
        showView(viewLoading)
    }

    /**
     * 显示内容布局
     */
    protected fun showContent() {
        showView(contentView)
    }

    /**
     * 显示错误布局
     */
    private fun showError() {
        showView(viewError)
    }

    /**
     * 显示检查网络布局
     */
    private fun showCheckNet() {
        showView(viewCheckNet)
    }

    /**
     * 显示错误信息
     *
     * @param throwable 错误
     * @param refresh   是否是刷新数据时
     */
    fun showError(throwable: Throwable, refresh: Boolean) {
        if (throwable is ConnectException || throwable.message == "网络错误") {
            //如果时网络出错的错误，显示检查检查网络
            showCheckNet()
        } else if (!refresh) {
            //如果在加载更多时出错，toast提示
            showContent()
            showToast(throwable.message)
        } else {
            //其他错误显示通用错误页面
            showError()
        }

    }

    /**
     * 加载数据
     *
     * @param refresh 是否是刷新数据
     */
    protected abstract fun loadData(refresh: Boolean)

    /**
     * 设置数据
     *
     * @param data 数据
     */
    abstract fun setData(data: Data?)

}
