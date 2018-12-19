package com.demo.ycwang.ycwangdemo.viewdraghelper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.demo.ycwang.ycwangdemo.R;

/**
 * @Author: ycwang
 * @Date: 2018-12-17 17:04
 */
public class ViewDragHelperActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drag_helper);

        DirectionDragLayout dragLayout = findViewById(R.id.drag_layout);
        dragLayout.setCallBack(new DirectionDragLayout.ReachBoundCallBack() {
            @Override
            public void reachTopBound() {
                Toast.makeText(getApplicationContext(), "reachTopBound", Toast.LENGTH_LONG).show();
            }

            @Override
            public void reachLeftBound() {
                Toast.makeText(getApplicationContext(), "reachLeftBound", Toast.LENGTH_LONG).show();
            }

            @Override
            public void reachRightBound() {
                Toast.makeText(getApplicationContext(), "reachRightBound", Toast.LENGTH_LONG).show();
            }
        });
    }
}
