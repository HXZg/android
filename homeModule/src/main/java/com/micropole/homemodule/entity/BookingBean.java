package com.micropole.homemodule.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName BookingBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/25 15:43
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class BookingBean implements Serializable {


    /**
     * h_id : 6
     * h_title : 泰丰牧马湖
     * h_address : 大亚湾大道与龙海二路交汇处
     * lat_long : 114.48637,22.754869
     * comment_num : 2
     * comment_score : 5
     * property : <p>大亚湾大道与龙海二路交汇处</p>
     * facility_services : 33,34
     * check_in_time : 入住日14:00后
     * check_out_time : 离店日12:00后
     * cancel_rules : 需在入住前1天12:00前取消订单
     * additional_price : 50
     * additional_tip : 每1位增加1000元，最多可接待2人
     * other_price : ["\u6e05\u6d01\u8d39,50"]
     * hotel_user_id : 1
     * wishes : 哈哈哈
     * h_price : 100
     * add_time : 1539920206
     * h_recommend : 1
     * h_imgs : /uploads/20181019/c5dd77ec51a3eb0f488bade2e19fac41.jpg
     * h_stat : 1
     * admin_audit : 1
     * area_id : 2
     * max_people : 2
     * room_hall : 一房一厅
     * deposit_free : 1
     * reception_time : 00:00-24:00
     * cash_pledge : 27
     * other_price_arr : [["清洁费",50],["押金","27"]]
     * or_hotel_price : 100.00
     * or_all_price : 0
     * or_additional_price : 50.00
     * or_balance_arr : {"use_balance_pay":"1","balance_price":"","have":"1"}
     */

    private String h_id;
    private String h_title;
    private String h_address;
    private String lat_long;
    private String comment_num;
    private String comment_score;
    private String property;
    private String facility_services;
    private String check_in_time;
    private String check_out_time;
    private String cancel_rules;
    private String additional_price;
    private String additional_tip;
    private String other_price;
    private String hotel_user_id;
    private String wishes;
    private String h_price;
    private String add_time;
    private String h_recommend;
    private String h_imgs;
    private String h_stat;
    private String admin_audit;
    private String area_id;
    private String max_people;
    private String room_hall;
    private String deposit_free;
    private String reception_time;
    private String cash_pledge;
    private String or_hotel_price;
    private String or_all_price;
    private String or_additional_price;
    private OrBalanceArrBean or_balance_arr;
    private List<List<String>> other_price_arr;

    public String getH_id() {
        return h_id;
    }

    public void setH_id(String h_id) {
        this.h_id = h_id;
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

    public String getLat_long() {
        return lat_long;
    }

    public void setLat_long(String lat_long) {
        this.lat_long = lat_long;
    }

    public String getComment_num() {
        return comment_num;
    }

    public void setComment_num(String comment_num) {
        this.comment_num = comment_num;
    }

    public String getComment_score() {
        return comment_score;
    }

    public void setComment_score(String comment_score) {
        this.comment_score = comment_score;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getFacility_services() {
        return facility_services;
    }

    public void setFacility_services(String facility_services) {
        this.facility_services = facility_services;
    }

    public String getCheck_in_time() {
        return check_in_time;
    }

    public void setCheck_in_time(String check_in_time) {
        this.check_in_time = check_in_time;
    }

    public String getCheck_out_time() {
        return check_out_time;
    }

    public void setCheck_out_time(String check_out_time) {
        this.check_out_time = check_out_time;
    }

    public String getCancel_rules() {
        return cancel_rules;
    }

    public void setCancel_rules(String cancel_rules) {
        this.cancel_rules = cancel_rules;
    }

    public String getAdditional_price() {
        return additional_price;
    }

    public void setAdditional_price(String additional_price) {
        this.additional_price = additional_price;
    }

    public String getAdditional_tip() {
        return additional_tip;
    }

    public void setAdditional_tip(String additional_tip) {
        this.additional_tip = additional_tip;
    }

    public String getOther_price() {
        return other_price;
    }

    public void setOther_price(String other_price) {
        this.other_price = other_price;
    }

    public String getHotel_user_id() {
        return hotel_user_id;
    }

    public void setHotel_user_id(String hotel_user_id) {
        this.hotel_user_id = hotel_user_id;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public String getH_price() {
        return h_price;
    }

    public void setH_price(String h_price) {
        this.h_price = h_price;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getH_recommend() {
        return h_recommend;
    }

    public void setH_recommend(String h_recommend) {
        this.h_recommend = h_recommend;
    }

    public String getH_imgs() {
        return h_imgs;
    }

    public void setH_imgs(String h_imgs) {
        this.h_imgs = h_imgs;
    }

    public String getH_stat() {
        return h_stat;
    }

    public void setH_stat(String h_stat) {
        this.h_stat = h_stat;
    }

    public String getAdmin_audit() {
        return admin_audit;
    }

    public void setAdmin_audit(String admin_audit) {
        this.admin_audit = admin_audit;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getMax_people() {
        return max_people;
    }

    public void setMax_people(String max_people) {
        this.max_people = max_people;
    }

    public String getRoom_hall() {
        return room_hall;
    }

    public void setRoom_hall(String room_hall) {
        this.room_hall = room_hall;
    }

    public String getDeposit_free() {
        return deposit_free;
    }

    public void setDeposit_free(String deposit_free) {
        this.deposit_free = deposit_free;
    }

    public String getReception_time() {
        return reception_time;
    }

    public void setReception_time(String reception_time) {
        this.reception_time = reception_time;
    }

    public String getCash_pledge() {
        return cash_pledge;
    }

    public void setCash_pledge(String cash_pledge) {
        this.cash_pledge = cash_pledge;
    }

    public String getOr_hotel_price() {
        return or_hotel_price;
    }

    public void setOr_hotel_price(String or_hotel_price) {
        this.or_hotel_price = or_hotel_price;
    }

    public String getOr_all_price() {
        return or_all_price;
    }

    public void setOr_all_price(String or_all_price) {
        this.or_all_price = or_all_price;
    }

    public String getOr_additional_price() {
        return or_additional_price;
    }

    public void setOr_additional_price(String or_additional_price) {
        this.or_additional_price = or_additional_price;
    }

    public OrBalanceArrBean getOr_balance_arr() {
        return or_balance_arr;
    }

    public void setOr_balance_arr(OrBalanceArrBean or_balance_arr) {
        this.or_balance_arr = or_balance_arr;
    }

    public List<List<String>> getOther_price_arr() {
        return other_price_arr;
    }

    public void setOther_price_arr(List<List<String>> other_price_arr) {
        this.other_price_arr = other_price_arr;
    }

    public static class OrBalanceArrBean {
        /**
         * use_balance_pay : 1
         * balance_price :
         * have : 1
         */

        private String use_balance_pay;
        private String balance_price;
        private String have;

        public String getUse_balance_pay() {
            return use_balance_pay;
        }

        public void setUse_balance_pay(String use_balance_pay) {
            this.use_balance_pay = use_balance_pay;
        }

        public String getBalance_price() {
            return balance_price;
        }

        public void setBalance_price(String balance_price) {
            this.balance_price = balance_price;
        }

        public String getHave() {
            return have;
        }

        public void setHave(String have) {
            this.have = have;
        }
    }
}