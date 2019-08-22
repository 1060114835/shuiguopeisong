package com.example.fruitdelivery.util;

import android.util.Log;

import com.example.fruitdelivery.common.net.Apis;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class AnalysisUtil {

    /**
     * 以我在网上找的这个接口为例,具体写法为:
     *         AnalysisUtil.getDefault().getArticleCall(new AnalysisUtil.ArticleCallBack() {
     *         //  @Override
     *             public void onSuccess(JsonRootBean jsonRootBean) {
     *                 mTextView.setText(jsonRootBean.getData().getDatas().toString());
     *             }
     *         });
     *
     * 1.调用getDefault得到Util的实例，然后调用对应Api的方法
     * 2.回调接口内的onSuccess方法内的参数即为bean的根类
     * 3.回调的方法是在UI线程内的
     * 4.每一个Api会写一个对应的方法，需要数据时调用对应的方法
     * 5.每个方法会写注释表明这个方法为哪个模块需要的，就像下面的首页文章模块
     * 6.在M层调用方法获取到数据后可以自己使用接口回调或者返回值的方式将数据返回给P层
     */

    private static final String TAG = "## Retrofit网络请求 ##";
    private static final String BASE_URL_1 = "https://localhost/fruit_distribution/";
    private static final String BASE_URL_2 = "http://localhost:8080/fruitproject/";
    private static final String BASE_URL_3 = "https://localhost/fruitproject/";
    private static final String BASE_URL_4 = "https://localhost:8080/fruitproject/";


    private static volatile AnalysisUtil instant;
    private Apis apis;



    private AnalysisUtil(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apis = retrofit.create(Apis.class);
    }


    public static AnalysisUtil  getDefault(String baseUrl) {
        if (instant == null) {
            synchronized (AnalysisUtil.class) {
                if (instant == null) {
                    instant = new AnalysisUtil(baseUrl);
                }
            }
        }
        return instant;
    }






    }
