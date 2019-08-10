package com.example.fruitdelivery.modules.home.order.Fragments;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;

public class AllItemFragment extends Fragment {
    private RecyclerView mRecyclerView ;
    private View mRootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_order_allitem,container,false);
        return mRootView;
    }
    private void initView() {
        mRecyclerView = mRootView.findViewById(R.id.rv_order_allItem);
    }
}
