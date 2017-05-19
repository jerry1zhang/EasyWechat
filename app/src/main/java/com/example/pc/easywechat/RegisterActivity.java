package com.example.pc.easywechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by Zhhy on 2017/5/19.
 */

public class RegisterActivity extends AppCompatActivity {

    private int protocolstatus = 0;
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main_layout);

        cb = (CheckBox)findViewById(R.id.checkBox);

        if (protocolstatus==1)
            cb.setChecked(true);

    }



    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
        if (protocolstatus==1)
            cb.setChecked(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle bundle = this.getIntent().getExtras()==null? new Bundle():this.getIntent().getExtras();
        String status = bundle.getString("status")==null?"0":"1";
        if (status.equals(1))
            protocolstatus = 1;


        if (protocolstatus==1)
            cb.setChecked(true);

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop");

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (protocolstatus==1)
            cb.setChecked(true);

    }

    public void onClick(View v){
        int id = v.getId();
        if(id==R.id.register){
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        }else if (id==R.id.protocolview){
            Intent intent = new Intent(this,ProtocolViewActivity.class);
            startActivity(intent);
        }
    }
}
