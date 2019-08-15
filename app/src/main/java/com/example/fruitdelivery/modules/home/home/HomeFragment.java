package com.example.fruitdelivery.modules.home.home;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fruitdelivery.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Richard
 * @date: 2019/8/12
 * @describe: 首页碎片
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<String> urlList = new ArrayList<>();
    private HomeRecyclerViewAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private LinearLayoutManager manager;
    private View viewHome;
    private static int[] images;
    private int loadCount = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        viewHome = view;

        initSwipeRefresh();
        initRecyclerView();
        initRecyclerViewListener();
        return view;
    }

    /**
     * 提供 ViewPager 轮播的 ImageView集合
     */
    public static ArrayList<ImageView> getBannerData(Context context) {

        ArrayList<ImageView> imageViewList = new ArrayList<>();
        setImages();
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(images[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViewList.add(imageView);
        }
        return imageViewList;
    }

    /**
     * 设置 banner图片数组
     */
    private static void setImages() {
        images = new int[]{R.drawable.home_banner_lemon,R.drawable.home_banner_shala,
        R.drawable.home_banner_blueberry,R.drawable.home_banner_orange,R.drawable.
                home_banner_strawberry};
    }

    /**
     * 提供 banner图片的数组
     */
    public static int[] getImages() {
        return images;
    }

    /**
     * RecyclerView 的初始化
     */
    private void initRecyclerView() {
        recyclerView = viewHome.findViewById(R.id.home_recycler_view);
        adapter = new HomeRecyclerViewAdapter(urlList,getContext());
        manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,
                false);
        //自动刷新：一
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
            }
        });

        //自动刷新：二
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                urlList.clear();
                getData();
                adapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(manager);

            }
        },2000);
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
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Log.d("TAG","onSrcolled()方法执行");
                                getData();
                                if (loadCount <= 2) {
                                    adapter.setLoadState(adapter.STATE_LOADING);
                                }else {
                                    adapter.setLoadState(adapter.STATE_FINISH);
                                }
                                adapter.notifyDataSetChanged();
                            }
                        },1000);
                    }
                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView,dx,dy);
            }
        });
    }

    /**
     * RecyclerView 的点击监听，后面接口出来再进行设置
     */
    private void initClickListener() {

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    /**
     * SwipeRefreshLayout 的初始化、包括监听
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
                loadCount = 0;
                getData();
                adapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
            }
        });


        Log.d("TAG","调用onRefresh方法");

    }


    /**
     * 获取网络数据,这里先用本地的数据代替
     */
    private void getData() {
        if (loadCount <= 2){
            for (int i = 0; i < 2; i++) {
                urlList.add(String.valueOf(i));
            }
            Log.d("TAG","getData执行");
            loadCount++;
        }
    }

}
