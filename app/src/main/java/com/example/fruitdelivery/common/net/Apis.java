package com.example.fruitdelivery.common.net;


import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 这个类存放Retrofit的Api接口，当后端的接口出来后我会补齐
 */
public interface Apis {
    String articleUrl = "article/list/1/json";
    String pictureUrl = "data/%E7%A6%8F%E5%88%A9/10/1";
    /**
     * 这个是网上的Api，这里只是拿来试验一下
     */
    @GET(articleUrl)
    Observable<JsonRootBean> getArticleCall();

    @GET(pictureUrl)
    Observable<JsonRootBean> getPictureCall();
}
