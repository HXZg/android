package com.micropole.minemodule

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.minemodule.activity.*
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.bar_title.*
import kotlinx.android.synthetic.main.fragment_mine.*
import kotlinx.android.synthetic.main.fragment_mine.view.*

/**
 * @ClassName       MineFragment
 * @Description     个人中心
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/16 16:23
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Mine.MINE_FRAGMENT)
class MineFragment : BaseMvpViewFragment(), View.OnClickListener {


    override fun getFragmentLayoutId(): Int = R.layout.fragment_mine

    override fun initView(view: View?) {
    }

    override fun initEvent(view: View?) {
        Log.i("ss","dd")
        tv_title.text="个人中心"
        iv_back.visibility=View.GONE
        iv_other.visibility=View.VISIBLE
        ll_collection.setOnClickListener(this)
        ll_footmark.setOnClickListener(this)
        ll_tour.setOnClickListener(this)
        ll_fandong.setOnClickListener(this)
        ll_zhima.setOnClickListener(this)
        ll_invite.setOnClickListener(this)
        ll_exit.setOnClickListener(this)
        iv_setting.setOnClickListener(this)

        iv_other.setOnClickListener(this)
    }

    override fun initData() {
    }
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {
        when(v){
            iv_other -> ARouter.getInstance().build(ARouterConst.Mine.MINE_NOTICE).navigation()
            ll_collection->{//我的收藏
                ARouter.getInstance().build(ARouterConst.Mine.MINE_COLLECT).navigation()
            }
            ll_footmark->{//我的足迹
                ARouter.getInstance().build(ARouterConst.Mine.MINE_COLLECT).withInt("type",1).navigation()
            }
            ll_tour->{//旅游基金
                TripActivity.startTripActivity(mContext)

            }
            ll_fandong->{//成为房东
                HouseOwnerActivity.startHouseOwnerActivity(mContext)

            }
            ll_zhima->{//芝麻信用
                ZhimaActivity.startZhimaActivity(mContext)

            }
            ll_invite->{//邀请好友
                InviteActivity.startInviteActivity(mContext)

            }
            ll_exit->{//注销
                ARouter.getInstance().build(ARouterConst.Login.LOGIN_ACTIVITY).navigation()


            }
            iv_setting->{//设置资料
                SettingActivity.startSettingActivity(mContext)

            }
        }

    }
}