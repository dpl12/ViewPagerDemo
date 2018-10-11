package com.example.viewpagerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ant.liao.GifView;

public class MainActivity extends AppCompatActivity {

    private GifView gifView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gifView = findViewById(R.id.gifView);
        gifView.setGifImage(R.drawable.girl);
        gifView.setShowDimension(getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight());
//        gifView.setGifImageType(GifView.GifImageType.WAIT_FINISH);
        //gifView.setGifImageType(GifView.GifImageType.COVER);
    }

}
