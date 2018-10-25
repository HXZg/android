package com.micropole.minemodule.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
public class Trip {

    /**
     * in_id : 33
     * in_title : 您推荐用户成功注册，奖励1000基金
     * in_type : 1
     * user_id : 1
     * add_time : 1970-01-01 08:00:00
     * in_number : 1000
     */

    private String in_id;
    private String in_title;
    private String in_type;
    private String user_id;
    private String add_time;
    private String in_number;

    public String getIn_id() {
        return in_id;
    }

    public void setIn_id(String in_id) {
        this.in_id = in_id;
    }

    public String getIn_title() {
        return in_title;
    }

    public void setIn_title(String in_title) {
        this.in_title = in_title;
    }

    public String getIn_type() {
        return in_type;
    }

    public void setIn_type(String in_type) {
        this.in_type = in_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getIn_number() {
        return in_number;
    }

    public void setIn_number(String in_number) {
        this.in_number = in_number;
    }
}
