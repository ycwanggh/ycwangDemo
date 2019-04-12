package com.demo.ycwang.core.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * 用于获取手机文件存储目录的便捷类
 *
 * @author lijianqing
 */

public final class StorageDirUtils {

    private StorageDirUtils() {

    }

    /**
     * 返回应用程序内部cache根目录
     * /data/user/0/xxxxxx/cache
     */
    public static File getInternalCacheDir(final Context context) {
        return context.getCacheDir();
    }

    /**
     * 返回应用程序内部files根目录
     * /data/user/0/xxxxxx/files
     */
    public static File getInternalFilesDir(final Context context) {
        return context.getFilesDir();
    }

    /**
     * 返回应用程序外部cache根目录
     * /storage/emulated/0/Android/data/xxxxxx/cache
     */
    public static File getExternalCacheDir(final Context context) {
        return isExternalAvailable() ? context.getExternalCacheDir() : null;
    }

    /**
     * 返回应用程序外部files根目录
     * /storage/emulated/0/Android/data/xxxxxx/files
     */
    public static File getExternalFilesDir(final Context context) {
        return isExternalAvailable() ? context.getExternalFilesDir(null) : null;
    }

    /**
     * 返回应用程序外部下载目录。如果外部存储不可用，返回null。
     * /storage/emulated/0/Android/data/xxxxxx/files/Download
     */
    public static File getExternalDownloadDir(final Context context) {
        return isExternalAvailable() ? context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) : null;
    }

    /**
     * 返回应用程序外部图片目录。如果外部存储不可用，返回null。
     * /storage/emulated/0/Android/data/xxxxxx/files/Pictures
     */
    public static File getExternalPicturesDir(final Context context) {
        return isExternalAvailable() ? context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : null;
    }

    /**
     * 返回应用程序外部相册目录。如果外部存储不可用，返回null。
     * /storage/emulated/0/Android/data/xxxxxx/files/DCIM
     */
    public static File getExternalDCIMDir(final Context context) {
        return isExternalAvailable() ? context.getExternalFilesDir(Environment.DIRECTORY_DCIM) : null;
    }

    /**
     * 返回外部存储的根目录
     * /storage/emulated/0
     */
    public static File getExternalStorageRoot() {
        if (isExternalAvailable()) {
            return Environment.getExternalStorageDirectory();
        } else {
            return null;
        }
    }

    /**
     * 返回用于放置下载的顶级共享/外部存储目录。如果获取失败，返回null。
     * /storage/emulated/0/Download
     */
    public static File getExternalStoragePublicDownloadDir() {
        if (isExternalAvailable()) {
            final File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if (file != null) {
                file.mkdirs();
                return file;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 返回用于放置图片的顶级共享/外部存储目录。如果获取失败，返回null。
     * /storage/emulated/0/Pictures
     */
    public static File getExternalStoragePublicPicturesDir() {
        if (isExternalAvailable()) {
            final File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (file != null) {
                file.mkdirs();
                return file;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 返回用于放置相册的顶级共享/外部存储目录。如果获取失败，返回null。
     * /storage/emulated/0/DCIM
     */
    public static File getExternalStoragePublicDCIMDir() {
        if (isExternalAvailable()) {
            final File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            if (file != null) {
                file.mkdirs();
                return file;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 判断外部存储空间是否可用
     */
    public static boolean isExternalAvailable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    /**
     * 获取/storage/emulated/0/Android/data/xxxxxx/files目录的可用大小
     *
     * @return 可用大小，单位MB。
     */
    public static long getExternalFilesAvailableSize(final Context context) {
        final File file = getExternalFilesDir(context);
        if (file != null) {
            final StatFs statFs = new StatFs(file.getPath());
            return (long) (1.0D * statFs.getBlockSize() * statFs.getAvailableBlocks() / (1024 * 1024));
        } else {
            return 0L;
        }
    }

    /**
     * 判断外部存储空间大小是否足够。是否大于100MB。
     */
    public static boolean isExternalFilesSizeEnough(final Context context) {
        return getExternalFilesAvailableSize(context) > 100L;
    }

}
