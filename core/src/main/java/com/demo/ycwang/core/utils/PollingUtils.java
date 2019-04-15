package com.demo.ycwang.core.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;

/**
 * @Description: 轮询工具类
 * @Author: ycwang
 * @Date: 2019/4/15 11:24
 */
public class PollingUtils {

    private PollingUtils() {
    }

    /**
     * 开启轮询
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void startPolling(Context context, int mills, PendingIntent pendingIntent) {
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        manager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), mills, pendingIntent);
    }

    /**
     * 停止轮询
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void stopPolling(Context context, PendingIntent pendingIntent) {
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);
    }

    /**
     * 开启轮询服务
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void startPollingService(Context context, int mills, Class<?> clazz, String action) {
        Intent intent = new Intent(context, clazz);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        startPolling(context, mills, pendingIntent);
    }

    /**
     * 停止轮询服务
     */
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    public static void stopPollingService(Context context, Class<?> clazz, String action) {
        Intent intent = new Intent(context, clazz);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        stopPolling(context, pendingIntent);
    }


}
