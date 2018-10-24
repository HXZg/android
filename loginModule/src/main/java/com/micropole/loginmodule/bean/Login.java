package com.micropole.loginmodule.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/10/24
 * describe:
 */
public class Login {

    /**
     * long_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJsb25nX3Rva2VuIiwiYXVkIjoxLCJpYXQiOjE1NDAyNzYxNDksIm5iZiI6MTU0MDI3NjE0OSwiZXhwIjoxNTQwODgwOTQ5LCJpZCI6MX0.TgPaGmg4GR07Ypk1pMEOtzZf0ykUchoSYsp3RfrX1pY
     * short_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzaG9ydF90b2tlbiIsImF1ZCI6MSwiaWF0IjoxNTQwMjc2MTQ5LCJuYmYiOjE1NDAyNzYxNDksImV4cCI6MTU0MDI5MDU0OSwiaWQiOjF9.ywkqFK6Ie6NIdsf3-g-TULRO5t8chW2pEhl2djQ4PZc
     */

    private String long_token;
    private String short_token;

    public String getLong_token() {
        return long_token;
    }

    public void setLong_token(String long_token) {
        this.long_token = long_token;
    }

    public String getShort_token() {
        return short_token;
    }

    public void setShort_token(String short_token) {
        this.short_token = short_token;
    }
}
