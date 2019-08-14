package com.example.fruitdelivery.modules.home.shell;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

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
        tabLayout = findViewById(R.id.shell_tab_layout);
        List<Fragment> fragmentList = new ArrayList<>();
        final List<String> tabTitleList = new ArrayList<>();
        List<Integer> tabIconList = new ArrayList<>();
        final List<String> titleList = new ArrayList<>();

        fragmentList.add(new OrderFragment());
        fragmentList.add(new HomeFragment());
        fragmentList.add(new MyFragment());
        tabTitleList.add("订单");
        tabTitleList.add("首页");
        tabTitleList.add("我的");
        tabIconList.add(R.drawable.shell_tab_order);
        tabIconList.add(R.drawable.shell_tab_homepage);
        tabIconList.add(R.drawable.shell_tab_mine);
        titleList.add("我的订单");
        titleList.add("我的首页");
        titleList.add("个人信息");


        ShellAdapter adapter = new ShellAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < fragmentList.size(); i++) {
            Objects.requireNonNull(tabLayout.getTabAt(i)).setIcon(tabIconList.get(i));
            Objects.requireNonNull(tabLayout.getTabAt(i)).setText(tabTitleList.get(i));
        }
        setTitle(titleList.get(1));
        Objects.requireNonNull(tabLayout.getTabAt(1)).select();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setTitle(titleList.get(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

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
