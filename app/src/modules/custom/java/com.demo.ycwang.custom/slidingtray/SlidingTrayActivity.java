package com.demo.ycwang.custom.slidingtray;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.demo.ycwang.ycwangdemo.R;
import com.demo.ycwang.ycwangdemo.utils.Utils;

/**
 * @Author: ycwang
 * @Date: 2018-12-18 11:23
 * 类似抽屉滑动
 */
public class SlidingTrayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_tray);

        FrameLayout rootView = findViewById(R.id.root_view);
        View contentView = getView(R.layout.view_content);
        View handlerView = getView(R.layout.view_handler);

        SlidingTray slidingTray = new SlidingTray(this, handlerView, contentView, SlidingTray.TOP);
        slidingTray.setHandlePosition(Side.TOP);
        rootView.addView(slidingTray,
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        Utils.getViewHeight(contentView) + Utils.getViewHeight(handlerView)));

        slidingTray.setOnDrawerCloseListener(new SlidingTray.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                Toast.makeText(getApplicationContext(), "onDrawerClosed", Toast.LENGTH_SHORT).show();
            }
        });

        slidingTray.setOnDrawerOpenListener(new SlidingTray.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                Toast.makeText(getApplicationContext(), "onDrawerOpened", Toast.LENGTH_SHORT).show();
            }
        });

        // 设置后抽屉打不开
        // slidingTray.lock();

        // 设置为false 单击打不开抽屉
        // slidingTray.setAllowSingleTap(false);
    }


    public View getView(int resId) {
        View view = LayoutInflater.from(this).inflate(resId, null);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        } else {
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        view.setLayoutParams(params);
        return view;
    }
}
