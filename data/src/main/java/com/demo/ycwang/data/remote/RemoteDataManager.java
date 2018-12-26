package com.demo.ycwang.data.remote;

import android.content.Context;

import com.demo.ycwang.data.remote.module.member.MemberDataHelper;
import com.demo.ycwang.data.remote.module.member.MemberDataManager;
import com.demo.ycwang.data.remote.callback.Result;
import com.demo.ycwang.data.remote.module.member.response.UserBean;

import retrofit2.Callback;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 15:25
 */
public class RemoteDataManager implements RemoteDataHelper {

    private MemberDataHelper memberDataHelper;

    public RemoteDataManager(Context context) {
        memberDataHelper = new MemberDataManager(context);
    }


    @Override
    public void postLogin(String username, String password, final Callback<Result<UserBean>> callback) {
        memberDataHelper.postLogin(username, password, callback);
    }

    @Override
    public void postRegister(String username, String password, final Callback<Result<UserBean>> callback) {
        memberDataHelper.postRegister(username, password, callback);
    }
}
