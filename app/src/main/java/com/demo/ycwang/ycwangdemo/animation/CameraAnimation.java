package com.demo.ycwang.ycwangdemo.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;

/**
 * @Author: ycwang
 * @Date: 2018-12-20 14:18
 */
public class CameraAnimation extends Animation {

    private int mCenterWidth;
    private int mCenterHeight;
    private Camera mCamera = new Camera();
    private int mRoteY = 45;



    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(2000);
        setFillAfter(true);
        setInterpolator(new BounceInterpolator());
        mCenterWidth = width / 2;
        mCenterHeight = height / 2;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        Matrix matrix = t.getMatrix();
        mCamera.save();
        mCamera.rotateY(mRoteY * interpolatedTime);
        mCamera.getMatrix(matrix);
        mCamera.restore();
        matrix.preTranslate(mCenterWidth, mCenterHeight);
        matrix.preTranslate(-mCenterWidth, -mCenterHeight);
    }
}
