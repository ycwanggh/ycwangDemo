package com.demo.ycwang.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/5/5 14:44
 */
public class StorageUti {

    public static void main(String[] args) {

    }


    /**
     * 如果你的手机插了SD卡的话，那么它打印的路径就有两条了，例如我的华为荣耀7插了SD卡，它的结果如下：
     * /storage/emulated/0/Android/data/packname/files/mounted
     * /storage/B3E4-1711/Android/data/packname/files/mounted
     * 其中/storage/emulated/0 目录就是机身存储的外部存储路径
     * 而/storage/B3E4-1711/ 就是SD卡的路径
     *
     * @param context
     */
    public static void getExternalPath(Context context) {
        File[] files;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            files = context.getExternalFilesDirs(Environment.MEDIA_MOUNTED);
            for (File file : files) {
                Log.e("main", file.getAbsolutePath());
            }
        }
    }


    public static String getFilePath(Context context, String dir) {
        String directoryPath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            // 外部存储可用则选用外部存储
            directoryPath = context.getExternalFilesDir(dir).getAbsolutePath();
        } else {
            directoryPath = context.getFilesDir() + File.separator + dir;
        }
        File file = new File(directoryPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return directoryPath;
    }
}
