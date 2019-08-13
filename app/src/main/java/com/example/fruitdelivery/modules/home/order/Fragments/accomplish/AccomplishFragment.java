package com.example.fruitdelivery.modules.home.order.Fragments.accomplish;

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

    }
}
