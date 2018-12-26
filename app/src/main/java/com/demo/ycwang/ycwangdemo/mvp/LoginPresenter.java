package com.demo.ycwang.ycwangdemo.mvp;

import com.demo.ycwang.data.remote.callback.DataCallBack;
import com.demo.ycwang.data.remote.response.Result;
import com.demo.ycwang.data.remote.response.UserBean;
import com.demo.ycwang.ycwangdemo.mvp.base.BPresenter;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 11:31
 */
public class LoginPresenter extends BPresenter<LoginContract.View, LoginModel> implements LoginContract.Presenter {


    @Override
    public void requestLogin(String account, String password) {

        view.displayProgress();
        model.catLogin(account, password, this, new DataCallBack<Result<UserBean>>() {
            @Override
            public void finish() {
                view.dismissProgress();
            }

            @Override
            public void success(Result<UserBean> data) {
                view.loginSuccess();

            }

            @Override
            public void error(int code, String message) {

            }
        });
    }

    @Override
    public void requestRegister(String account, String password) {

        view.displayProgress();
        model.catRegister(account, password, this, new DataCallBack<Result<UserBean>>() {
            @Override
            public void finish() {
                view.dismissProgress();
            }

            @Override
            public void success(Result<UserBean> data) {
                view.switchToLogin();
            }

            @Override
            public void error(int code, String message) {

            }
        });

    }
}
