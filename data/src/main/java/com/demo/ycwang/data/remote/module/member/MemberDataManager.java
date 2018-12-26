package com.demo.ycwang.data.remote.module.member;

import android.content.Context;

import com.demo.ycwang.data.remote.api.API;
import com.demo.ycwang.data.remote.http.utils.HttpUtils;
import com.demo.ycwang.data.remote.response.Result;
import com.demo.ycwang.data.remote.response.UserBean;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * @Author: ycwang
 * @Date: 2018-12-26 10:25
 */
public class MemberDataManager implements MemberDataHelper {
    private API api;

    public MemberDataManager(Context context) {
        api = HttpUtils.getInstance();
    }


    @Override
    public void postLogin(String username, String password, final Callback<Result<UserBean>> callback) {
        api.postLogin(username, password).enqueue(new Callback<Result<UserBean>>() {
            @Override
            public void onResponse(Call<Result<UserBean>> call, retrofit2.Response<Result<UserBean>> response) {
                // TODO
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<Result<UserBean>> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    @Override
    public void postRegister(String username, String password, final Callback<Result<UserBean>> callback) {
        api.postRegister(username, password, password).enqueue(new Callback<Result<UserBean>>() {
            @Override
            public void onResponse(Call<Result<UserBean>> call, retrofit2.Response<Result<UserBean>> response) {
                // TODO
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<Result<UserBean>> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

}
