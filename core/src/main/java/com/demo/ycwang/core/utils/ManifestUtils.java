package com.demo.ycwang.core.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/12 16:46
 */
public class ManifestUtils {
    private ManifestUtils() {
    }


    /**
     * 获取 Application Meta Data
     *
     * @param metaKey
     * @return
     */
    public static String getMetaData(Context context, String metaKey) {
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            return appInfo.metaData.getString(metaKey);
        } catch (Exception e) {

        }
        return null;
    }


    /**
     * 获取 Activity Meta Data
     *
     * @param clazz
     * @param metaKey
     * @return
     */
    public static String getMetaDataInActivity(Context context, Class<?> clazz, String metaKey) {
        return getMetaDataInActivity(context, clazz.getCanonicalName(), metaKey);
    }


    /**
     * 获取 Activity Meta Data
     *
     * @param name    完整路径名 package.name => class.getCanonicalName()
     * @param metaKey
     * @return
     */
    public static String getMetaDataInActivity(Context context, String name, String metaKey) {
        try {
            ComponentName componentName = new ComponentName(context.getPackageName(), name);
            ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, PackageManager.GET_META_DATA);
            return activityInfo.metaData.getString(metaKey);
        } catch (Exception e) {

        }
        return null;
    }


    /**
     * 获取 Service Meta Data
     *
     * @param clazz
     * @param metaKey
     * @return
     */
    public static String getMetaDataInService(Context context, Class<?> clazz, String metaKey) {
        return getMetaDataInService(context, clazz.getCanonicalName(), metaKey);
    }


    /**
     * 获取 Service Meta Data
     *
     * @param name    完整路径名 package.name => class.getCanonicalName()
     * @param metaKey
     * @return
     */
    public static String getMetaDataInService(Context context, String name, String metaKey) {
        try {
            ComponentName componentName = new ComponentName(context.getPackageName(), name);
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(componentName, PackageManager.GET_META_DATA);
            return serviceInfo.metaData.getString(metaKey);
        } catch (Exception e) {

        }
        return null;
    }


    /**
     * 获取 Receiver Meta Data
     *
     * @param clazz
     * @param metaKey
     * @return
     */
    public static String getMetaDataInReceiver(Context context, Class<?> clazz, String metaKey) {
        return getMetaDataInReceiver(context, clazz.getCanonicalName(), metaKey);
    }


    /**
     * 获取 Receiver Meta Data
     *
     * @param name    完整路径名 package.name => class.getCanonicalName()
     * @param metaKey
     * @return
     */
    public static String getMetaDataInReceiver(Context context, String name, String metaKey) {
        try {
            ComponentName componentName = new ComponentName(context.getPackageName(), name);
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(componentName, PackageManager.GET_META_DATA);
            return receiverInfo.metaData.getString(metaKey);
        } catch (Exception e) {

        }
        return null;
    }

    // -

    /**
     * 获取 ContentProvider Meta Data
     *
     * @param clazz
     * @param metaKey
     * @return
     */
    public static String getMetaDataInProvider(Context context, Class<?> clazz, String metaKey) {
        return getMetaDataInProvider(context, clazz.getCanonicalName(), metaKey);
    }


    /**
     * 获取 ContentProvider Meta Data
     *
     * @param name    完整路径名 package.name => class.getCanonicalName()
     * @param metaKey
     * @return
     */
    public static String getMetaDataInProvider(Context context, String name, String metaKey) {
        try {
            ComponentName componentName = new ComponentName(context.getPackageName(), name);
            ProviderInfo providerInfo = context.getPackageManager().getProviderInfo(componentName, PackageManager.GET_META_DATA);
            return providerInfo.metaData.getString(metaKey);
        } catch (Exception e) {

        }
        return null;
    }

    // ==

    /**
     * 获取 App 版本信息
     *
     * @return 0 = versionName , 1 = versionCode
     */
    public static String[] getAppVersion(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            if (pi != null) {
                String versionName = pi.versionName == null ? "null" : pi.versionName;
                String versionCode = pi.versionCode + "";
                return new String[]{versionName, versionCode};
            }
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 获取 App 版本号
     *
     * @return 当前版本Code
     */
    public static int getAppVersionCode(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            if (pi != null) {
                return pi.versionCode;
            }
        } catch (Exception e) {

        }
        return -1;
    }

    /**
     * 获取 App 版本信息
     *
     * @return 当前版本信息
     */
    public static String getAppVersionName(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            if (pi != null) {
                return pi.versionName;
            }
        } catch (Exception e) {

        }
        return null;
    }

    // =

    /**
     * 获取 App 版本号 - 内部判断
     *
     * @param packageName
     * @return
     */
    public static int getAppVersionCode(Context context, final String packageName) {
        if (CheckUtils.isEmpty(packageName)) {
            return -1;
        }
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            return pi == null ? -1 : pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }


    /**
     * 获取 App 版本名 - 对外显示
     *
     * @param packageName
     * @return
     */
    public static String getAppVersionName(Context context, final String packageName) {
        if (CheckUtils.isEmpty(packageName)) {
            return null;
        }
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            return pi == null ? null : pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }
}
