package com.example.fruitdelivery.common.net;


import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 这个类存放Retrofit的Api接口，当后端的接口出来后我会补齐
 */
public interface Apis {
    String ARTICLE_URL = "article/list/1/json";
    /**
     * 这个是网上的Api，这里只是拿来试验一下
     */
    @GET(ARTICLE_URL)
    Observable<JsonRootBean> getArticleCall();
}
