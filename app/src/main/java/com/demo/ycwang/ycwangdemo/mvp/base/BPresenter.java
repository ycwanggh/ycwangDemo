package com.demo.ycwang.ycwangdemo.mvp.base;

import com.demo.ycwang.core.mvp.BaseContract;
import com.demo.ycwang.core.mvp.BasePresenter;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 11:26
 */
public class BPresenter<T extends BaseContract.View, E extends BaseContract.Model>
        extends BasePresenter<T, E>
        implements PresenterLife {

    @Override
    public boolean isEnd() {
        return view == null;
    }

}
