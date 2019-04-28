package com.demo.ycwang.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/24 15:34
 */
public class MyViewA extends View {

    public MyViewA(Context context) {
        super(context);
    }

    GestureDetector gestureDetector;

    public MyViewA(Context context, AttributeSet attrs) {
        super(context, attrs);
        gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Log.e("ycwang", "onDoubleTap");
                return super.onDoubleTap(e);
            }


            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.e("ycwang", "onSingleTapUp");
                return super.onDoubleTap(e);
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Log.e("ycwang", "onLongPress");
                super.onLongPress(e);
            }

        });
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return true;
    }
}
