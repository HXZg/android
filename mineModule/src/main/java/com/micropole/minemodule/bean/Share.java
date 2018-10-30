package com.micropole.minemodule.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/10/29
 * describe:
 */
public class Share {

    /**
     * user_phone : 13682873453
     * user_img : /uploads/20181024/1d54801d5c9f847451cf079baff38947.jpg
     * user_qrcode : /uploads/user_qrcode/18926146071.png
     * nickname : 小李飞刀
     * invite : 13682873453
     */

    private String user_phone;
    private String user_img;
    private String user_qrcode;
    private String nickname;
    private String invite;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getUser_qrcode() {
        return user_qrcode;
    }

    public void setUser_qrcode(String user_qrcode) {
        this.user_qrcode = user_qrcode;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getInvite() {
        return invite;
    }

    public void setInvite(String invite) {
        this.invite = invite;
    }
}
