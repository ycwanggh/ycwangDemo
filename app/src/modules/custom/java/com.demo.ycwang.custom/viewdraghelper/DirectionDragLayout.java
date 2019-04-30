package com.demo.ycwang.custom.viewdraghelper;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


import com.demo.ycwang.ycwangdemo.R;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.customview.widget.ViewDragHelper;

/**
 * @Author: ycwang
 * @Date: 2018-12-17 16:59
 */
public class DirectionDragLayout extends ConstraintLayout {

    private ViewDragHelper viewDragHelper;
    private View read;
    private View unlock;
    private View redPacket;
    private View home;
    private Point mHomeCenterPoint = new Point();
    private Point mReadCenterPoint = new Point();
    private Point mUnlockCenterPoint = new Point();
    private Point mRedPacketCenterPoint = new Point();
    private Point mHomeOriginalPoint = new Point();
    private int mTopBound;
    private int mBottomBound;
    private int mLeftBound;
    private int mRightBound;

    /**
     * 当前正在水平拖拽的标记
     */
    private boolean mIsHorizontalDrag = false;
    /**
     * 当前正在竖直拖拽的标记
     */
    private boolean mIsVerticalDrag = false;
    /**
     * 是否到达边界
     */
    private boolean mIsReachBound = false;
    /**
     * 到达边界回调
     */
    private ReachBoundCallBack callBack;


    public DirectionDragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        viewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragCallBack());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        read = findViewById(R.id.read);
        unlock = findViewById(R.id.unlock);
        redPacket = findViewById(R.id.redbag);
        home = findViewById(R.id.center_circle);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mHomeCenterPoint.x = home.getLeft() + home.getMeasuredWidth() / 2;
        mHomeCenterPoint.y = home.getTop() + home.getMeasuredHeight() / 2;

        mRedPacketCenterPoint.x = redPacket.getLeft() + redPacket.getMeasuredWidth() / 2;
        mRedPacketCenterPoint.y = redPacket.getTop() + redPacket.getMeasuredHeight() / 2;

        mUnlockCenterPoint.x = unlock.getLeft() + unlock.getMeasuredWidth() / 2;
        mUnlockCenterPoint.y = unlock.getTop() + unlock.getMeasuredHeight() / 2;

        mReadCenterPoint.x = read.getLeft() + read.getMeasuredWidth() / 2;
        mReadCenterPoint.y = read.getTop() + read.getMeasuredHeight() / 2;

        mHomeOriginalPoint.x = home.getLeft();
        mHomeOriginalPoint.y = home.getTop();

        mBottomBound = mHomeCenterPoint.y - home.getMeasuredHeight() / 2;
        mLeftBound = mUnlockCenterPoint.x - home.getMeasuredWidth() / 2;
        mTopBound = mRedPacketCenterPoint.y - home.getMeasuredHeight() / 2;
        mRightBound = mReadCenterPoint.x - home.getMeasuredWidth() / 2;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        resetFlags();
        return viewDragHelper.shouldInterceptTouchEvent(ev);
    }

    private void resetFlags() {
        mIsHorizontalDrag = false;
        mIsVerticalDrag = false;
        mIsReachBound = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        viewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (viewDragHelper.continueSettling(true)) {
            invalidate();

        }
    }

    public void setCallBack(ReachBoundCallBack callBack) {
        this.callBack = callBack;
    }

    private class ViewDragCallBack extends ViewDragHelper.Callback {
        @Override
        public boolean tryCaptureView(@NonNull View view, int i) {
            return view == home;
        }


        @Override
        public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
            if (mIsHorizontalDrag) {
                return home.getTop();
            }
            if (Math.abs(dy) > 0) {
                mIsVerticalDrag = true;
            }

            final int newTop = Math.min(Math.max(mTopBound, top), mBottomBound);
            return newTop;
        }

        @Override
        public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
            if (mIsVerticalDrag) {
                return home.getLeft();
            }
            if (Math.abs(dx) > 0) {
                mIsHorizontalDrag = true;
            }
            final int newLeft = Math.min(Math.max(mLeftBound, left), mRightBound);
            return newLeft;
        }

        @Override
        public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if (releasedChild == home) {
                viewDragHelper.settleCapturedViewAt(mHomeOriginalPoint.x, mHomeOriginalPoint.y);
                invalidate();
            }
        }

        @Override
        public void onViewPositionChanged(@NonNull View changedView, int left, int top, int dx, int dy) {
            super.onViewPositionChanged(changedView, left, top, dx, dy);
            if (mIsReachBound) {
                return;
            }
            if (left <= mLeftBound) {
                mIsReachBound = true;
                if (callBack != null) {
                    callBack.reachLeftBound();
                }
            }
            if (left >= mRightBound) {
                mIsReachBound = true;
                if (callBack != null) {
                    callBack.reachRightBound();
                }
            }
            if (top <= mTopBound) {
                mIsReachBound = true;
                if (callBack != null) {
                    callBack.reachTopBound();
                }
            }
        }
    }


    public interface ReachBoundCallBack {

        void reachTopBound();

        void reachLeftBound();

        void reachRightBound();

    }
}
