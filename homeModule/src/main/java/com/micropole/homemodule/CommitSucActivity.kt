package com.micropole.homemodule

import android.content.Context
import android.content.Intent
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.PhoneUtils
import com.flyco.dialog.listener.OnBtnClickL
import com.flyco.dialog.widget.NormalDialog
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.entity.LandlordBean
import com.micropole.homemodule.entity.OrderDetailBean
import com.micropole.homemodule.mvp.constract.CommitSucConstract
import com.micropole.homemodule.mvp.present.CommitSucPresent
import com.micropole.homemodule.order.OrderDetailActivity
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_commit_success.*

/**
 * @ClassName       CommitSucActivity
 * @Description     提交成功
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/19 15:13
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class CommitSucActivity : BaseMvpActivity<CommitSucConstract.Present>(),CommitSucConstract.View{

    companion object {
        fun startCommitSuc(context: Context,orId:String){
            val intent = Intent(context, CommitSucActivity::class.java)
            intent.putExtra("order_id",orId)
            context.startActivity(intent)
        }
    }

    var mHid = ""
    var mOid = ""

    override fun getActivityLayoutId(): Int =  R.layout.activity_commit_success

    override fun createPresenter(): CommitSucConstract.Present {
        return CommitSucPresent()
    }

    override fun initData() {
        val orderId = intent.getStringExtra("order_id")
        getPresenter().orderDetail(orderId)
    }

    override fun initEvent() {
        fl_landlord.setOnClickListener { getPresenter().getUserPhone(mHid) }  //联系房东
        fl_see_order.setOnClickListener { OrderDetailActivity.startOrderDetail(mContext,mOid) }  //查看订单
        fl_return_home.setOnClickListener { ARouter.getInstance().build(ARouterConst.Main.MAIN_MAIN).navigation() }  //返回首页
    }

    override fun getDetail(bean: OrderDetailBean) {
        mHid = bean.h_id
        mOid = bean.or_id
        tv_house_name_des.text = bean.h_title
        tv_open_time.text = bean.start_time
        tv_leave_time.text = bean.end_time
        tv_order_sn.text = bean.or_id
    }

    override fun userPhone(bean: LandlordBean?) {
        if (bean != null) callPhone(bean.user_phone)
    }

    fun callPhone(phone:String){
        val normalDialog = NormalDialog(mContext)
        normalDialog.style(NormalDialog.STYLE_TWO)
        normalDialog.isTitleShow(false)
        normalDialog.content(phone)
        normalDialog.btnText("取消","呼叫")
        normalDialog.btnTextColor(resources.getColor(R.color.btn_bg),resources.getColor(R.color.btn_bg))
        normalDialog.setOnBtnClickL(OnBtnClickL { normalDialog.dismiss() }, OnBtnClickL {
            PhoneUtils.call(phone)
            normalDialog.dismiss()
        })
        normalDialog.show()
    }
}