package com.example.fruitdelivery.modules.home.shell;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseActivity;
import com.example.fruitdelivery.base.BaseActivityWithToolbar;
import com.example.fruitdelivery.modules.home.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 壳活动，应该包含 我的、订单、首页 三个碎片
 */
public class ShellActivity extends BaseActivityWithToolbar<ShellPresenter> implements IShellView {

    private static List<Fragment> fragmentList;

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

        fragmentList = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();

        fragmentList.add(homeFragment);

        ViewPager viewPager = findViewById(R.id.shell_view_pager);
        ShellAdapter shellAdapter = new ShellAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(shellAdapter);

        TabLayout tabLayout = findViewById(R.id.shell_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("首页").setIcon(R.drawable.shell_tab_homepage));
        tabLayout.addTab(tabLayout.newTab().setText("订单").setIcon(R.drawable.shell_tab_order));
        tabLayout.addTab(tabLayout.newTab().setText("我的").setIcon(R.drawable.shell_tab_mine));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

}
