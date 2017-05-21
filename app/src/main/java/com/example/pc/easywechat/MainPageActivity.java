package com.example.pc.easywechat;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.pc.easywechat.biz.User;
import com.example.pc.easywechat.pojo.LoginBack;
import com.example.pc.easywechat.pojo.Newtakedata;

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

        iv_take.setImageResource(R.mipmap.pic_take_choose);
        tv_take.setTextColor(0xFFEC7600);

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
        //动态生成页面
        TableLayout take = new TableLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        take.setOrientation(TableLayout.VERTICAL);
        take.setLayoutParams(params);

        LoginBack loginBack = User.TestDate();
        Newtakedata[] newtakedatas = loginBack.getNewtakedata();
        Newtakedata newtakedata;

        LinearLayout row;
        take.setOrientation(LinearLayout.HORIZONTAL);

        ImageView imageView;
        ViewGroup.MarginLayoutParams margin;
        RelativeLayout.LayoutParams layoutParams;

        TextView name;
        TextView text;
        TextView time;
        for (int i=0;i<newtakedatas.length;i++){
            row = new LinearLayout(this);
            newtakedata = newtakedatas[i];
            imageView  = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setImageResource(R.drawable.timg);
            margin = new ViewGroup.MarginLayoutParams(imageView.getLayoutParams());
            margin.setMargins(100, 10+100*i, 0, 0);//在左边距400像素，顶边距10像素的位置显示图片
            layoutParams = new RelativeLayout.LayoutParams(margin);
            layoutParams.height = 100;//设置图片的高度
            layoutParams.width = 100; //设置图片的宽度
            imageView.setLayoutParams(layoutParams);
            row.addView(imageView);

            name = new TextView(this);
            name.setLayoutParams(params);
            name.setText(newtakedata.getTouidnickname());
            margin = new ViewGroup.MarginLayoutParams(name.getLayoutParams());
            margin.setMargins(70, 10+100*i, 0, 0);//在左边距400像素，顶边距10像素的位置显示图片
            layoutParams = new RelativeLayout.LayoutParams(margin);
            layoutParams.height = 100;//设置图片的高度
            layoutParams.width = 100; //设置图片的宽度
            name.setLayoutParams(layoutParams);
            row.addView(name);

            text = new TextView(this);
            text.setLayoutParams(params);
            text.setText(newtakedata.getTouid());
            margin = new ViewGroup.MarginLayoutParams(text.getLayoutParams());
            margin.setMargins(170, 10+100*i, 0, 0);//在左边距400像素，顶边距10像素的位置显示图片
            layoutParams = new RelativeLayout.LayoutParams(margin);
            layoutParams.height = 100;//设置图片的高度
            layoutParams.width = 300; //设置图片的宽度
            text.setLayoutParams(layoutParams);
            row.addView(text);

//            row.setBackgroundResource(R.mipmap.row_backg);
            take.addView(row);
        }
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

        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_take:
                restartBotton();
                iv_take.setImageResource(R.mipmap.pic_take_choose);
                tv_take.setTextColor(0xFFEC7600);
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_link:
                restartBotton();
                iv_link.setImageResource(R.mipmap.pic_link_choose);
                tv_link.setTextColor(0xFFEC7600);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_set:
                restartBotton();
                iv_set.setImageResource(R.mipmap.pic_setting_choose);
                tv_set.setTextColor(0xFFEC7600);
                viewPager.setCurrentItem(2);
                break;
            default:
                break;
        }

    }

    private void restartBotton() {
        // ImageView置为灰色
        iv_take.setImageResource(R.mipmap.pic_take);
        iv_link.setImageResource(R.mipmap.pic_link);
        iv_set.setImageResource(R.mipmap.pic_setting);
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
