package com.example.fruitdelivery.util;


import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Method;

/**
 * 屏幕工具类
 */
public final class ScreenUtil {

    private static int heightPx, widthPx;

    private static int statusBarHeight = 0;

    //这里的高度无论在哪种情况下都不包含菜单栏高度
    private static float heightDp, widthDp;

    private static float density;

    private static int maxHeightPx;

    //注意菜单栏高度有可能为0
    private static int menuBarHeightPx;

    /**
     * 初始化参数
     */
    public static void initAttr(Context context) {
        //获取status_bar_height资源的ID
        int resourceId = context.getResources().getIdentifier("status_bar_height",
                "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        heightPx = dm.heightPixels;
        widthPx = dm.widthPixels;
        //density = dm.density;
        density = (float) widthPx / dm.density / 360f * dm.density;
        heightDp = heightPx / density;
        widthDp = widthPx / density;
        maxHeightPx = getMaxHeightPx(context);
        menuBarHeightPx = maxHeightPx - heightPx;
    }

    /**
     * 获取屏幕最大高度
     */
    private static int getMaxHeightPx(Context context) {
        if (maxHeightPx != 0) return maxHeightPx;

        int h = 0;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            h = dm.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return h;
    }

    /**
     * 获取屏幕的真实高度(出去菜单栏的可见高度)
     */
    public static int getRealHeight(AppCompatActivity activity) {
        if (checkPopupMenuBar(activity)) {
            return heightPx;
        } else {
            return maxHeightPx;
        }
    }

    /**
     * 检查当前菜单栏是否弹起
     */
    public static boolean checkPopupMenuBar(AppCompatActivity activity) {
        Rect dr = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(dr);
        //可见高度往往比真实高度要小一些
        return dr.height() + menuBarHeightPx <= maxHeightPx;
    }

    /**
     * 状态栏高度px
     */
    public static int getStatusBarHeight(){
        return statusBarHeight;
    }

    /**
     * 屏幕宽度px
     */
    public static int getWidthPx() {
        return widthPx;
    }

    /**
     * 屏幕高度（像素）
     */
    public static int getHeightPx() {
        return heightPx;
    }

    /**
     * 屏幕宽度(dp)
     */
    public static float getWidthDp() {
        return widthDp;
    }

    /**
     * 屏幕高度(dp)
     */
    public static float getHeightDp() {
        return heightDp;
    }

    /**
     * 屏幕密度
     */
    public static float getDensity() {
        return density;
    }

    /**
     * 屏幕最大高度
     */
    public static int getMaxHeightPx() {
        return maxHeightPx;
    }

    /**
     * 菜单栏高度
     */
    public static int getMenuBarHeightPx() {
        return menuBarHeightPx;
    }

    /**
     * 点亮手机屏幕
     */
    public static void makeLight(Context context) {
        // 获取电源管理器对象
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (!pm.isInteractive()) {
            // 获取PowerManager.WakeLock对象,后面的参数|表示同时传入两个值,最后的是LogCat里用的Tag
            PowerManager.WakeLock wl = pm.newWakeLock(
                    PowerManager.ACQUIRE_CAUSES_WAKEUP |
                            PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "mpp:bright");
            wl.acquire(5000); // 点亮屏幕
            wl.release(); // 释放
        }
    }
}


