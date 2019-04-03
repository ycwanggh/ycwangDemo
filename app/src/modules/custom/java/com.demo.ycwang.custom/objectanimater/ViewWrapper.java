package com.demo.ycwang.custom.objectanimater;

import android.view.View;

/**
 * @Author: ycwang
 * @Date: 2018-12-19 14:59
 *
 * <p>
 * ViewWrapper wrapper = new ViewWrapper(btn);
 * ObjectAnimator animator = ObjectAnimator.ofInt(wrapper, "width", 500).setDuration(500).start();
 * <p>
 */
public class ViewWrapper {

    private View view;

    public ViewWrapper(View view) {
        this.view = view;
    }

    public void setWidth(int width) {
        view.getLayoutParams().width = width;
        view.requestLayout();
    }

    public int getWidth() {
        return view.getLayoutParams().width;
    }

}
