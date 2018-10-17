package com.xx.baseuilibrary.mvp.lcec

import android.support.annotation.CallSuper
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.View

import com.xx.baseuilibrary.R
import com.xx.baseuilibrary.adapter.BaseRecyclerAdapter
import com.xx.baseuilibrary.adapter.BaseViewHolder
import com.xx.baseuilibrary.mvp.contract.BaseMvpRecyclerViewContract
import com.xx.baseuilibrary.mvp.presenter.BaseMvpRecyclerViewPresenter
import com.xx.baseutilslibrary.common.XxResourceUtil

/**
 * SeasonPlayActivity
 * (。・∀・)ノ
 * Describe： 封装了下拉刷新上拉加载更多的RecycleViewFragment
 * Created by 雷小星🍀 on 2017/8/3 15:40.
 */

abstract class BaseMvpRecyclerViewFragment<E> : BaseMvpLcecFragment<SwipeRefreshLayout, MutableList<E?>, BaseMvpRecyclerViewContract.Model<E>, BaseMvpRecyclerViewContract.View<E>, BaseMvpRecyclerViewContract.Presenter<E>>(), BaseMvpRecyclerViewContract.View<E> {

    var recyclerView: RecyclerView? = null
        private set
    /**
     * 获取适配器
     *
     * @return
     */
    protected var adapter: BaseRecyclerAdapter<E, out BaseViewHolder<E>>? = null
        private set

    /**
     * 获取每页数据条数
     *
     * @return 每页数据条数
     */
    protected abstract val listLimit: Int

    protected abstract val layoutManager: RecyclerView.LayoutManager

    override fun createPresenter(): BaseMvpRecyclerViewPresenter<E> = BaseMvpRecyclerViewPresenter(createModel())

    /**
     * 创建Adapter
     *
     * @return Adapter
     */
    protected abstract fun createAdapter(): BaseRecyclerAdapter<E, out BaseViewHolder<E>>

    /**
     * 创建Model
     *
     * @return Model
     */
    protected abstract fun createModel(): BaseMvpRecyclerViewContract.Model<E>

    public override fun getFragmentLayoutId(): Int {
        return R.layout.fragment_list
    }

    @CallSuper
    override fun initView(view: View?) {
        super.initView(view)

        recyclerView = view!!.findViewById(R.id.recyclerView) as RecyclerView
        recyclerView!!.layoutManager = layoutManager

        adapter = createAdapter()
        if (adapter == null) {
            throw NullPointerException("请构造你的适配器")
        }
        adapter!!.setLimit(listLimit)
                .applyLoadMore(object : BaseRecyclerAdapter.OnLoadMoreListener {
                    override fun onLoadMore() {
                        if ((!presenter.isLoading!!) && !adapter!!.isLoadAll) {
                            loadData(false)
                        }
                    }
                })
        recyclerView!!.adapter = adapter
        //默认使用colorAccent颜色
        contentView?.setColorSchemeResources(XxResourceUtil.getColorId(mContext, "colorAccent"))
    }


    public override fun initData() {
        loadData(true)//初始化时进行一次刷新操作
    }

    @CallSuper
    public override fun initEvent(view: View?) {
        //下拉刷新
        contentView?.setOnRefreshListener {
            if ((!presenter.isLoading!!)) {
                loadData(true)
            } else {
                showToast("数据加载中,请稍后")
                contentView?.isRefreshing = false
            }
        }
    }

    override fun loadData(refresh: Boolean) {
        presenter.loadData(refresh)
    }


    override fun setData(data: MutableList<E?>?) {
        showContent()
        if (contentView!!.isRefreshing) {
            contentView?.isRefreshing = false
        }
        adapter!!.upDate(data)
    }

    override fun upDateAdd(entities: MutableList<E?>?) {
        adapter!!.upDateAdd(entities)
    }
}
