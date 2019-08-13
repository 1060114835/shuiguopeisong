package com.example.fruitdelivery.modules.home.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.modules.home.shell.ShellActivity;
import com.example.fruitdelivery.modules.home.shell.ShellAdapter;

/**
 * @author: Richard
 * @date: 2019/8/12
 * @describe: 首页碎片
 */
public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    /**
     * ViewPager 做 Banner 轮播的 View 实现
     */
    private void initViewPager() {

    }

    /**
     * ViewPager 的滑动监听
     */
    private void initViewPagerListener() {

    }

    /**
     * RecyclerView 的初始化
     */
    private void initRecyclerView() {

    }

    /**
     * RecyclerView 的滑动监听
     */
    private void initRecyclerViewListener() {

    }

    /**
     * SwipeRefresh 的初始化、包括监听
     */
    private void initSwipeRefresh() {

    }

    /**
     * 多个ImageView 的实例，以及填图
     */
    private void initImageView() {

    }

}
