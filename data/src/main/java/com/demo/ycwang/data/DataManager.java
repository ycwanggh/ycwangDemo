package com.demo.ycwang.data;

import android.content.Context;

import com.demo.ycwang.data.local.LocalDataHelper;
import com.demo.ycwang.data.local.LocalDataManager;
import com.demo.ycwang.data.local.db.entity.User;
import com.demo.ycwang.data.remote.http.RemoteDataHelper;
import com.demo.ycwang.data.remote.http.RemoteDataManager;
import com.demo.ycwang.data.remote.http.response.Result;
import com.demo.ycwang.data.remote.http.response.UserBean;

import java.util.List;

import retrofit2.Callback;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 10:57
 */
public class DataManager implements LocalDataHelper, RemoteDataHelper {
    private LocalDataHelper localDataHelper;
    private RemoteDataHelper remoteDataHelper;

    public DataManager(Context context) {
        this.localDataHelper = new LocalDataManager(context);
        this.remoteDataHelper = RemoteDataManager.getInstance();
    }

    @Override
    public String getUserID() {
        return localDataHelper.getUserID();
    }

    @Override
    public String getUserName() {
        return localDataHelper.getUserName();
    }

    @Override
    public String getUserPhone() {
        return localDataHelper.getUserPhone();
    }

    @Override
    public String getRequestCookie() {
        return localDataHelper.getRequestCookie();
    }

    @Override
    public void setUserID(String id) {
        localDataHelper.setUserID(id);
    }

    @Override
    public void setUserName(String name) {
        localDataHelper.setUserName(name);
    }

    @Override
    public void setUserPhone(String phone) {
        localDataHelper.setUserPhone(phone);
    }

    @Override
    public void setRequestCookie(String cookie) {
        localDataHelper.setRequestCookie(cookie);
    }


    @Override
    public List<User> queryAll() {
        return localDataHelper.queryAll();
    }

    @Override
    public User query(String id) {
        return localDataHelper.query(id);
    }

    @Override
    public void insert(User user) {
        localDataHelper.insert(user);
    }

    @Override
    public void insertAll(List<User> list) {
        localDataHelper.insertAll(list);
    }

    @Override
    public void update(User user) {
        localDataHelper.update(user);
    }

    @Override
    public void postLogin(String username, String password, Callback<Result<UserBean>> callback) {
        remoteDataHelper.postLogin(username, password, callback);
    }

    @Override
    public void postRegister(String username, String password, Callback<Result<UserBean>> callback) {
        remoteDataHelper.postRegister(username, password, callback);
    }
}
