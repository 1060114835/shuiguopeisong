package com.example.fruitdelivery.modules.home.order;

import com.example.fruitdelivery.base.BaseFragment;
import com.example.fruitdelivery.base.BasePresenter;

public class OrderPresenter extends BasePresenter<OrderFragment,OrderModel> {
    @Override
    protected OrderModel createModel() {
        return new OrderModel();
    }
}
