package com.demo.ycwang.base;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.demo.ycwang.ycwangdemo.R;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txw_edit = findViewById(R.id.txw_edit);
        txw_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchSpaceEditText(MainActivity.this);
            }
        });

        TextView txw_notification = findViewById(R.id.txw_notification);
        txw_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchNotification(MainActivity.this);
            }
        });

        TextView txw_mvp = findViewById(R.id.txw_mvp);
        txw_mvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchMVP(MainActivity.this);
            }
        });

        TextView txw_data = findViewById(R.id.txw_data);
        txw_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchData(MainActivity.this);
            }
        });

        TextView txw_text_utils = findViewById(R.id.txw_text_utils);
        txw_text_utils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchTextUtils(MainActivity.this);
            }
        });

        TextView txw_animation = findViewById(R.id.txw_animation);
        txw_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchAnimation(MainActivity.this);
            }
        });

        TextView txw_key_board = findViewById(R.id.txw_key_board);
        txw_key_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchKeyBoard(MainActivity.this);
            }
        });

        TextView txw_image_crop = findViewById(R.id.txw_image_crop);
        txw_image_crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchCropImage(MainActivity.this);
            }
        });

        TextView txw_slide_tab = findViewById(R.id.txw_slide_tab);
        txw_slide_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchSlideTab(MainActivity.this);
            }
        });

        TextView txw_view_drag_helper = findViewById(R.id.txw_view_drag_helper);
        txw_view_drag_helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchViewDragHelper(MainActivity.this);
            }
        });

        TextView txw_tab = findViewById(R.id.txw_tab);
        txw_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchTab(MainActivity.this);
            }
        });

        TextView txw_slidingtray = findViewById(R.id.txw_slidingtray);
        txw_slidingtray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchSlidingTray(MainActivity.this);
            }
        });

        TextView txw_recycler_view = findViewById(R.id.txw_recycler_view);
        txw_recycler_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchRecyclerView(MainActivity.this);
            }
        });

        TextView txw_storage = findViewById(R.id.txw_storage);
        txw_storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchStorageUtils(MainActivity.this);
            }
        });

        TextView txw_layout_test = findViewById(R.id.txw_layout_test);
        txw_layout_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchSerVice(MainActivity.this);
            }
        });
    }

}
