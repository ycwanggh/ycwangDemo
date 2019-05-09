package com.demo.ycwang.custom.slide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/5/6 10:27
 */
public class SlideConflict extends ViewGroup {
    public SlideConflict(Context context) {
        super(context);
    }

    public SlideConflict(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideConflict(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    private int lastX;
    private int lastY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean isIntercept = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isIntercept = false;
                break;
            case MotionEvent.ACTION_MOVE:
                if ("父容器需要当前点击事件" == "") {
                    isIntercept = true;
                } else {
                    isIntercept = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                isIntercept = false;
                break;
        }
        lastY = y;
        lastX = x;
        return isIntercept;
    }
}
