package com.example.fruitdelivery;

import android.app.Application;

import com.example.fruitdelivery.util.ScreenUtil;

/**
 * create by zuyuan on 2019/8/9
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ScreenUtil.initAttr(this);
    }
}
