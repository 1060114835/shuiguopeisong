package com.example.fruitdelivery.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.util.ScreenUtil;

/**
 * V 层
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity
        implements IView {

    protected P mPresenter;

    protected View mStatusBar;

    protected ViewGroup mBaseContentView;

    protected ViewGroup mContentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBaseContentView();
        setContentView(mBaseContentView);
        immersionStatusBar();
        initStatusBar();
        initContentView();
        inflateBaseView();


        mPresenter = createPresenter();
        if (mPresenter != null) mPresenter.attach(this);

        initView(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detach();
    }

    @Override
    public BaseActivity<P> getBActivity() {
        return this;
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public View getStatusBar() {
        return mStatusBar;
    }

    public ViewGroup getBaseContentView() {
        return mBaseContentView;
    }

    public ViewGroup getContentView() {
        return mContentView;
    }

    public void setStatusColor(int color) {
        if (mStatusBar != null) mStatusBar.setBackgroundColor(color);
    }

    protected void initStatusBar() {
        mStatusBar = new StatusBarView(this);
        ViewGroup.LayoutParams p = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtil.getStatusBarHeight());
        mStatusBar.setLayoutParams(p);
        mStatusBar.setBackgroundColor(getResources().getColor(R.color.colorBaseBackground));
    }

    protected void initContentView() {
        mContentView = (ViewGroup) LayoutInflater.from(this).inflate(getContentLayoutId(),
                (ViewGroup) getWindow().getDecorView(), false);
    }

    protected void initBaseContentView() {
        mBaseContentView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.activity_base,
                (ViewGroup) getWindow().getDecorView(), false);
    }

    protected void inflateBaseView() {
        mBaseContentView.addView(mStatusBar);
        mBaseContentView.addView(mContentView);
    }

    /**
     * 隐藏状态栏 沉浸式
     */
    protected void immersionStatusBar() {
        Window window = getWindow();
        View decorView = window.getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        //修改为light主体，字体变成深色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }
    }

    protected abstract int getContentLayoutId();

    protected abstract P createPresenter();

    protected abstract void initView(Bundle savedInstanceState);
}
