package com.example.fruitdelivery.debug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.modules.home.shell.ShellActivity;
import com.example.fruitdelivery.util.ScreenUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 测试活动 可作为应用程序的入口
 * 用法: 参照 toHomeActivity()方法的使用方式
 */
public class DebugActivity extends AppCompatActivity {

    private LinearLayout llDebug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        llDebug = findViewById(R.id.ll_debug);
        addButtons();
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
}
