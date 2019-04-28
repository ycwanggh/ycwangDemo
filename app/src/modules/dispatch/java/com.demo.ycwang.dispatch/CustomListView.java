package com.demo.ycwang.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.ListView;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/25 17:14
 */
public class CustomListView extends ListView {

    private int x;
    private int y;
    private int touchSlop;
    private boolean isSlide;
    private ScrollerItemView lastItemView;
    private VelocityTracker velocityTracker;


    public CustomListView(Context context) {
        this(context, null);
    }

    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        addVelocityTracker(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {

                x = (int) event.getX();
                y = (int) event.getY();
                Log.e("lishm", "x = " + x);
                ScrollerItemView currentItemView = null;

                int position = pointToPosition(x, y);
                if (position != INVALID_POSITION) {
                    currentItemView = (ScrollerItemView) getChildAt(position);
                }
                if (lastItemView != null
                        && lastItemView.isOpenHolderView()
                        && lastItemView != currentItemView) {
                    lastItemView.shrink();
                    lastItemView = null;
                    return false;
                } else {
                    lastItemView = currentItemView;
                    return super.dispatchTouchEvent(event);
                }
            }
            case MotionEvent.ACTION_MOVE: {
                if (lastItemView != null) {
                    Log.e("ycwang", "getScrollVelocity():" + getScrollVelocity());
                    Log.e("lishm", "move  x = " + event.getX());
                    if (Math.abs(getScrollVelocity()) > 600
                            || lastItemView.isOpenHolderView()
                            || ((Math.abs(event.getX() - x) > touchSlop) && (Math.abs(event.getY() - y) < touchSlop))) {
                        isSlide = true;
                    }
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                Log.e("lishm", "ACTION_UP");
                recycleVelocityTracker();
                break;
            }
            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isSlide && lastItemView != null) {
            lastItemView.onRequireTouchEvent(ev);
            switch (ev.getAction()) {
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP: {
                    isSlide = false;
                    break;
                }
            }
            return true;
        }
        if (lastItemView != null && lastItemView.isOpenHolderView()) {
            return true;
        }
        return super.onTouchEvent(ev);
    }

    private void recycleVelocityTracker() {
        if (velocityTracker != null) {
            velocityTracker.recycle();
            velocityTracker = null;
        }
    }


    private int getScrollVelocity() {
        velocityTracker.computeCurrentVelocity(1000);
        return (int) velocityTracker.getXVelocity();
    }

    private void addVelocityTracker(MotionEvent event) {
        if (velocityTracker == null) {
            velocityTracker = VelocityTracker.obtain();
        }
        velocityTracker.addMovement(event);
    }

}
