package com.example.fruitdelivery.modules.home.order.Fragments;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class AllItemFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private View mRootView;
    private List<AllItemRecyclerViewAdapter.AllItemBean> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_order_allitem, container, false);
        initData();
        initView();
        return mRootView;
    }

    private void initView() {
        mRecyclerView = mRootView.findViewById(R.id.rv_order_allItem);
        /*
        不知道能不能通过这种方式得到context
         */
        RecyclerView.LayoutManager manager = new LinearLayoutManager(mRootView.getContext());
        AllItemRecyclerViewAdapter adapter = new AllItemRecyclerViewAdapter(mList);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
    }

    private void initData() {
        AllItemRecyclerViewAdapter.AllItemBean allItemBean = new AllItemRecyclerViewAdapter
                .AllItemBean("喜悦水果店", "七元一斤", "苹果"
                , "起送￥51|配送￥18", "233", "￥19", "x12", "合计：￥250");
        AllItemRecyclerViewAdapter.AllItemBean allItemBean1 = new AllItemRecyclerViewAdapter
                .AllItemBean("历时达水果店", "七元二斤", "栗子"
                , "起送￥52|配送￥8", "553", "￥23", "x13", "合计：￥123");
        AllItemRecyclerViewAdapter.AllItemBean allItemBean2 = new AllItemRecyclerViewAdapter
                .AllItemBean("再擦水果店", "三元一斤", "香蕉"
                , "起送￥51|配送￥82", "166", "￥13", "x1", "合计：￥423");
        AllItemRecyclerViewAdapter.AllItemBean allItemBean3 = new AllItemRecyclerViewAdapter
                .AllItemBean("无数次水果店", "五元一斤", "猕猴桃"
                , "起送￥10|配送￥12", "2339", "￥42", "x2", "合计：￥131");
        AllItemRecyclerViewAdapter.AllItemBean allItemBean4 = new AllItemRecyclerViewAdapter
                .AllItemBean("偶是水果店", "十元一斤", "桃"
                , "起送￥12|配送￥10", "2883", "￥8", "x3", "合计：￥944");
        AllItemRecyclerViewAdapter.AllItemBean allItemBean5 = new AllItemRecyclerViewAdapter
                .AllItemBean("希望水果店", "四二元一斤", "苹"
                , "起送￥12|配送￥8", "2313", "￥9", "x7", "合计：￥524");

        for (int i = 0; i < 3; i++) {
            mList.add(allItemBean);
            mList.add(allItemBean1);
            mList.add(allItemBean2);
            mList.add(allItemBean3);
            mList.add(allItemBean4);
            mList.add(allItemBean5);
        }
    }
}

