package com.example.fruitdelivery.util;

import android.support.annotation.NonNull;
import android.util.Log;

import com.bumptech.glide.manager.RequestTracker;
import com.example.fruitdelivery.common.net.Apis;
import com.example.fruitdelivery.common.net.bean.atricle.Datas;
import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;

import java.io.IOException;
import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class AnalysisUtil {

    /**
     * 以我在网上找的这个接口为例,具体写法为:
     * AnalysisUtil.getDefault(ChangeUrlInterceptor.BASE_URL_1).getArticleCall(new AnalysisUtil.ArticleCallBack() {
     * //  @Override
     * public void onSuccess(JsonRootBean jsonRootBean) {
     * mTextView.setText(jsonRootBean.getData().getDatas().toString());
     * }
     * });
     * <p>
     * 1.调用getDefault得到Util的实例，然后调用对应Api的方法
     * 2.回调接口内的onSuccess方法内的参数即为bean的根类
     * 3.回调的方法是在UI线程内的
     * 4.每一个Api会写一个对应的方法，需要数据时调用对应的方法
     * 5.每个方法会写注释表明这个方法为哪个模块需要的，就像下面的首页文章模块
     * 6.在M层调用方法获取到数据后可以自己使用接口回调或者返回值的方式将数据返回给P层
     */


    private static volatile AnalysisUtil instant;
    private static volatile Apis apis;


    private AnalysisUtil(String baseUrl) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ChangeUrlInterceptor(baseUrl))
                .addNetworkInterceptor(new HttpLoggingInterceptor().
                        setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apis = retrofit.create(Apis.class);
    }


    public static AnalysisUtil getDefault(String baseUrl) {
        if (instant == null) {
            synchronized (AnalysisUtil.class) {
                if (instant == null) {
                    instant = new AnalysisUtil(baseUrl);
                }
            }
        }
        return instant;
    }

    public Apis getApis() {
        return apis;
    }

    public class ChangeUrlInterceptor implements Interceptor {
        public static final String ARTICLE_URL = "https://www.wanandroid.com/";
        public static final String BASE_URL_1 = "https://localhost/fruit_distribution/";
        public static final String BASE_URL_2 = "http://localhost:8080/fruitproject/";
        public static final String BASE_URL_3 = "https://localhost/fruitproject/";
        public static final String BASE_URL_4 = "https://localhost:8080/fruitproject/";
        private String currentUrl = "";

        public ChangeUrlInterceptor(String url) {
            currentUrl = url;
        }

        //这里不只是可以改变baseUrl，还可以改其他参数，或者进行其他配置，例如配置请求头
        @NonNull
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl url = request.url();
            String scheme = url.scheme();//  http https
            String host = url.host();//   baseURl
            String path = url.encodedPath();//  path
            String query = url.encodedQuery();//   参数列表


            StringBuilder sb = new StringBuilder();
            String newUrl = sb.append(currentUrl).append(path).append("?").append(query).toString();

            Request.Builder builder = request.newBuilder()
                    .url(newUrl);

            return chain.proceed(builder.build());
        }
    }
}
