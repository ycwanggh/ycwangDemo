package com.demo.ycwang.data.remote.module.member;

import com.demo.ycwang.data.remote.response.Result;
import com.demo.ycwang.data.remote.response.UserBean;

import retrofit2.Callback;

/**
 * @Author: ycwang
 * @Date: 2018-12-26 10:26
 */
public interface MemberDataHelper {

    void postLogin(String username, String password, Callback<Result<UserBean>> callback);

    void postRegister(String username, String password, Callback<Result<UserBean>> callback);

}
