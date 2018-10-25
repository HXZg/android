package com.micropole.homemodule.entity;

/**
 * @ClassName NewsBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/25 13:37
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class NewsBean {


    /**
     * new_id : 1
     * user_id : 1
     * new_text : 上架成功
     * add_time :
     */

    private String new_id;
    private String user_id;
    private String new_text;
    private String add_time;

    public String getNew_id() {
        return new_id;
    }

    public void setNew_id(String new_id) {
        this.new_id = new_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNew_text() {
        return new_text;
    }

    public void setNew_text(String new_text) {
        this.new_text = new_text;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}
