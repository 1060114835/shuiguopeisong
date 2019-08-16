package com.example.fruitdelivery.modules.home.home;

import com.example.fruitdelivery.base.BasePresenter;

/**
 * @author Richard
 * @time 2019/8/15
 * @describe 首页的P层
 */
public class HomePresenter extends BasePresenter<HomeView,HomeModel> {
    @Override
    protected HomeModel createModel() {
        return new HomeModel();
    }
}
