package com.example.fruitdelivery.modules.home.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fruitdelivery.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Richard
 * @date: 2019/8/12
 * @describe: 首页碎片
 */
public class HomeFragment extends Fragment {

    private List<ImageView> imageViewList;
    private int[] images = {R.drawable.home_banner_orange, R.drawable.home_banner_peach,
            R.drawable.home_banner_pineapple, R.drawable.home_banner_strawberry,
            R.drawable.home_banner_tomato};
    private ViewPager viewPager;
    private LinearLayout layout;
    private int lastPosition;
    private RecyclerView recyclerView;
    private List<String> urlList = new ArrayList<>();
    private HomeRecyclerViewAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private LinearLayoutManager manager;
    private View viewHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        viewHome = view;

        initViewPager();
        initViewPagerListener();
        initRecyclerView();
//        initSwipeRefresh();
//        initRecyclerViewListener();

        return view;
    }

    /**
     * ViewPager 做 Banner 轮播的 View 实现
     */
    private void initViewPager() {

        //初始化数据
        imageViewList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(images[i]);
            imageViewList.add(imageView);
        }
        @SuppressLint("InflateParams")
        View viewHomeBanner = getLayoutInflater().inflate(R.layout.fragment_home_banner,
                null, false);

        //初始化ViewPager
        viewPager = viewHomeBanner.findViewById(R.id.home_view_pager);

        Log.d("TAG", String.valueOf(viewPager));

        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(imageViewList);
        viewPager.setAdapter(adapter);
        int firstPosition = Integer.MAX_VALUE/2;
        viewPager.setCurrentItem(firstPosition,true);

        //设置banner指示器
        layout = viewHomeBanner.findViewById(R.id.home_ll_indicator);
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.drawable.home_banner_indicrator);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,5);
            if (i > 0) {
                params.leftMargin = 15;
            }
            layout.addView(imageView,params);
        }

        Log.d("TAG","ViewPager初始化");

    }

    /**
     * ViewPager 的滑动监听
     */
    private void initViewPagerListener() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                layout.getChildAt(i % imageViewList.size()).setSelected(true);
                layout.getChildAt(lastPosition).setSelected(false);
                lastPosition = i % imageViewList.size();
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                //解决滑动冲突
                if (i == ViewPager.SCROLL_STATE_DRAGGING) {
                    refreshLayout.setEnabled(false);
                }else if (i == ViewPager.SCROLL_STATE_SETTLING) {
                    refreshLayout.setEnabled(true);
                }
            }
        });
    }

    /**
     * RecyclerView 的初始化
     */
    private void initRecyclerView() {
        //getData();
        recyclerView = viewHome.findViewById(R.id.home_recycler_view);
        adapter = new HomeRecyclerViewAdapter(urlList,getContext());
        manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        Log.d("TAG","RecyclerView初始化");
        Log.d("TAG", String.valueOf(recyclerView.getAdapter()));
    }

    /**
     * RecyclerView 的滑动监听
     */
    private void initRecyclerViewListener() {



        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int lastItemPosition = manager.findLastCompletelyVisibleItemPosition();
                    int itemCount = manager.getItemCount();
                    if (itemCount - 1 == lastItemPosition) {
                        //getData();
                        adapter.setLoadState(adapter.STATE_LOADING);
                        //判断请求数据是否已经达到上限，再设置滑动状态
                    }
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                //是否向上滑动
            }
        });
    }

    /**
     * RecyclerView 的点击监听
     */
    private void initClickListener() {

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    /**
     * SwipeRefresh 的初始化、包括监听
     */
    private void initSwipeRefresh() {
        refreshLayout = viewHome.findViewById(R.id.home_swipe_refresh);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                urlList.clear();
                //getData();
                adapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    /**
     * 获取网络数据
     */
//    private void getData() {
//        AnalysisUtil.getDefault().getArticleCall(new AnalysisUtil.ArticleCallBack() {
//            @Override
//            public void onSuccess(JsonRootBean jsonRootBean) {
//                urlList.add(jsonRootBean.getResults().get(0).getUrl());
//                Log.d("TAG",urlList.get(1));
//            }
//        });
//    }

}
