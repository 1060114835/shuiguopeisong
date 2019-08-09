package com.example.fruitdelivery.base;

import android.support.annotation.Nullable;

/**
 * M 层
 */
public class BaseModel<T> {

    //一般用于接口回掉
    @Nullable
    protected T mCallBack;

    public BaseModel() {
        this(null);
    }

    public BaseModel(@Nullable T callback) {
        this.mCallBack = callback;
    }

    public void detachView() { }
}
