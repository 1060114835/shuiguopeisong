package com.example.fruitdelivery.modules.home.order.main_fragment;

import com.example.fruitdelivery.base.BasePresenter;
import com.example.fruitdelivery.modules.home.order.main_fragment.OrderFragment;
import com.example.fruitdelivery.modules.home.order.main_fragment.OrderModel;

public class OrderPresenter extends BasePresenter<OrderFragment, OrderModel> {
    @Override
    protected OrderModel createModel() {
        return new OrderModel();
    }
}
