package com.micropole.minemodule.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/10/25
 * describe:
 */
public class RefreshTokenBean {

    /**
     * long_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIiLCJhdWQiOiIiLCJpYXQiOjE1NDAyMDE4NDAsIm5iZiI6MTU0MDIwMTg0MCwiZXhwIjoxNTQwODA2NjQwLCJpZCI6MX0.gIaErOh0F7ydvJtXTquDRFNSa-RME-oTEVT4_tHCFJM
     * short_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIiLCJhdWQiOiIiLCJpYXQiOjE1NDAyMDE4NDAsIm5iZiI6MTU0MDIwMTg0MCwiZXhwIjoxNTQwODA2NjQwLCJpZCI6MX0.gIaErOh0F7ydvJtXTquDRFNSa-RME-oTEVT4_tHCFJM
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
