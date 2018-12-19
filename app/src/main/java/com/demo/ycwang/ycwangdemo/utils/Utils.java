package com.demo.ycwang.ycwangdemo.utils;

import android.content.Context;
import android.view.View;

/**
 * @Author: ycwang
 * @Date: 2018-12-18 14:31
 */
public class Utils {

    private static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float dpToPx(Context context, float px) {
        return (px * getDensity(context) + 0.5f);
    }

    /**
     * 获取View的高度
     * @param v
     * @return
     */
    public static int getViewHeight(View v) {
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        v.measure(w, h);
        int height = v.getMeasuredHeight();
        return height;
    }
}
