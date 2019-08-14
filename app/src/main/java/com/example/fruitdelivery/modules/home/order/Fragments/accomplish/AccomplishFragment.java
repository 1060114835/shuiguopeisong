package com.example.fruitdelivery.modules.home.order.Fragments.accomplish;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;
import com.example.fruitdelivery.modules.home.order.Fragments.allitem.AllItemRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class AccomplishFragment extends BaseFragment<AccomplishPresenter> {
    private RecyclerView mRecyclerView;
    private AccomplishRecyclerViewAdapter adapter;
    private List<AllItemRecyclerViewAdapter.AllItemBean> mList = new ArrayList<>();
    private boolean flags = true;


    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order_accomplish;
    }

    @Override
    protected AccomplishPresenter createPresenter() {
        return new AccomplishPresenter();
    }

    @Override
    protected void initView() {
        if (flags) {
            initData(mList);
            flags = false;
        }
        mRecyclerView = mView.findViewById(R.id.rv_order_accomplish);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new AccomplishRecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(adapter);
    }

    void initData(List<AllItemRecyclerViewAdapter.AllItemBean> list) {
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
            list.add(allItemBean);
            list.add(allItemBean1);
            list.add(allItemBean2);
            list.add(allItemBean3);
            list.add(allItemBean4);
            list.add(allItemBean5);
        }
    }
}
