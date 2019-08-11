package com.example.fruitdelivery.modules.home.self;

import com.example.fruitdelivery.base.BaseModel;
import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;
import com.example.fruitdelivery.util.AnalysisUtil;

class MyModel extends BaseModel<JsonRootBean> {

        CallBack mCallBack;
        public MyModel(CallBack callBack){
            this.mCallBack = callBack;
        }

        public void NetDataStart(){
            AnalysisUtil.getDefault().getArticleCall(new AnalysisUtil.ArticleCallBack() {
                @Override
                public void onSuccess(JsonRootBean jsonRootBean) {
                    mCallBack.setJson(jsonRootBean);
                }
            });
        }

        interface CallBack{
            void setJson(JsonRootBean json);
        }
}
