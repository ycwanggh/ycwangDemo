package com.demo.ycwang.core.mvp;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 10:21
 */
public class BasePresenter<T extends BaseContract.View, E extends BaseContract.Model> {

    protected T view;
    protected E model;

    public void init(Object view, Object model) {
        this.view = (T) view;
        this.model = (E) model;
    }

    public void attach() {
    }

    public void detach() {
        view = null;
        model = null;
    }

}
