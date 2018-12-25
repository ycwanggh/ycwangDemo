package com.demo.ycwang.data.remote.http;

import com.demo.ycwang.data.remote.http.callback.DataCallBack;
import com.demo.ycwang.data.remote.http.response.Result;
import com.demo.ycwang.data.remote.http.response.UserBean;

import retrofit2.Callback;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 11:03
 */
public interface RemoteDataHelper {

    void postLogin(String username, String password, Callback<Result<UserBean>> callback);

    void postRegister(String username, String password, Callback<Result<UserBean>> callback);
}
