package com.demo.ycwang.core.view.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 10:45
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Activity mActivity;
    /**
     * Activity是否已销毁
     */
    private boolean destroyed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeSetContentView();
        setContentView(getLayoutId());
        ActivityTaskManager.getInstance().addActivity(this);
        mActivity = this;
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        initData();
    }

    @Override
    protected void onDestroy() {
        destroyed = true;
        ActivityTaskManager.getInstance().removeActivity(this);
        super.onDestroy();
    }

    public boolean isActive() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            return !super.isDestroyed();
        } else {
            return !destroyed;
        }
    }

    protected abstract void initData();

    protected abstract int getLayoutId();

    public void onBeforeSetContentView() {
    }
}
