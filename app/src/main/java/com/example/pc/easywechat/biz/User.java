package com.example.pc.easywechat.biz;


import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.util.Log;

import com.example.pc.easywechat.R;
import com.example.pc.easywechat.config.AppConfig;
import com.example.pc.easywechat.pojo.*;
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
        return loginBack;
    }

    public static LoginBack TestDate(){
        LoginBack loginBack = new LoginBack();
        loginBack.setResult_code(0);
        loginBack.setResult_message("success");
        Newtakedata[] Newtakedatas = new Newtakedata[2];

        Newtakedata Newtakedata = new Newtakedata();
        Newtakedata.setNid("asdasd");
        Newtakedata.setLasttime("aasdsa");
        Newtakedata.setStatus(1);
        Newtakedata.setTouid("asdasdasdad");
        Newtakedata.setTouidnickname("asdasdasd");
        Newtakedata.setTouidpic_url(BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.timg));
        Newtakedata newtakedata1 = new Newtakedata();
        newtakedata1.setNid("asdasd");
        newtakedata1.setLasttime("aasdsa");
        newtakedata1.setStatus(1);
        newtakedata1.setTouid("asdasdasdad");
        newtakedata1.setTouidnickname("asdasdasd");
        newtakedata1.setTouidpic_url(BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.timg));
        Log.d("info", "TestDate: "+BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.timg));
        Newtakedatas[0] = Newtakedata;
        Newtakedatas[1] = newtakedata1;
        loginBack.setNewtakedata(Newtakedatas);
        Userdata Userdata = new Userdata();
        Userdata.setLasttime("123123");
        Userdata.setEmail("1221123");
        Userdata.setNickname("423432423");
        Userdata.setPhone("12312321312");
        Userdata.setPic_url(BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.timg));

        Userdata.setSex(1);
        Userdata.setSign("123123123");
        Userdata.setUsername("123123123");
        Userdata.setUid("23424234234");
        loginBack.setUserdata(Userdata);
        return loginBack;
    }
}
