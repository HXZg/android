package com.micropole.homeword.wxapi;

import android.util.Log;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.umeng.socialize.weixin.view.WXCallbackActivity;

/**
 * WXEntryActivity
 * 沉迷学习不能自拔
 * Describe：
 * Created by 雷小星🍀 on 2018/3/7 10:32.
 */

public class WXEntryActivity extends WXCallbackActivity {

    @Override
    public void onResp(BaseResp resp) {
        super.onResp(resp);
        Log.i("wx_tag",resp.errCode+"");
    }
}
