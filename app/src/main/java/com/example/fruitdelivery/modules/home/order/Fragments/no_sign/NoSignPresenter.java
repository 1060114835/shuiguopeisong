package com.example.fruitdelivery.modules.home.order.Fragments.no_sign;

import com.example.fruitdelivery.base.BasePresenter;

public class NoSignPresenter extends BasePresenter<NoSignFragment,NosignModel> {
    @Override
    protected NosignModel createModel() {
        return new NosignModel();
    }
}
