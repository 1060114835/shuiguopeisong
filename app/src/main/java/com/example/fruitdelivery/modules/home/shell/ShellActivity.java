package com.example.fruitdelivery.modules.home.shell;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseActivity;
import com.example.fruitdelivery.base.BaseActivityWithToolbar;
import com.example.fruitdelivery.modules.home.home.HomeFragment;
import com.example.fruitdelivery.modules.home.order.main_fragment.OrderFragment;
import com.example.fruitdelivery.modules.home.self.MyFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 壳活动，应该包含 我的、订单、首页 三个碎片
 */
public class ShellActivity extends BaseActivityWithToolbar<ShellPresenter> implements IShellView {

    ViewPager viewPager;
    TabLayout tabLayout;

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

        viewPager = findViewById(R.id.shell_view_pager);
        viewPager.setOffscreenPageLimit(0);
        tabLayout = findViewById(R.id.shell_tab_layout);
        List<Fragment> fragmentList = new ArrayList<>();
        final List<String> tabTitleList = new ArrayList<>();
        List<Integer> tabIconList = new ArrayList<>();

        fragmentList.add(new OrderFragment());
        fragmentList.add(new HomeFragment());
        fragmentList.add(new MyFragment());
        tabTitleList.add("订单");
        tabTitleList.add("首页");
        tabTitleList.add("我的");
        tabIconList.add(R.drawable.shell_tab_order);
        tabIconList.add(R.drawable.shell_tab_homepage);
        tabIconList.add(R.drawable.shell_tab_mine);

        ShellAdapter adapter = new ShellAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < fragmentList.size(); i++) {
            Objects.requireNonNull(tabLayout.getTabAt(i)).setIcon(tabIconList.get(i));
            Objects.requireNonNull(tabLayout.getTabAt(i)).setText(tabTitleList.get(i));
        }
        Objects.requireNonNull(tabLayout.getTabAt(1)).select();

    }

    @Override
    protected void initToolBar() {
        mFrameToolbar = (FrameLayout) LayoutInflater.from(this).inflate(R.layout.toolbar_no_back,
                mBaseContentView, false);
        tvTitle = mFrameToolbar.findViewById(R.id.tv_base_title);
    }

    public ViewPager getViewPager() {
        if(viewPager != null) {
            return viewPager;
        }
        return null;
    }

    public TabLayout getTabLayout() {
        if (tabLayout != null) {
            return tabLayout;
        }
        return null;
    }

}
