package com.demo.ycwang.custom.camera;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/2/28 10:21
 */
public class CameraActivity extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        CameraManager cameraManager = (CameraManager) this.getSystemService(Context.CAMERA_SERVICE);
        try {
            String[] strings = cameraManager.getCameraIdList();

            CameraCharacteristics c = cameraManager.getCameraCharacteristics(strings[0]);

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            cameraManager.openCamera(strings[0], new CameraDevice.StateCallback() {
                @Override
                public void onOpened(CameraDevice camera) {

                }

                @Override
                public void onDisconnected(CameraDevice camera) {

                }

                @Override
                public void onError(CameraDevice camera, int error) {

                }

                @Override
                public void onClosed(CameraDevice camera) {
                    super.onClosed(camera);
                }
            }, new Handler());
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }


}
