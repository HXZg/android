package com.micropole.minemodule.dailog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.micropole.minemodule.R;


/**
 * Created by JacobHHH on 2018/4/22.
 */

public class CamaraDialog extends Dialog  {

    private Context mContext;
    private EditText et_nickName;



    public CamaraDialog(@NonNull Context context) {
        super(context);
        this.mContext=context;
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.setCanceledOnTouchOutside(false);
//        this.getWindow().setGravity(Gravity.BOTTOM);
        Window window = this.getWindow();
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attr = window.getAttributes();
            if (attr != null) {
                attr.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                attr.width = ViewGroup.LayoutParams.MATCH_PARENT;
                //设置dialog 在布局中的位置
//                attr.gravity = Gravity.BOTTOM;

                window.setAttributes(attr);
            }

        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.dailog_camara, null);
        view.findViewById(R.id.tv_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnBtnClickListener!=null){
                    mOnBtnClickListener.cancel();
                }

            }
        });
        view.findViewById(R.id.ll_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnBtnClickListener!=null){
                    mOnBtnClickListener.one();
                }

            }
        });
        view.findViewById(R.id.ll_camara).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnBtnClickListener!=null){
                    mOnBtnClickListener.two();
                }

            }
        });
        et_nickName = view.findViewById(R.id.et_nickName);
        setContentView(view);
    }


    @Override
    public void show() {
        if (!((Activity)mContext).isFinishing()){
            super.show();
        }
    }

    private OnBtnClickListener mOnBtnClickListener;

    public interface OnBtnClickListener{
        void cancel();
        void one();
        void two();

    }

    public void setOnBtnClickListener(OnBtnClickListener listener){
        this.mOnBtnClickListener=listener;
    }
}
