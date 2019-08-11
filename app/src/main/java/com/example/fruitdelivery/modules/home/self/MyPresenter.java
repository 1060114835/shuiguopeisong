package com.example.fruitdelivery.modules.home.self;

import com.example.fruitdelivery.base.BasePresenter;

public class MyPresenter extends BasePresenter<MyFragment,MyModel> {
    @Override
    protected MyModel createModel() {
        return new MyModel();
    }
}
