package com.demo.ycwang.ycwangdemo.recylerview;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author ycwang.
 * @date 2017/12/14.
 * // RecyclerViewItem 点击事件
 */

public abstract class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    // 手势探测器
    private GestureDetectorCompat gestureDetectorCompat;
    private RecyclerView recyclerView;

    public OnRecyclerItemClickListener(RecyclerView recyclerView) {
        this.gestureDetectorCompat = new GestureDetectorCompat(recyclerView.getContext(), new ItemTouchHelperGestureListener());
        this.recyclerView = recyclerView;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        gestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        gestureDetectorCompat.onTouchEvent(e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }


    public abstract void onItemClick(RecyclerView.ViewHolder viewHolder);

    public void onItemLongClick(RecyclerView.ViewHolder viewHolder) {
        // Item 长点击事件
    }

    class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View childUnder = recyclerView.findChildViewUnder(e.getX(), e.getY());
            if (childUnder != null) {
                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childUnder);
                onItemClick(childViewHolder);
            }
            return true;
        }


        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
            View childUnder = recyclerView.findChildViewUnder(e.getX(), e.getY());
            if (childUnder != null) {
                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childUnder);
                onItemLongClick(childViewHolder);
            }
        }
    }
}