package com.demo.ycwang.custom.niotifcation;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.demo.ycwang.ycwangdemo.R;

/**
 * @Author: ycwang
 * @Date: 2019/1/18 14:43
 * @Description:
 */
public class NotificationActivity extends Activity {

    Button btn_normal;

    Button btn_fold;

    Button btn_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        btn_normal = findViewById(R.id.btn_normal);
        btn_normal.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                showNormalNotification();
            }
        });

        btn_fold = findViewById(R.id.btn_fold);
        btn_fold.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                showFoldNotification();
            }
        });

        btn_ = findViewById(R.id.btn_);
        btn_.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                showSuspensionNotification();
            }
        });


        ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE);


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void showNormalNotification() {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cnblogs.com/panhouye/p/6139386.html"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.lock_slide);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_lock_redbag));
        builder.setAutoCancel(true);
        builder.setContentTitle("普通消息");

        Notification n = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(10, n);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void showFoldNotification() {
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cnblogs.com/panhouye/p/6139386.html"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.ic_lock_redbag);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.lock_slide));
        builder.setAutoCancel(true);
        builder.setContentTitle("折叠式消息");

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.view_notification);
        Notification notification = builder.build();
        notification.bigContentView = remoteViews;

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(100, notification);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void showSuspensionNotification() {
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cnblogs.com/panhouye/p/6139386.html"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        builder.setContentTitle("悬挂式");
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.lock_slide));
        builder.setSmallIcon(R.drawable.ic_lock_redbag);


        Intent intent1 = new Intent();
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.setClass(this, NotificationActivity.class);
        PendingIntent pendingIntent1 = PendingIntent.getActivity(this, 0, intent1, PendingIntent.FLAG_CANCEL_CURRENT);

        builder.setFullScreenIntent(pendingIntent1, true);

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(100, notification);


    }


}
