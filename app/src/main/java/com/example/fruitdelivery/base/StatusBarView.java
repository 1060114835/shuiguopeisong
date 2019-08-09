package com.example.fruitdelivery.base;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 做了版本适配，低版本的状态栏字体颜色是白色的
 */
public class StatusBarView extends View {
    public StatusBarView(Context context) {
        super(context);
    }

    public StatusBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setBackgroundColor(int color) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            setBackground(new ColorDrawable(Color.BLACK));
        } else {
            super.setBackgroundColor(color);
        }
    }
}
