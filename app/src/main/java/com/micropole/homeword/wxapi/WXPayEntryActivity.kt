package com.micropole.homeword.wxapi

import com.xx.anypay.wxapi.WxPayEntryActivity


//
class WXPayEntryActivity :WxPayEntryActivity(){
//        Activity(), IWXAPIEventHandler {
//    private var api: IWXAPI? = null
//
//    override fun onResp(resp: BaseResp?) {
//        when(resp?.errCode){
//            0->{            Toast.makeText(this,"支付成功",Toast.LENGTH_SHORT).show()
//            }
//            -1->{
//                Toast.makeText(this,"支付失败",Toast.LENGTH_SHORT).show()
//
//            }
//            1->{            Toast.makeText(this,"支付取消",Toast.LENGTH_SHORT).show()
//            }
//        }
//
//    }
//
//    override fun onReq(p0: BaseReq?) {
//        Log.i("dfgsa","我是req")
////        App.getInstance()?.cleanListActivity()
////        finish(
//    }
//
//    override fun onNewIntent(intent: Intent?) {
//        super.onNewIntent(intent)
//        setIntent(intent)
//        api?.handleIntent(intent, this)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_main2)
//        api=WXAPIFactory.createWXAPI(this,"wx4fc9ff6e5c76f8bc")
//        api?.handleIntent(getIntent(), this)
//    }
}
