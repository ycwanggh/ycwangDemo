package com.demo.ycwang.core.view.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * File description.
 *
 * @author lijianqing
 * @date 2018-1-24
 */

public final class ActivityTaskManager {

    private static volatile ActivityTaskManager mInstance;

    private int mActivityCount;

    private List<Activity> runningActivities = new ArrayList<>();

    private ActivityTaskManager() {

    }

    public static ActivityTaskManager getInstance() {
        if (mInstance == null) {
            synchronized (ActivityTaskManager.class) {
                if (mInstance == null) {
                    mInstance = new ActivityTaskManager();
                }
            }
        }
        return mInstance;
    }

    public synchronized int getActivityCount() {
        return mActivityCount;
    }

    public synchronized void setActivityCount(int count) {
        mActivityCount = count;
    }

    /**
     * 添加Activity
     *
     * @param activity
     */
    public synchronized void addActivity(Activity activity) {
        runningActivities.add(activity);
    }

    /**
     * 移除Activity
     *
     * @param activity
     */
    public synchronized void removeActivity(Activity activity) {
        runningActivities.remove(activity);
    }

    /**
     * 是否包含
     *
     * @param cls
     * @return
     */
    public synchronized boolean containActivity(Class<?> cls) {
        for (int i = runningActivities.size() - 1; i >= 0; i--) {
            Activity item = runningActivities.get(i);
            if (item.getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 清空至当前Activity 但是不清空当前activity
     *
     * @param cls
     */
    public synchronized void finishActivity(Class<?> cls) {
        for (int i = runningActivities.size() - 1; i >= 0; i--) {
            Activity item = runningActivities.get(i);
            if (item.getClass().equals(cls)) {
                return;
            }
            item.finish();
        }
    }

    /**
     * 清空到当前Activity 并且清空当前activity
     *
     * @param cls
     */
    public synchronized void finishToActivity(Class<?> cls) {
        for (int i = runningActivities.size() - 1; i >= 0; i--) {
            Activity item = runningActivities.get(i);
            item.finish();
            if (item.getClass().equals(cls)) {
                return;
            }
        }
    }

    public synchronized void finishOneActivity(Class<?> cls) {
        for (int i = runningActivities.size() - 1; i >= 0; i--) {
            Activity item = runningActivities.get(i);
            if (item.getClass().equals(cls)) {
                item.finish();
                return;
            }
        }
    }

    /**
     * 退出应用
     */
    public synchronized void finishAllActivity() {
        for (int i = runningActivities.size() - 1; i >= 0; i--) {
            Activity item = runningActivities.get(i);
            item.finish();
        }
    }

    /**
     * 获得顶部activity
     *
     * @return
     */
    public synchronized Activity getTopActivity() {
        if (!runningActivities.isEmpty()) {
            return runningActivities.get(runningActivities.size() - 1);
        }
        return null;
    }

}
