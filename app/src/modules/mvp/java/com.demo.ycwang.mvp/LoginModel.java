package com.demo.ycwang.mvp;

import com.demo.ycwang.base.App;
import com.demo.ycwang.data.remote.callback.CallBackHandler;
import com.demo.ycwang.data.remote.callback.DataCallBack;
import com.demo.ycwang.data.remote.callback.Result;
import com.demo.ycwang.data.remote.module.member.response.UserBean;
import com.demo.ycwang.mvp.base.PresenterLife;


/**
 * @Author: ycwang
 * @Date: 2018-12-25 11:32
 */
public class LoginModel implements LoginContract.Model {


    @Override
    public void catLogin(String account, String password, PresenterLife presenterLife, DataCallBack<Result<UserBean>> callback) {
        App.getDataManager().postLogin(account, password, CallBackHandler.getCallBack(presenterLife.isEnd(), callback));
    }

    @Override
    public void catRegister(String account, String password, PresenterLife presenterLife, DataCallBack<Result<UserBean>> callback) {
        App.getDataManager().postRegister(account, password, CallBackHandler.getCallBack(presenterLife.isEnd(), callback));
    }
}
