package com.example.fruitdelivery.modules.home.self;

import com.example.fruitdelivery.base.BaseModel;
import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;
import com.example.fruitdelivery.util.AnalysisUtil;

/**
 * The type My model.
 */
class MyModel extends BaseModel<JsonRootBean> {

    /**
     * The M call back.
     */
    CallBack mCallBack;

    /**
     * 网络请求
     *
     * Json测试数据
     *
     * @param callBack the call back
     */

    public MyModel(CallBack callBack){
            this.mCallBack = callBack;
            AnalysisUtil.getDefault().getArticleCall(new AnalysisUtil.ArticleCallBack() {
                @Override
                public void onSuccess(JsonRootBean jsonRootBean) {
                    mCallBack.setJson(jsonRootBean);
                }
            });
        }

    /**
     *回调接口
     */
    interface CallBack{
        /**
         * Sets json.回调方法
         *
         * @param json the json
         */
        void setJson(JsonRootBean json);
        }
}
