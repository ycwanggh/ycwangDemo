package com.demo.ycwang.util;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.demo.ycwang.ycwangdemo.R;

/**
 * @Author: ycwang
 * @Date: 2019/1/23 17:41
 * @Description:
 */
public class StorageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_storage);


        TextView txwDir = findViewById(R.id.txw_dir);

        String internalCacheDir = StorageDirUtils.getInternalCacheDir(this).getAbsolutePath();
        String internalFilesDir = StorageDirUtils.getInternalFilesDir(this).getAbsolutePath();

        String externalCacheDir = StorageDirUtils.getExternalCacheDir(this).getAbsolutePath();
        String externalFilesDir = StorageDirUtils.getExternalFilesDir(this).getAbsolutePath();
        String externalDownloadDir = StorageDirUtils.getExternalDownloadDir(this).getAbsolutePath();
        String externalPicturesDir = StorageDirUtils.getExternalPicturesDir(this).getAbsolutePath();
        String externalDCIMDir = StorageDirUtils.getExternalDCIMDir(this).getAbsolutePath();
        String externalStorageRoot = StorageDirUtils.getExternalStorageRoot().getAbsolutePath();
        String externalStoragePublicDownloadDir = StorageDirUtils.getExternalStoragePublicDownloadDir().getAbsolutePath();
        String externalStoragePublicPicturesDir = StorageDirUtils.getExternalStoragePublicPicturesDir().getAbsolutePath();
        String externalStoragePublicDCIMDir = StorageDirUtils.getExternalStoragePublicDCIMDir().getAbsolutePath();


        txwDir.setText("internalCacheDir:" + internalCacheDir + "\n\n"
                + "internalFilesDir:" + internalFilesDir + "\n\n"
                + "externalCacheDir:" + externalCacheDir + "\n\n"
                + "externalDownloadDir:" + externalDownloadDir + "\n\n"
                + "externalFilesDir:" + externalFilesDir + "\n\n"
                + "externalPicturesDir:" + externalPicturesDir + "\n\n"
                + "externalDCIMDir:" + externalDCIMDir + "\n\n"
                + "externalStorageRoot:" + externalStorageRoot + "\n\n"
                + "externalStoragePublicDownloadDir:" + externalStoragePublicDownloadDir + "\n\n"
                + "externalStoragePublicPicturesDir:" + externalStoragePublicPicturesDir + "\n\n"
                + "externalStoragePublicDCIMDir:" + externalStoragePublicDCIMDir + "\n\n");

    }
}
