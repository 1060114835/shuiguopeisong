package com.example.fruitdelivery.modules.home.self;

import android.view.ViewStub;

public class BoolDataBack {
    //NO_ORDER代表未接收到参数，GET_ORDER代表接收到参数
    private static int NO_ORDER = 0;
    private static int GET_ORDER = 1;

    private ViewStub mViewStub;
    private int mBackInt;
    public BoolDataBack(int backInt,ViewStub viewStub){

        this.mBackInt = backInt;
        this.mViewStub = viewStub;
    }

    public void showStub(){
        if (mBackInt == NO_ORDER && mViewStub != null){
            mViewStub.inflate();
        }else if (mBackInt == GET_ORDER && mViewStub != null){
            return;
        }
    }
}
