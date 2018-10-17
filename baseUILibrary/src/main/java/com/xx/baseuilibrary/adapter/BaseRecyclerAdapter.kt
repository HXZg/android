package com.xx.baseuilibrary.adapter

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.xx.baseuilibrary.R

import java.util.ArrayList

/**
 * BaseRecyclerAdapter
 * (๑• . •๑)
 * 类描述:普通RecycleView的普通BaseAdapter
 * 支持多类型item，
 * 支持加载更多,通过{[BaseRecyclerAdapter.applyLoadMore]开启}
 * 支持Empty布局
 * Created by LeiXiaoXing on 2017/3/17 14:26
 */

abstract class BaseRecyclerAdapter<E, VH : BaseViewHolder<E>> protected constructor() : RecyclerView.Adapter<BaseViewHolder<E>>() {
    private var limit = 20//默认20条数据
    private var mEList: MutableList<E?>? = null
    private var mContext: Context? = null
    private var mListener: OnItemClickListener<E>? = null

    /**
     * 是否支持加载更多,默认关闭
     */
    private var canLoadMore = false
    /**
     * 是否加载完列表的全部数据
     */
    /**
     * 是否加载完成全部数据
     *
     * @return boolean
     */
    var isLoadAll: Boolean = false
        private set
    private var emptyView: View? = null//空布局视图
    private var emptyViewLayoutId: Int = 0//空布局布局id
    private var recyclerView: RecyclerView? = null

    /**
     * 获取数据集合
     *
     * @return
     */
    val eList: List<E?>?
        get() = mEList

    /**
     * 获取每页限制数据条数
     *
     * @return
     */
    fun getLimit(): Int {
        return limit
    }

    /**
     * 设置每页数据条数
     *
     * @param limit 限制数据条数
     */
    fun setLimit(limit: Int): BaseRecyclerAdapter<E, VH> {
        this.limit = limit
        return this
    }


    /**
     * 应用加载更多操作
     *
     * @param loadMoreListener 加载更多触发
     */
    fun applyLoadMore(loadMoreListener: OnLoadMoreListener?) {
        this.canLoadMore = true
        recyclerView!!.addOnScrollListener(object : RecyclerViewScrollListener() {
            override val limit: Int
                get() = limit

            override fun onLoadMore() {
                loadMoreListener?.onLoadMore()
            }
        })
    }

    /**
     * 设置空布局
     *
     * @param emptyView 空布局
     */
    fun setEmptyView(emptyView: View) {
        this.emptyView = emptyView
    }

    /**
     * 设置空布局布局文件id
     *
     * @param emptyViewLayoutId 空布局布局文件id
     */
    fun setEmptyView(@LayoutRes emptyViewLayoutId: Int) {
        this.emptyViewLayoutId = emptyViewLayoutId
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        //拿到RecyclerView
        this.recyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<E> {
        if (mContext == null) {
            mContext = parent.context
        }
        val measuredWidth = parent.measuredWidth - parent.paddingLeft - parent.paddingLeft
        if (viewType == ITEM_TYPE_LOAD_MORE) {
            //返回加载更多类型 ViewHolder
            val view = LayoutInflater.from(mContext).inflate(R.layout.item_view_load_and_all, parent, false)
            return LoadMoreViewHolder(view)
        } else if (viewType == ITEM_TYPE_EMPTY) {
            //返回空布局类型 ViewHolder
            if (emptyView != null) {
                //传入空布局
                return EmptyViewHolder(emptyView!!)
            } else if (emptyViewLayoutId != 0) {
                //传入空布局id
                val view = LayoutInflater.from(mContext).inflate(emptyViewLayoutId, parent, false)
                return EmptyViewHolder(view)
            } else {
                val view = LayoutInflater.from(mContext).inflate(R.layout.item_view_empty, parent, false)
                return EmptyViewHolder(view)
            }

        } else {
            val view = LayoutInflater.from(mContext).inflate(getItemLayout(viewType), parent, false)
            setItemWidth(false, view, measuredWidth)
            return createViewHolder(view, viewType)
        }
    }

    fun setItemWidth(b: Boolean, view: View, measuredWidth: Int) {
        if (b) {
            view.layoutParams.width = (measuredWidth - view.paddingLeft - view.paddingRight) / 3
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<E>, position: Int) {
        val adapterPosition = holder.adapterPosition

        holder.itemView.setOnClickListener(View.OnClickListener {
            if (mListener != null) {
                if (mEList!![adapterPosition] == null) {
                    return@OnClickListener
                }
                mListener!!.onItemClick(adapterPosition, mEList!![adapterPosition])
            }
        })
        holder.bindView(adapterPosition, mEList!![adapterPosition])

    }

    override fun getItemViewType(position: Int): Int {
        if (canLoadMore && position > limit - 1 && position == mEList!!.size - 1) {
            //如果开启加载更多，显示加载中
            return ITEM_TYPE_LOAD_MORE
        } else if (mEList!![0] == null) {
            //如果无内容，显示空布局
            return ITEM_TYPE_EMPTY
        }
        return getCustomItemViewType(position)
    }

    /**
     * 创建自定义的item Type
     *
     * @param position item下标
     * @return 自定义item Type
     */
    protected fun getCustomItemViewType(position: Int): Int {
        return 0
    }

    /**
     * 创建ViewHolder
     *
     * @param view     item
     * @param viewType item视图类型
     * @return ViewHolder
     */
    protected abstract fun createViewHolder(view: View, viewType: Int): VH

    /**
     * 获取子项布局文件id
     *
     * @return 子项布局文件id
     */
    protected abstract fun getItemLayout(viewType: Int): Int

    /**
     * 刷新列表数据
     *
     * @param entitys 新的数据集合
     */
    fun upDate(entitys: MutableList<E?>?) {
        this.mEList = entitys
        isLoadAll = false//刷新列表,取消已加载完全部状态
        if (entitys != null && entitys.size != 0) {
            //有内容，移除EmptyView
            mEList!!.remove(null)
        }
        notifyDataSetChanged()
    }

    /**
     * 追加数据并更新
     *
     * @param entitys 新的数据集合
     */
    fun upDateAdd(entitys: MutableList<E?>?) {

        if (this.mEList == null) {
            mEList = entitys//没有初始化集合时,直接用当前集合覆盖
            if (entitys != null && entitys.size != 0) {
                //有内容，移除EmptyView
                mEList!!.remove(null)
            }
        } else if (entitys != null) {
            //启用加载更多时
            if (canLoadMore) {
                //用当前页数数据是否为空标识是否加载全部
                isLoadAll = entitys.size == 0
                if (entitys.size != 0) {
                    //移除加载更多
                    isLoadAll = false
                }
            }
            //移除空布局,移除加载更多
            mEList!!.remove(null)
            mEList!!.addAll(entitys)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        if (canLoadMore && mEList != null && mEList!!.size >= limit) {
            //数据条数大于每页条数时显示加载更多
            //添加加载更多到尾部
            if (!mEList!!.contains(null)) {
                mEList!!.add(null)
            }
        } else if (mEList == null || mEList!!.size == 0) {
            //无内容，添加EmptyView
            mEList = ArrayList()
            mEList!!.add(null)
        }
        return mEList!!.size
    }

    fun setOnItemClickListener(listener: OnItemClickListener<E>) {
        mListener = listener
    }

    interface OnItemClickListener<E> {
        fun onItemClick(position: Int, entity: E?)
    }

    interface OnLoadMoreListener {
        fun onLoadMore()
    }


    /**
     * 加载更多item以及加载完全部  ViewHolder
     */
    private inner class LoadMoreViewHolder internal constructor(itemView: View) : BaseViewHolder<E?>(itemView) {

        private var viewLoadAll: View? = null
        private var viewLoading: View? = null

        override fun initView(itemView: View) {
            viewLoadAll = itemView.findViewById(R.id.view_load_all)
            viewLoading = itemView.findViewById(R.id.view_loading)
            itemView.setOnClickListener(null)
        }

        override fun bindView(position: Int, entity: E?) {
            viewLoadAll!!.visibility = if (isLoadAll) View.VISIBLE else View.GONE
            viewLoading!!.visibility = if (isLoadAll) View.GONE else View.VISIBLE
        }
    }

    /**
     * 空布局ViewHolder
     */
    private inner class EmptyViewHolder internal constructor(view: View) : BaseViewHolder<E?>(view) {

        override fun initView(itemView: View) {
            itemView.setOnClickListener(null)
        }

        override fun bindView(position: Int, entity: E?) {

        }
    }

    companion object {
        /**
         * Item类型:  加载更多
         */
        private val ITEM_TYPE_LOAD_MORE = -1
        /**
         * Item类型： Empty
         */
        private val ITEM_TYPE_EMPTY = -2
    }

}
