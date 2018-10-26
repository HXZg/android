package com.micropole.homeword.entity;

/**
 * @ClassName PayBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/26 16:59
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class PayBean {


    /**
     * data : {"return_code":"SUCCESS","return_msg":"OK","appid":"","mch_id":"","nonce_str":"","sign":"alipay_sdk=alipay-sdk-php-20161101&app_id=2018032602450457&biz_content=%7B%22timeout_express%22%3A%2230m%22%2C%22seller_id%22%3A%22%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22total_amount%22%3A327%2C%22subject%22%3A%22%5Cu5bb6%5Cu5929%5Cu4e0b%22%2C%22body%22%3A%22%5Cu5bb6%5Cu5929%5Cu4e0b%22%2C%22out_trade_no%22%3A%2220181026253660%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fjiatianxia.goodbooy.cn%2Fapi%2FUserorderpay%2Falipay_pay_success%2F&sign_type=RSA2&timestamp=2018-10-26+17%3A01%3A20&version=1.0&sign=FkmnNLE0hy0sGarjyfk%2Bmxk%2F4dqCIKquKFsDoMxpaGWBTfimYR9nY4%2Fu2VdoSGnmXtjuAilXtp40bpB5sLrDPPPuDfxuCH%2Bwh85AtP708d58l5ojn5cHGpBtzPmNx38UF9aUuZpKR5K6%2FrfIwX9QP163rnPby6HOJfzpda4bUU%2BKdiYq6uL3XRzj%2B4ZA1RbbgDaTlPn%2FYsdO0K0hmwuoqT%2B9x29O1ctdjQo08hNviks7xkw9Iohl8iPVFHHBnghSM%2BM0SlrJZyte6fTYhLhS7Z5p6jp0qrOjdkzuNAsLxUF%2FtrIGoDL1JBatkOFEKWJQlBjwCRFh4WldLWvGy3Nyyg%3D%3D","result_code":"SUCCESS","prepay_id":"","trade_type":"APP","time":1540544480}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * return_code : SUCCESS
         * return_msg : OK
         * appid :
         * mch_id :
         * nonce_str :
         * sign : alipay_sdk=alipay-sdk-php-20161101&app_id=2018032602450457&biz_content=%7B%22timeout_express%22%3A%2230m%22%2C%22seller_id%22%3A%22%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22total_amount%22%3A327%2C%22subject%22%3A%22%5Cu5bb6%5Cu5929%5Cu4e0b%22%2C%22body%22%3A%22%5Cu5bb6%5Cu5929%5Cu4e0b%22%2C%22out_trade_no%22%3A%2220181026253660%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fjiatianxia.goodbooy.cn%2Fapi%2FUserorderpay%2Falipay_pay_success%2F&sign_type=RSA2&timestamp=2018-10-26+17%3A01%3A20&version=1.0&sign=FkmnNLE0hy0sGarjyfk%2Bmxk%2F4dqCIKquKFsDoMxpaGWBTfimYR9nY4%2Fu2VdoSGnmXtjuAilXtp40bpB5sLrDPPPuDfxuCH%2Bwh85AtP708d58l5ojn5cHGpBtzPmNx38UF9aUuZpKR5K6%2FrfIwX9QP163rnPby6HOJfzpda4bUU%2BKdiYq6uL3XRzj%2B4ZA1RbbgDaTlPn%2FYsdO0K0hmwuoqT%2B9x29O1ctdjQo08hNviks7xkw9Iohl8iPVFHHBnghSM%2BM0SlrJZyte6fTYhLhS7Z5p6jp0qrOjdkzuNAsLxUF%2FtrIGoDL1JBatkOFEKWJQlBjwCRFh4WldLWvGy3Nyyg%3D%3D
         * result_code : SUCCESS
         * prepay_id :
         * trade_type : APP
         * time : 1540544480
         */

        private String return_code;
        private String return_msg;
        private String appid;
        private String mch_id;
        private String nonce_str;
        private String sign;
        private String result_code;
        private String prepay_id;
        private String trade_type;
        private int time;

        public String getReturn_code() {
            return return_code;
        }

        public void setReturn_code(String return_code) {
            this.return_code = return_code;
        }

        public String getReturn_msg() {
            return return_msg;
        }

        public void setReturn_msg(String return_msg) {
            this.return_msg = return_msg;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getMch_id() {
            return mch_id;
        }

        public void setMch_id(String mch_id) {
            this.mch_id = mch_id;
        }

        public String getNonce_str() {
            return nonce_str;
        }

        public void setNonce_str(String nonce_str) {
            this.nonce_str = nonce_str;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getResult_code() {
            return result_code;
        }

        public void setResult_code(String result_code) {
            this.result_code = result_code;
        }

        public String getPrepay_id() {
            return prepay_id;
        }

        public void setPrepay_id(String prepay_id) {
            this.prepay_id = prepay_id;
        }

        public String getTrade_type() {
            return trade_type;
        }

        public void setTrade_type(String trade_type) {
            this.trade_type = trade_type;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}
