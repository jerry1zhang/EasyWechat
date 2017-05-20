package com.example.pc.easywechat;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.easywechat.biz.User;
import com.example.pc.easywechat.pojo.LoginBack;

public class MainActivity extends AppCompatActivity {
    private int paduan = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_start_layout);

    }

    public void onClick(View v){
        int id = v.getId();
        if (id==R.id.login){
//            new Thread(login).start();
            //TODO 测试
            paduan = 1;
            if (paduan == 0){
                Looper.prepare();
                Toast.makeText(MainActivity.this, "未连接网络", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
            else {
                Intent intent = new Intent(this,MainPageActivity.class);
                startActivity(intent);
            }

        }else if(id==R.id.register){
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }



    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            Bundle data = msg.getData();
//            String val = data.getString("value");

            Log.i("result_info","请求结果:" + msg);
        }
    };
    Runnable login = new Runnable(){
        @Override
        public void run() {
            EditText username = (EditText)findViewById(R.id.usernameval);
            EditText password = (EditText)findViewById(R.id.passwordval);
            Message msg = new Message();
            Bundle data = new Bundle();
            msg.setData(data);
            data.putString("username",username.getText().toString());
            data.putString("password",password.getText().toString());
            LoginBack loginBack = User.login(msg);
            if (loginBack.getResult_code()!=0) {
                Looper.prepare();
                Toast.makeText(MainActivity.this, loginBack.getResult_message(), Toast.LENGTH_SHORT).show();
                Looper.loop();
            }else {
                paduan = 1;
            }
            msg.setData(data);
            handler.sendMessage(msg);
        }
    };

}
