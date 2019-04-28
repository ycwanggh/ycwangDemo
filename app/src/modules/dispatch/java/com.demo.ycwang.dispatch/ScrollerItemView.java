package com.demo.ycwang.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/25 16:19
 */
public class ScrollerItemView extends LinearLayout {

    private int mLastX;
    private int mLastY;
    private Scroller scroller;
    private int mRightViewHolder = 100;
    private boolean isRightViewHolderOpen = false;

    public ScrollerItemView(Context context) {
        this(context, null);
    }

    public ScrollerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }


    private void smoothScrollTo(int destX) {
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;
        scroller.startScroll(scrollX, 0, deltaX, 0, Math.abs(deltaX) / 2);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
            if (scroller.isFinished()) {
                if (getScrollX() == 0) {
                    isRightViewHolderOpen = false;
                }else if (getScrollX() == mRightViewHolder) {
                    isRightViewHolderOpen = true;
                }
            }
        }
    }

    public void onRequireTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        // 滑动的距离
        int scrollX = getScrollX();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                if (!scroller.isFinished()) {
                    scroller.abortAnimation();
                }
                mLastX = x;
                mLastY = y;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                if (Math.abs(deltaX) < Math.abs(deltaY) * 2) {
                    break;
                }
                int newScrollX = scrollX - deltaX;
                if (deltaX != 0) {
                    if (newScrollX < 0) {
                        newScrollX = 0;
                    } else if (newScrollX >= mRightViewHolder) {
                        newScrollX = mRightViewHolder;
                    }
                    smoothScrollTo(newScrollX);
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                x = 0;
                y = 0;
                if (getScrollX() > 0) {
                    int newScrollX = 0;
                    if (isRightViewHolderOpen) {
                        if (scrollX < mRightViewHolder * 0.8) {
                            newScrollX = 0;
                            isRightViewHolderOpen = false;
                        }
                    } else {
                        if (scrollX > mRightViewHolder * 0.2) {
                            newScrollX = mRightViewHolder;
                            isRightViewHolderOpen = true;
                        }
                    }
                    smoothScrollTo(newScrollX);
                }
                break;
            }
        }
        mLastX = x;
        mLastY = y;
    }

    public void shrink() {
        if (getScrollX() != 0) {
            smoothScrollTo(0);
        }
    }

    public boolean isOpenHolderView() {
        return getScrollX() != 0;
    }


}
