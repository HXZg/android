package com.micropole.homemodule.entity;

/**
 * @ClassName OrderListBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/24 15:47
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class OrderListBean {

    /**
     * h_title : 泰丰牧马湖
     * h_imgs : /uploads/20181019/c5dd77ec51a3eb0f488bade2e19fac41.jpg
     * or_id : 5
     * start_time : 10月02日
     * end_time : 10月04日
     * real_price :
     * or_stat : 1
     * few_nights : 2
     * or_stat_detail : 待确认
     */

    private String h_title;
    private String h_imgs;
    private String or_id;
    private String start_time;
    private String end_time;
    private String real_price;
    private String or_stat;
    private String few_nights;
    private String or_stat_detail;

    public String getH_title() {
        return h_title;
    }

    public void setH_title(String h_title) {
        this.h_title = h_title;
    }

    public String getH_imgs() {
        return h_imgs;
    }

    public void setH_imgs(String h_imgs) {
        this.h_imgs = h_imgs;
    }

    public String getOr_id() {
        return or_id;
    }

    public void setOr_id(String or_id) {
        this.or_id = or_id;
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

    public String getOr_stat() {
        return or_stat;
    }

    public void setOr_stat(String or_stat) {
        this.or_stat = or_stat;
    }

    public String getFew_nights() {
        return few_nights;
    }

    public void setFew_nights(String few_nights) {
        this.few_nights = few_nights;
    }

    public String getOr_stat_detail() {
        return or_stat_detail;
    }

    public void setOr_stat_detail(String or_stat_detail) {
        this.or_stat_detail = or_stat_detail;
    }
}
