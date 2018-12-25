package com.demo.ycwang.ycwangdemo.mvp;

import com.demo.ycwang.ycwangdemo.mvp.base.BPresenter;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 11:31
 */
public class LoginPresenter extends BPresenter<LoginContract.View, LoginModel> implements LoginContract.Presenter {


    @Override
    public void requestLogin(String account, String password) {

        view.displayProgress();
        model.catLogin(account, password, this);


    }

    @Override
    public void requestRegister(String account, String password) {

        view.dismissProgress();
        model.catRegister(account, password, this);

    }
}
