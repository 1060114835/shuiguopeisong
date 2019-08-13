package com.example.fruitdelivery.util;

import android.util.Log;

import com.example.fruitdelivery.common.net.Apis;
import com.example.fruitdelivery.util.TestBean.JsonRootBean;

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
    private static final String BASE_URL = "https://www.wanandroid.com/";
    private static final String BASE_URL_1 = "https://gank.io/api/";

    public interface ArticleCallBack {
        void onSuccess(JsonRootBean jsonRootBean);
    }

    private static volatile AnalysisUtil instant;
    private Apis apis;



    private AnalysisUtil() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_1)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apis = retrofit.create(Apis.class);
    }

    public static AnalysisUtil  getDefault() {
        if (instant == null) {
            synchronized (AnalysisUtil.class) {
                if (instant == null) {
                    instant = new AnalysisUtil();
                }
            }
        }
        return instant;
    }

    /**
     * 网络请求——文章模块
     * @param callBack 回调接口
     */

    public void getArticleCall(final ArticleCallBack callBack) {
        apis.getPictureCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonRootBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonRootBean value) {
                        callBack.onSuccess(value);
                        Log.d(TAG, "onNext: 数据请求成功");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: 请求数据失败"+e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: 请求数据完成"+System.currentTimeMillis());
                    }
                });
    }
//    public void getPictureCall(final ArticleCallBack callBack) {
//        apis.getArticleCall()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<JsonRootBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(JsonRootBean jsonRootBean) {
//                        callBack.onSuccess(jsonRootBean);
//                        Log.d(TAG, "onNext: 数据请求成功");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "onError: 请求数据失败"+e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete: 请求数据完成"+System.currentTimeMillis());
//                    }
//                });
    }
