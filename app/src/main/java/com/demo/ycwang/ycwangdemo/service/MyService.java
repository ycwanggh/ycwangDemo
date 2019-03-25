package com.demo.ycwang.ycwangdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/3/21 9:59
 */
public class MyService extends Service {

    @Override
    public void onCreate() {
        Log.e("ycwang", "onCreate()");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("ycwang", "onBind()");
        MyBinder binder = new MyBinder();
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("ycwang", "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("ycwang", "onDestroy()");
    }

    class MyBinder extends Binder {

        public void systemOut() {
            Log.e("ycwang", "systemOut()");
            System.out.println("该方法在MyService的内部类MyBinder中");
        }


    }
}
