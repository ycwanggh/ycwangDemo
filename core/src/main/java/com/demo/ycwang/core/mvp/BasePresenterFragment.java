package com.demo.ycwang.core.mvp;

import android.content.Context;

import com.demo.ycwang.core.view.base.BaseFragment;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 10:32
 */
public abstract class BasePresenterFragment<T extends BasePresenter> extends BaseFragment {

    protected T presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            presenter = GenericHelper.newPresenter(this);
            if (presenter != null) {
                presenter.attach();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        if (presenter != null) {
            presenter.detach();
        }
    }
}
