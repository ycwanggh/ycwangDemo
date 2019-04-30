package com.demo.ycwang.core.mvp;

import android.os.Bundle;

import com.demo.ycwang.core.view.base.BaseActivity;

import androidx.annotation.Nullable;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 10:25
 */
public abstract class BasePresenterActivity<T extends BasePresenter> extends BaseActivity {

    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            presenter = GenericHelper.newPresenter(this);
            if (presenter != null) {
                presenter.attach();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
    }

}
