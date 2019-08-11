package com.example.fruitdelivery.modules.home.self;

import com.example.fruitdelivery.base.BasePresenter;
import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;

public class MyPresenter extends BasePresenter<MyFragment,MyModel> {

    MyModel.CallBack callBack = new MyModel.CallBack() {
        @Override
        public void setJson(JsonRootBean json) {
            setMyData(json);
        }
    };

    @Override
    protected MyModel createModel() {
        return new MyModel(callBack);
    }

    public void setMyData(JsonRootBean jsonRootBean){

    }
}
