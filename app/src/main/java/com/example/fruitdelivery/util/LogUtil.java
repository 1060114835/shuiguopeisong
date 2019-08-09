package com.example.fruitdelivery.util;

import android.util.Log;

/**
 * 日志打印模块
 */
public final class LogUtil {

    //公共日志
    private static boolean openCommonLog = Config.openCommonLog;

    //网络专属日志
    private static boolean openNetLog = Config.openNetLog;

    public static final String TAG = "LOG--";

    public static void d(String  msg) {
        if (openCommonLog)
            Log.d(TAG, msg);
    }

    public static void w(String msg) {
        if (openCommonLog)
            Log.w(TAG, msg);
    }

    public static void e(String msg) {
        if (openCommonLog)
            Log.e(TAG, msg);
    }

    public static void dNet(String msg) {
        if (openNetLog)
            Log.d(TAG, msg);
    }

    public static void wNet(String msg) {
        if (openNetLog)
            Log.w(TAG, msg);
    }

    public static class Config {
        //公共日志
        private static boolean openCommonLog = true;

        //网络专属日志
        private static boolean openNetLog = true;

        public static boolean isOpenCommonLog() {
            return openCommonLog;
        }

        public static void setOpenCommonLog(boolean openCommonLog) {
            Config.openCommonLog = openCommonLog;
        }

        public static boolean isOpenNetLog() {
            return openNetLog;
        }

        public static void setOpenNetLog(boolean openNetLog) {
            Config.openNetLog = openNetLog;
        }
    }
}
