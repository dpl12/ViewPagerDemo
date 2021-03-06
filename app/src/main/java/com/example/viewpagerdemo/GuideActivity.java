package com.example.viewpagerdemo;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

//点随着view的改变而改变，需要实现改变的监听方法，重写ViewPager.OnPageChangeListener
public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private List<View> views;//声明view集合
    private ImageView[] dots;//声明图像点的集合
    private int[] ids={R.id.iv1,R.id.iv2,R.id.iv3};//获取点id的集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initViews();
        initDots();
    }

    private void initViews() {//初始化view
        LayoutInflater inflater=LayoutInflater.from(this);
        views=new ArrayList<>();
        views.add(inflater.inflate(R.layout.one_view,null));
        views.add(inflater.inflate(R.layout.two_view,null));
        views.add(inflater.inflate(R.layout.three_view,null));
        adapter=new ViewPagerAdapter(views,this);
        viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);//viewPager实现监听
        //第三个页面获取id
        views.get(2).findViewById(R.id.btn_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_main2=new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent_main2);
            }
        });
    }
    private void initDots(){  //初始化点
        dots=new ImageView[views.size()];//实例化对象
        for (int i=0;i<views.size();i++){
            dots[i]=findViewById(ids[i]);//获取id
        }
    }

    //页面被选中时调用
    @Override
    public void onPageSelected(int i) {
        for (int j=0;j<ids.length;j++){
            if (i==j){
                dots[j].setImageResource(R.drawable.login_point_selected);
            }else {
                dots[j].setImageResource(R.drawable.login_point);
            }
        }
    }

    //页面滑动时调用
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }
    //页面滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
