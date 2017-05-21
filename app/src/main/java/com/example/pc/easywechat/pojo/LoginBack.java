package com.example.pc.easywechat.pojo;

/**
 * Created by Zhhy on 2017/5/20.
 */

public class LoginBack extends BaseBack{
    private Userdata Userdata;
    private Newtakedata[] Newtakedata;

    public Userdata getUserdata() {
        return Userdata;
    }

    public void setUserdata(Userdata Userdata) {
        this.Userdata = Userdata;
    }

    public Newtakedata[] getNewtakedata() {
        return Newtakedata;
    }

    public void setNewtakedata(Newtakedata[] Newtakedata) {
        this.Newtakedata = Newtakedata;
    }
}
