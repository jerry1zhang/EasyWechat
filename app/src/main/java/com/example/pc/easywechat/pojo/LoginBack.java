package com.example.pc.easywechat.pojo;

/**
 * Created by Zhhy on 2017/5/20.
 */

public class LoginBack extends BaseBack{
    private userdate userdate;
    private newtakedata[] newtakedata;

    public com.example.pc.easywechat.pojo.userdate getUserdate() {
        return userdate;
    }

    public void setUserdate(com.example.pc.easywechat.pojo.userdate userdate) {
        this.userdate = userdate;
    }

    public com.example.pc.easywechat.pojo.newtakedata[] getNewtakedata() {
        return newtakedata;
    }

    public void setNewtakedata(com.example.pc.easywechat.pojo.newtakedata[] newtakedata) {
        this.newtakedata = newtakedata;
    }
}
