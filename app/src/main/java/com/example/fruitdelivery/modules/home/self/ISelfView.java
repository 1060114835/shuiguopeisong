package com.example.fruitdelivery.modules.home.self;

import com.example.fruitdelivery.base.IView;
import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;

/**
 * The interface Self view.我的V层接口
 */
public interface ISelfView extends IView {
    /**
     * Sets my data.设置数据
     *
     * @param jsonRootBean 测试数据
     */
    void setMyData(JsonRootBean jsonRootBean);
}
