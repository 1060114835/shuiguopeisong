package com.example.fruitdelivery.common.net;




import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 这个类存放Retrofit的Api接口，当后端的接口出来后我会补齐
 */
public interface Apis {
    String articleUrl = "article/list/3/json";
    String topSearchUrl = "gethotsell";
    String searchUrl = "search";
    String addToShoppingCarUrl = "shoppingcar/update";
    String lookShoppingCarUrl = "shoppingcar/query";
    String deleteShoppingCarUrl = "shoppingcar/delete";
    String fruitDetailUrl = "fruit/fruitDetail";
    String orderListUrl = "order/getOrderList";
    String  registerUrl = "user/register";
    String loginUrl = "user/login";
    String submitUrl = "order/submit";
    String insertUrl = "order/insert";
    String orderUrl = "order";
    String queryAddressUrl = "user/queryaddr";
    String updateAddressUrl = "user/updateaddr";
    String commentInsertUrl = "comment/insert";
    String commentQueryUrl = "comment/query";
    String queryUserUrl = "user/queryuser";
    String updateUserUrl = "user/updateuser";

    @GET(articleUrl)
    Observable<JsonRootBean> getArticleCall();


//    @GET(topSearchUrl)
//    Observable<> getTopSearchCall();
//
//    @GET(searchUrl)
//    Observable<> getSearchCall();
//
//    @GET(addToShoppingCarUrl)
//    Observable<> getAddToShoppingCarCall();
//
//    @GET(lookShoppingCarUrl)
//    Observable<> getLookShoppingCarCall();
//
//    @GET(deleteShoppingCarUrl)
//    Observable<> getDeleteShoppingCarCall();
//
//    @GET(fruitDetailUrl)
//    Observable<> getFruitDetailCall();
//
//    @GET(orderListUrl)
//    Observable<> getOrderListCall();
//
//    @GET(registerUrl)
//    Observable<> getRegisterCall();
//
//    @GET(loginUrl)
//    Observable<> getLoginCall();
//
//    @GET(submitUrl)
//    Observable<> getSubmitCall();
//
//    @GET(insertUrl)
//    Observable<> getInsertCall();
//
//    @GET(orderUrl)
//    Observable<> getOrderCall();
//
//    @GET(queryAddressUrl)
//    Observable<> getQueryAddressCall();
//
//    @GET(queryAddressUrl)
//    Observable<> getQueryAddressCall();
//
//    @GET(updateAddressUrl)
//    Observable<> getUpdateAddressCall();
//
//    @GET(commentInsertUrl)
//    Observable<> getCommentInsertCall();
//
//    @GET(commentQueryUrl)
//    Observable<> getCommentQueryCall();
//
//    @GET(queryUserUrl)
//    Observable<> getQueryUserCall();
//
//    @GET(updateUserUrl)
//    Observable<> getUpdateUserCall();
//










}
