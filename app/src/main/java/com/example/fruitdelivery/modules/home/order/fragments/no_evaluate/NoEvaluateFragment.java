package com.example.fruitdelivery.modules.home.order.fragments.no_evaluate;

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
public class NoEvaluateFragment extends BaseFragment<NoEvaluatePresenter> {
    private RecyclerView mRecyclerView;
    private NoEvaluateRecyclerViewAdapter adapter;
    private List<AllItemBean> mList ;
    private boolean flags = true;

    public NoEvaluateFragment(List<AllItemBean> mList) {
        this.mList = mList;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order_no_evaluate;
    }

    @Override
    protected NoEvaluatePresenter createPresenter() {
        return new NoEvaluatePresenter();
    }

    @Override
    protected void initView() {
        mRecyclerView = mView.findViewById(R.id.rv_order_no_evaluate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new NoEvaluateRecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(adapter);

    }
}
