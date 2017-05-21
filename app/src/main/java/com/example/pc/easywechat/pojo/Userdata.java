package com.example.pc.easywechat.pojo;

import android.graphics.Bitmap;

/**
 * Created by Zhhy on 2017/5/20.
 */

public class Userdata {
    private String uid;
    private String username;
    private String nickname;
    private int sex;
    private Bitmap pic_url;
    private String lasttime;
    private String phone;
    private String email;
    private String sign;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Bitmap getPic_url() {
        return pic_url;
    }

    public void setPic_url(Bitmap pic_url) {
        this.pic_url = pic_url;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
