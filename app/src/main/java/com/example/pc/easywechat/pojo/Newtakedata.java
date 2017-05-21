package com.example.pc.easywechat.pojo;

import android.graphics.Bitmap;

/**
 * Created by Zhhy on 2017/5/20.
 */

public class Newtakedata {
    private String nid;
    private String touid;
    private String touidnickname;
    private Bitmap touidpic_url;
    private String lasttime;
    private int status;

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getTouid() {
        return touid;
    }

    public void setTouid(String touid) {
        this.touid = touid;
    }

    public String getTouidnickname() {
        return touidnickname;
    }

    public void setTouidnickname(String touidnickname) {
        this.touidnickname = touidnickname;
    }

    public Bitmap getTouidpic_url() {
        return touidpic_url;
    }

    public void setTouidpic_url(Bitmap touidpic_url) {
        this.touidpic_url = touidpic_url;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
