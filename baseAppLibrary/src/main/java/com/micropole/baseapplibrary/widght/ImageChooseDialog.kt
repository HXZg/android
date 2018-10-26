package com.micropole.baseapplibrary.widght

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.Button
import com.flyco.animation.SlideEnter.SlideBottomEnter
import com.flyco.animation.SlideExit.SlideBottomExit
import com.flyco.dialog.widget.base.BaseDialog
import com.micropole.baseapplibrary.R

/**
 * @ClassName       ImageChooseDialog
 * @Description     相册选择弹框
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/17 14:07
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class ImageChooseDialog(context : Context,val action : (index : Int) -> Unit) : BaseDialog<ImageChooseDialog>(context) {
    override fun setUiBeforShow() {
        showAnim(SlideBottomEnter())
        dismissAnim(SlideBottomExit())
        dimEnabled(true)
        //setCancelable(false)
        //setCanceledOnTouchOutside(false)
        mLlTop.gravity = Gravity.BOTTOM

        mOnCreateView.findViewById<Button>(R.id.btn_cancel).setOnClickListener { dismiss() }
        mOnCreateView.findViewById<Button>(R.id.btn_photo).setOnClickListener {
            action.invoke(0)
            dismiss()
        }
        mOnCreateView.findViewById<Button>(R.id.btn_album).setOnClickListener {
            action.invoke(1)
            dismiss()
        }

    }

    override fun onCreateView(): View {
        return View.inflate(mContext, R.layout.dialog_chooseimage,null)
    }
}