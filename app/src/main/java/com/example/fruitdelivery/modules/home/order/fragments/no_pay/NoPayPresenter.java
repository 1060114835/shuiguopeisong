package com.example.fruitdelivery.modules.home.order.fragments.no_pay;

import com.example.fruitdelivery.base.BasePresenter;
import com.example.fruitdelivery.modules.home.order.fragments.AllItemBean;
import com.example.fruitdelivery.modules.home.order.fragments.TypeConstant;

import java.util.List;

class NoPayPresenter extends BasePresenter<NoPayFragment, NoPayModel> {

    @Override
    protected NoPayModel createModel() {
        return new NoPayModel();
    }

}
