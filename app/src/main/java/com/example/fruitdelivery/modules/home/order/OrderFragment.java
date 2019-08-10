package com.example.fruitdelivery.modules.home.order;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseFragment;

public class OrderFragment extends BaseFragment<OrderPresenter> {
    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    protected OrderPresenter createPresenter() {
        return new OrderPresenter();
    }

    @Override
    protected void initView() {


    }
}
