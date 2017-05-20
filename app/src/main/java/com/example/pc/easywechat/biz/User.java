package com.example.pc.easywechat.biz;


import android.os.Message;

import com.example.pc.easywechat.config.AppConfig;
import com.example.pc.easywechat.pojo.LoginBack;
import com.example.pc.easywechat.util.HttpCheckUtil;
import com.google.gson.Gson;


import java.util.HashMap;

/**
 * Created by Zhhy on 2017/5/20.
 */

public class User {
    public static LoginBack login(Message msg){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("username",msg.getData().get("username").toString());
        hashMap.put("password",msg.getData().get("password").toString());
        LoginBack loginBack = new LoginBack();
        String info = "";
        info = HttpCheckUtil.sendPost(AppConfig.url+"/FHM/appuser/useroff.do",hashMap,"uid");
        loginBack = new Gson().fromJson(info,LoginBack.class);
        return null;
    }
}
