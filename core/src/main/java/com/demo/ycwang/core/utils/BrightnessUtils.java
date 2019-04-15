package com.demo.ycwang.core.utils;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/12 16:40
 */
public class BrightnessUtils {

    /**
     * 获取Activity屏幕亮度
     *
     * @param mActivity
     * @return
     */
    private float getActivityBrightness(Activity mActivity) {
        Window localWindow = mActivity.getWindow();
        WindowManager.LayoutParams params = localWindow.getAttributes();
        return params.screenBrightness;
    }

    /**
     * 设置Activity屏幕亮度
     *
     * @param mActivity
     * @param paramFloat [0,1]
     */
    private void setActivityBrightness(Activity mActivity, float paramFloat) {
        Window localWindow = mActivity.getWindow();
        WindowManager.LayoutParams params = localWindow.getAttributes();
        params.screenBrightness = paramFloat;
        localWindow.setAttributes(params);
    }
}
