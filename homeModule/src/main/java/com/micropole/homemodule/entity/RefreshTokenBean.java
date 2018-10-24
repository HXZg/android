package com.micropole.homemodule.entity;

/**
 * @ClassName RefreshTokenBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/24 9:36
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class RefreshTokenBean {


    /**
     * short_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzaG9ydF90b2tlbiIsImF1ZCI6bnVsbCwiaWF0IjoxNTQwMzQ1MDcwLCJuYmYiOjE1NDAzNDUwNzAsImV4cCI6MTU0MDM1OTQ3MCwiaWQiOm51bGx9.qyul0c5GVs40RUMU0R95l5Tlr1UQAywbYPFIaKIEoF0
     */

    private String short_token;

    public String getShort_token() {
        return short_token;
    }

    public void setShort_token(String short_token) {
        this.short_token = short_token;
    }
}
