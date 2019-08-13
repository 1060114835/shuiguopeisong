package com.example.fruitdelivery.modules.account.register;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseActivity;
import com.example.fruitdelivery.base.BasePresenter;

/**
 * @author dyy15
 */
public class Test extends AppCompatActivity {
    private ScrollView mRootScrollView;
    private EditText input;
    private Handler mhandler=new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mRootScrollView=findViewById(R.id.scrollView);
        input = findViewById(R.id.et_account);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mhandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRootScrollView.fullScroll(View.FOCUS_DOWN);
                    }
                },100);
            }
        });
    }

}
