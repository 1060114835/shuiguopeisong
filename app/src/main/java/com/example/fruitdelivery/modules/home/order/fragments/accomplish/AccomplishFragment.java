package com.example.fruitdelivery.modules.home.order.fragments.accomplish;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;
import com.example.fruitdelivery.modules.home.order.fragments.AllItemBean;
import com.example.fruitdelivery.modules.home.order.fragments.TypeConstant;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class AccomplishFragment extends BaseFragment<AccomplishPresenter> {
    private RecyclerView mRecyclerView;
    private AccomplishRecyclerViewAdapter adapter;
    private List<AllItemBean> mList ;

    public AccomplishFragment(List<AllItemBean> mList) {
        this.mList = mList;
    }

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
        mRecyclerView = mView.findViewById(R.id.rv_order_accomplish);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new AccomplishRecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(adapter);
    }

}
