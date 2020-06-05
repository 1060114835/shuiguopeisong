package com.example.fruitdelivery.debug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.common.net.bean.atricle.Datas;
import com.example.fruitdelivery.common.net.bean.atricle.JsonRootBean;
import com.example.fruitdelivery.modules.home.self.MyEvaluateActivity;
import com.example.fruitdelivery.modules.home.shell.ShellActivity;
import com.example.fruitdelivery.util.AnalysisUtil;
import com.example.fruitdelivery.util.ScreenUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 测试活动 可作为应用程序的入口
 * 用法: 参照 toHomeActivity()方法的使用方式
 */
public class DebugActivity extends AppCompatActivity {


    private static final String TAG = "chen_net";
    private LinearLayout llDebug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        llDebug = findViewById(R.id.ll_debug);
   //     addButtons();
        netTest();
    }



    private void netTest() {
        AnalysisUtil.
                getDefault(AnalysisUtil.ChangeUrlInterceptor.ARTICLE_URL)
                .getApis()
                .getArticleCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonRootBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonRootBean value) {
                        for (Datas data:value.getData().getDatas()) {
                            Log.d(TAG, "onNext: "+data.getDesc());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void addButton(String text, final Runnable runnable) {
        Button button = new Button(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int margin = (int) (ScreenUtil.getDensity() * 20f);
        params.leftMargin = margin;
        params.rightMargin = margin;
        params.topMargin = margin;
        button.setLayoutParams(params);
        button.setText(text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runnable.run();
            }
        });

        llDebug.addView(button);
    }

    public void addButtons() {
        addButton("到主页", toHomeActivity());
        addButton("到MyDeBugActivity",toMyDebugActivity());
    }

    /**
     * 到主页去
     */
    public Runnable toHomeActivity() {
        return new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(DebugActivity.this, ShellActivity.class));
            }
        };
    }

    public Runnable toMyDebugActivity(){
        return new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(DebugActivity.this, MyEvaluateActivity.class));
            }
        };
    }
}
