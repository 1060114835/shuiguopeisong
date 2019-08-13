package com.example.fruitdelivery.modules.home.shell;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Richard
 * @date: 2019/8/13
 * @describe: 壳活动 ViewPager的 Adapter
 */
public class ShellAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
//    private List<String> tabTitleList = new ArrayList<>();

    public ShellAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

/*
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleList.get(position);
    }
*/

}
