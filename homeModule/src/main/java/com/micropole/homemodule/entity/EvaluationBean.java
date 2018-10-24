package com.micropole.homemodule.entity;

import java.util.List;

/**
 * @ClassName EvaluationBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/24 11:51
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class EvaluationBean {


    /**
     * com_id : 2
     * h_id : 6
     * comment_score : 5
     * com_content : 旅馆很好，吃得好睡的香
     * com_pic : ["/uploads/20181018/530026712cff6f9bb7143edea881d355.jpg","/uploads/20181018/75a7065f01dc13cc52d71485474e4020.jpg","/uploads/20181018/3befe80e295e44b27bb82bc6077c9a42.jpg"]
     * add_time : 2018.10.22 16:08
     */

    private String com_id;
    private String h_id;
    private String comment_score;
    private String com_content;
    private String add_time;
    private List<String> com_pic;
    /**
     * user_id : 1
     * user_arr : {"nickname":"小李飞刀","user_img":"/uploads/image/20180719/20180719005398.png"}
     */

    private String user_id;
    private UserArrBean user_arr;

    public String getCom_id() {
        return com_id;
    }

    public void setCom_id(String com_id) {
        this.com_id = com_id;
    }

    public String getH_id() {
        return h_id;
    }

    public void setH_id(String h_id) {
        this.h_id = h_id;
    }

    public String getComment_score() {
        return comment_score;
    }

    public void setComment_score(String comment_score) {
        this.comment_score = comment_score;
    }

    public String getCom_content() {
        return com_content;
    }

    public void setCom_content(String com_content) {
        this.com_content = com_content;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public List<String> getCom_pic() {
        return com_pic;
    }

    public void setCom_pic(List<String> com_pic) {
        this.com_pic = com_pic;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public UserArrBean getUser_arr() {
        return user_arr;
    }

    public void setUser_arr(UserArrBean user_arr) {
        this.user_arr = user_arr;
    }

    public static class UserArrBean {
        /**
         * nickname : 小李飞刀
         * user_img : /uploads/image/20180719/20180719005398.png
         */

        private String nickname;
        private String user_img;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUser_img() {
            return user_img;
        }

        public void setUser_img(String user_img) {
            this.user_img = user_img;
        }
    }
}
