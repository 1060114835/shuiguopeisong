package com.example.fruitdelivery.modules.home.shell;

import android.os.Bundle;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseActivity;
import com.example.fruitdelivery.base.BaseActivityWithToolbar;

/**
 * 壳活动，应该包含 我的、订单、首页 三个碎片
 */
public class ShellActivity extends BaseActivityWithToolbar<ShellPresenter> implements IShellView {

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_shell;
    }

    @Override
    protected ShellPresenter createPresenter() {
        return new ShellPresenter();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }
}
