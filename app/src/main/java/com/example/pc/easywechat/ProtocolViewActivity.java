package com.example.pc.easywechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Zhhy on 2017/5/19.
 */

public class ProtocolViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.protocol_layout);

    }

    public void onClick(View v){
        int id = v.getId();
        if(id==R.id.button){
            Intent intent = new Intent(this,RegisterActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("status", "1");
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
