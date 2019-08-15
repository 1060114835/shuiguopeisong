package com.example.fruitdelivery.modules.home.order.fragments.no_sign;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;
import com.example.fruitdelivery.modules.home.order.fragments.AllItemBean;
import com.example.fruitdelivery.modules.home.order.fragments.TypeConstant;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class NoSignFragment extends BaseFragment<NoSignPresenter> {
    private RecyclerView mRecyclerView;
    private NoSignRecyclerViewAdapter adapter;
    private List<AllItemBean> mList ;


    public NoSignFragment(List<AllItemBean> mList) {
        this.mList = mList;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order_no_sign;
    }

    @Override
    protected NoSignPresenter createPresenter() {
        return new NoSignPresenter();
    }

    @Override
    protected void initView() {
        mRecyclerView = mView.findViewById(R.id.rv_order_no_sign);
        Log.d("chen", "initView: "+mRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new NoSignRecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(adapter);
    }
}
