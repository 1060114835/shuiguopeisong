package com.example.fruitdelivery.base;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fruitdelivery.R;

/**
 * 带返回标题栏的 V 层
 */
public abstract class BaseActivityWithToolbar<P extends BasePresenter> extends BaseActivity<P> {

    protected TextView tvTitle;

    protected ImageView ivBack;

    protected FrameLayout mFrameToolbar;

    @Override
    protected void inflateBaseView() {
        initToolBar();
        mBaseContentView.addView(mStatusBar);
        mBaseContentView.addView(mFrameToolbar);
        mBaseContentView.addView(mContentView);
    }

    protected void initToolBar() {
        mFrameToolbar = (FrameLayout) LayoutInflater.from(this).inflate(R.layout.base_toolbar,
                mBaseContentView, false);
        tvTitle = mFrameToolbar.findViewById(R.id.tv_base_title);
        ivBack = mFrameToolbar.findViewById(R.id.iv_base_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void onBackClick() {
        finish();
    }

    public void setTitle(String text) {
        tvTitle.setText(text);
    }

    public FrameLayout getToolBar() {
        return mFrameToolbar;
    }

    public ImageView getBackImagView() {
        return ivBack;
    }

    public TextView getTitleView() {
        return tvTitle;
    }
}
