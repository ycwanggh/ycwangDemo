package com.demo.ycwang.mvp;


import com.demo.ycwang.core.mvp.BaseContract;
import com.demo.ycwang.data.remote.callback.DataCallBack;
import com.demo.ycwang.data.remote.callback.Result;
import com.demo.ycwang.data.remote.module.member.response.UserBean;
import com.demo.ycwang.ycwangdemo.mvp.base.PresenterLife;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 11:30
 */
public interface LoginContract {

    interface View extends BaseContract.View {
        void displayProgress();

        void dismissProgress();

        void switchToLogin();

        void switchToRegister();

        void loginSuccess();

        boolean isLoginPage();
    }


    interface Presenter extends BaseContract.Presenter {
        void requestLogin(String account, String password);

        void requestRegister(String account, String password);
    }


    interface Model extends BaseContract.Model {
        void catLogin(String account, String password, PresenterLife presenterLife, DataCallBack<Result<UserBean>> callback);

        void catRegister(String account, String password, PresenterLife presenterLife, DataCallBack<Result<UserBean>> callback);
    }
}
