package com.example.pc.easywechat.pojo;

/**
 * Created by Zhhy on 2017/5/20.
 */

public class LoginPost extends BasePost{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
