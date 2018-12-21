package com.demo.ycwang.data;

import android.content.Context;

import com.demo.ycwang.data.local.LocalDataUserHelper;
import com.demo.ycwang.data.local.LocalDataManager;
import com.demo.ycwang.data.local.db.entity.User;
import com.demo.ycwang.data.remote.http.RemoteDataHelper;
import com.demo.ycwang.data.remote.http.RemoteDataManager;

import java.util.List;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 10:57
 */
public class DataManager implements DataSource {
    private LocalDataUserHelper localDataHelper;
    private RemoteDataHelper remoteDataHelper;

    public DataManager(Context context) {
        this.localDataHelper = new LocalDataManager(context);
        this.remoteDataHelper = new RemoteDataManager(context);
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
    public List<User> getUsers() {
        return localDataHelper.getUsers();
    }

    @Override
    public User getUser(String id) {
        return localDataHelper.getUser(id);
    }

    @Override
    public void setUser(User user) {
        localDataHelper.setUser(user);
    }

    @Override
    public void setUsers(List<User> list) {
        localDataHelper.setUsers(list);
    }
}
