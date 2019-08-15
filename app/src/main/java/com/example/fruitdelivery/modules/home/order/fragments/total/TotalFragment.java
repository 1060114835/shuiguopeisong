package com.example.fruitdelivery.modules.home.order.fragments.total;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;

public class TotalFragment extends BaseFragment<TotalPresenter> {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order_total;
    }

    @Override
    protected TotalPresenter createPresenter() {
        return new TotalPresenter();
    }

    @Override
    protected void initView() {


    }
}
