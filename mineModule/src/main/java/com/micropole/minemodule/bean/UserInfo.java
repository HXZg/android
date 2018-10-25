package com.micropole.minemodule.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
public class UserInfo {

    /**
     * user : {"user_phone":"13682873453","nickname":"小李飞刀","user_img":"/uploads/image/20180719/20180719005398.png","balance":"0.00","user_sex":"2","gr_id":"1"}
     */

    private UserBean user;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * user_phone : 13682873453
         * nickname : 小李飞刀
         * user_img : /uploads/image/20180719/20180719005398.png
         * balance : 0.00
         * user_sex : 2
         * gr_id : 1
         */

        private String user_phone;
        private String nickname;
        private String user_img;
        private String balance;
        private String user_sex;
        private String gr_id;

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

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

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getUser_sex() {
            return user_sex;
        }

        public void setUser_sex(String user_sex) {
            this.user_sex = user_sex;
        }

        public String getGr_id() {
            return gr_id;
        }

        public void setGr_id(String gr_id) {
            this.gr_id = gr_id;
        }
    }
}
