package com.example.fruitdelivery.modules.home.self;

import com.example.fruitdelivery.base.BasePresenter;
import com.example.fruitdelivery.base.IView;
import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;

/**
 * The type My presenter.
 */
public class MyPresenter extends BasePresenter<ISelfView,MyModel> {

    /**
     * The Call back.
     */
    MyModel.CallBack callBack = new MyModel.CallBack() {
        @Override
        public void setJson(JsonRootBean json) {
            connectMyData(json);
        }
    };

    @Override
    protected MyModel createModel() {
        return new MyModel(callBack);
    }

    /**
     * Connect my data.联系V层和M层数据的方法
     *
     * @param jsonRootBean the json root bean
     */
    public void connectMyData(JsonRootBean jsonRootBean){
        mView.setMyData(jsonRootBean);
    }
}
