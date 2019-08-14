package com.example.fruitdelivery.modules.home.order.fragments.total;

import com.example.fruitdelivery.base.BasePresenter;

public class TotalPresenter extends BasePresenter<TotalFragment,TotalModel> {
    @Override
    protected TotalModel createModel() {
        return new TotalModel();
    }
}
