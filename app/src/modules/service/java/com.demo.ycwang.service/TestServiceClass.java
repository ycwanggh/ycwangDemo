package com.demo.ycwang.service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.demo.ycwang.service.MyService;
import com.demo.ycwang.ycwangdemo.R;

/**
 * 1、startService开启服务以后，与activity就没有关联，不受影响，独立运行。
 * 2、bindService开启服务以后，与activity存在关联，退出activity时必须调用unbindService方法，否则会报ServiceConnection泄漏的错误。
 * <p>
 * 关闭服务需要stopService和unbindService都被调用，也没有先后顺序的影响，MyService的onDestroy也只执行一次。
 * 但是如果只用一种方式关闭服务，不论是哪种关闭方式，onDestroy都不会被执行，服务也不会被关闭。这一点需要注意。
 *
 * @Description:
 * @Author: ycwang
 * @Date: 2019/3/21 10:02
 */
public class TestServiceClass extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // startService()  StopService()
        final Intent intent = new Intent(TestServiceClass.this, MyService.class);
        ((TextView) findViewById(R.id.txw_edit)).setText("startService");
        findViewById(R.id.txw_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });
        ((TextView) findViewById(R.id.txw_recycler_view)).setText("stopService");
        findViewById(R.id.txw_recycler_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });


        // bindService() unBindService()
        final Intent intent1 = new Intent(TestServiceClass.this, MyService.class);
        ((TextView) findViewById(R.id.txw_slidingtray)).setText("bindService");
        findViewById(R.id.txw_slidingtray).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // onCreate() ==> onBind() ==> onServiceConnected();
                bindService(intent1, serviceConnection, Service.BIND_AUTO_CREATE);
            }
        });
        ((TextView) findViewById(R.id.txw_tab)).setText("unbindService");
        findViewById(R.id.txw_tab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //unbindService只能调用一次
                unbindService(serviceConnection);
            }
        });


    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("ycwang", "onServiceConnected()");
            MyService.MyBinder myService = (MyService.MyBinder) service;

            Log.e("ycwang", "调用 MyBinder 的 systemOut() 方法");
            myService.systemOut();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("ycwang", "onServiceDisconnected()");
        }
    };
}
