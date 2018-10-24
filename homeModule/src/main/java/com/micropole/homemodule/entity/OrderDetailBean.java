package com.micropole.homemodule.entity;

import java.util.List;

/**
 * @ClassName OrderDetailBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/24 16:53
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class OrderDetailBean {


    /**
     * or_id : 7
     * user_id : 1
     * or_stat : 1
     * is_comment :
     * hotel_user_id : 1
     * h_id : 6
     * start_time : 2018年10月02日
     * end_time : 2018年10月04日
     * real_price :
     * people_number : 2
     * or_other_price : [["\u6e05\u6d01\u8d39",100],["\u623f\u8d39","200.00"],["\u62bc\u91d1",27],["\u989d\u5916\u623f\u5ba2\u8d39\u7528","100.00"]]
     * or_nickname : 小李飞刀
     * or_idcard : 440582199302131538
     * or_phone : 13682873453
     * add_time : 1540190543
     * or_number : 20181022458203
     * cash_pledge :
     * deposit_free :
     * pay_type :
     * pay_time :
     * pay_json :
     * balance_pay : 427
     * order_cancel :
     * or_other_price_arr : [["清洁费",100],["房费","200.00"],["押金",27],["额外房客费用","100.00"]]
     */

    private String or_id;
    private String user_id;
    private String or_stat;
    private String is_comment;
    private String hotel_user_id;
    private String h_id;
    private String start_time;
    private String end_time;
    private String real_price;
    private String people_number;
    private String or_other_price;
    private String or_nickname;
    private String or_idcard;
    private String or_phone;
    private String add_time;
    private String or_number;
    private String cash_pledge;
    private String deposit_free;
    private String pay_type;
    private String pay_time;
    private String pay_json;
    private String balance_pay;
    private String order_cancel;
    private List<List<String>> or_other_price_arr;
    /**
     * h_title : 泰丰牧马湖
     * h_address : 大亚湾大道与龙海二路交汇处
     * h_imgs : /uploads/20181019/c5dd77ec51a3eb0f488bade2e19fac41.jpg
     * or_other_price_arr : [["清洁费",100],["房费","200.00"],["押金",27],["额外房客费用","100.00"]]
     */

    private String h_title;
    private String h_address;
    private String h_imgs;
    /**
     * or_other_price_arr : [["清洁费",100],["房费","200.00"],["押金",27],["额外房客费用","100.00"]]
     * or_stat_detail : 待确认
     */

    private String or_stat_detail;

    public String getOr_id() {
        return or_id;
    }

    public void setOr_id(String or_id) {
        this.or_id = or_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOr_stat() {
        return or_stat;
    }

    public void setOr_stat(String or_stat) {
        this.or_stat = or_stat;
    }

    public String getIs_comment() {
        return is_comment;
    }

    public void setIs_comment(String is_comment) {
        this.is_comment = is_comment;
    }

    public String getHotel_user_id() {
        return hotel_user_id;
    }

    public void setHotel_user_id(String hotel_user_id) {
        this.hotel_user_id = hotel_user_id;
    }

    public String getH_id() {
        return h_id;
    }

    public void setH_id(String h_id) {
        this.h_id = h_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getReal_price() {
        return real_price;
    }

    public void setReal_price(String real_price) {
        this.real_price = real_price;
    }

    public String getPeople_number() {
        return people_number;
    }

    public void setPeople_number(String people_number) {
        this.people_number = people_number;
    }

    public String getOr_other_price() {
        return or_other_price;
    }

    public void setOr_other_price(String or_other_price) {
        this.or_other_price = or_other_price;
    }

    public String getOr_nickname() {
        return or_nickname;
    }

    public void setOr_nickname(String or_nickname) {
        this.or_nickname = or_nickname;
    }

    public String getOr_idcard() {
        return or_idcard;
    }

    public void setOr_idcard(String or_idcard) {
        this.or_idcard = or_idcard;
    }

    public String getOr_phone() {
        return or_phone;
    }

    public void setOr_phone(String or_phone) {
        this.or_phone = or_phone;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getOr_number() {
        return or_number;
    }

    public void setOr_number(String or_number) {
        this.or_number = or_number;
    }

    public String getCash_pledge() {
        return cash_pledge;
    }

    public void setCash_pledge(String cash_pledge) {
        this.cash_pledge = cash_pledge;
    }

    public String getDeposit_free() {
        return deposit_free;
    }

    public void setDeposit_free(String deposit_free) {
        this.deposit_free = deposit_free;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getPay_json() {
        return pay_json;
    }

    public void setPay_json(String pay_json) {
        this.pay_json = pay_json;
    }

    public String getBalance_pay() {
        return balance_pay;
    }

    public void setBalance_pay(String balance_pay) {
        this.balance_pay = balance_pay;
    }

    public String getOrder_cancel() {
        return order_cancel;
    }

    public void setOrder_cancel(String order_cancel) {
        this.order_cancel = order_cancel;
    }

    public List<List<String>> getOr_other_price_arr() {
        return or_other_price_arr;
    }

    public void setOr_other_price_arr(List<List<String>> or_other_price_arr) {
        this.or_other_price_arr = or_other_price_arr;
    }

    public String getH_title() {
        return h_title;
    }

    public void setH_title(String h_title) {
        this.h_title = h_title;
    }

    public String getH_address() {
        return h_address;
    }

    public void setH_address(String h_address) {
        this.h_address = h_address;
    }

    public String getH_imgs() {
        return h_imgs;
    }

    public void setH_imgs(String h_imgs) {
        this.h_imgs = h_imgs;
    }

    public String getOr_stat_detail() {
        return or_stat_detail;
    }

    public void setOr_stat_detail(String or_stat_detail) {
        this.or_stat_detail = or_stat_detail;
    }
}
