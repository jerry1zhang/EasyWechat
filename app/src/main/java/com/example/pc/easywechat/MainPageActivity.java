package com.example.pc.easywechat;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainPageActivity extends AppCompatActivity implements OnClickListener,OnPageChangeListener {

    private LinearLayout ll_take;
    private LinearLayout ll_link;
    private LinearLayout ll_set;

    private ImageView iv_take;
    private ImageView iv_link;
    private ImageView iv_set;

    private TextView tv_take;
    private TextView tv_link;
    private TextView tv_set;

    private ViewPager viewPager;

    private ContentAdapter adapter;

    private List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);

        initView();

        initEvent();

    }

    private void initView(){
        this.ll_take = (LinearLayout) findViewById(R.id.ll_take);
        this.ll_link = (LinearLayout) findViewById(R.id.ll_link);
        this.ll_set = (LinearLayout) findViewById(R.id.ll_set);

        this.iv_take = (ImageView) findViewById(R.id.iv_take);
        this.iv_link = (ImageView) findViewById(R.id.iv_link);
        this.iv_set = (ImageView) findViewById(R.id.iv_set);

        this.tv_take = (TextView) findViewById(R.id.tv_take);
        this.tv_link = (TextView) findViewById(R.id.tv_link);
        this.tv_set = (TextView) findViewById(R.id.tv_set);

        this.viewPager = (ViewPager) findViewById(R.id.vp_content);
        View take = View.inflate(MainPageActivity.this, R.layout.take_page_layout, null);
        View link = View.inflate(MainPageActivity.this, R.layout.link_page_layout, null);
        View set = View.inflate(MainPageActivity.this, R.layout.set_page_layout, null);

        views = new ArrayList<View>();
        views.add(take);
        views.add(link);
        views.add(set);

        this.adapter = new ContentAdapter(views);
        viewPager.setAdapter(adapter);

    }

    private void initEvent(){}

    @Override
    public void onClick(View v) {
        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_take:
                iv_take.setImageResource(R.drawable.bg_alibuybutton_default);
                tv_take.setTextColor(0xFFEC7600);
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_link:
                iv_link.setImageResource(R.drawable.bg_alibuybutton_default);
                tv_link.setTextColor(0xFFEC7600);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_set:
                iv_set.setImageResource(R.drawable.bg_alibuybutton_default);
                tv_set.setTextColor(0xFFEC7600);
                viewPager.setCurrentItem(2);
                break;
            default:
                break;
        }

    }

    private void restartBotton() {
        // ImageView置为灰色
        iv_take.setImageResource(R.drawable.bg_alibuybutton_write);
        iv_link.setImageResource(R.drawable.bg_alibuybutton_write);
        iv_set.setImageResource(R.drawable.bg_alibuybutton_write);
        // TextView置为白色
        tv_take.setTextColor(0xffffffff);
        tv_link.setTextColor(0xffffffff);
        tv_set.setTextColor(0xffffffff);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        restartBotton();
        //当前view被选择的时候,改变底部菜单图片，文字颜色
        switch (arg0) {
            case 0:
                iv_take.setImageResource(R.drawable.bg_alibuybutton_default);
                tv_take.setTextColor(0xFFEC7600);
                break;
            case 1:
                iv_link.setImageResource(R.drawable.bg_alibuybutton_default);
                tv_link.setTextColor(0xFFEC7600);
                break;
            case 2:
                iv_set.setImageResource(R.drawable.bg_alibuybutton_default);
                tv_set.setTextColor(0xFFEC7600);
                break;

            default:
                break;
        }

    }


}
