package com.example.pc.easywechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_start_layout);


    }

    public void onClick(View v){
        int id = v.getId();
        if (id==R.id.login){

        }else if(id==R.id.register){
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}
