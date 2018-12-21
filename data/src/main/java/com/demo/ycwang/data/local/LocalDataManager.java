package com.demo.ycwang.data.local;

import android.content.Context;

import com.demo.ycwang.data.local.db.user.DBUserHelper;
import com.demo.ycwang.data.local.db.user.DBUserManager;
import com.demo.ycwang.data.local.db.entity.User;
import com.demo.ycwang.data.local.prefs.PrefsHelper;
import com.demo.ycwang.data.local.prefs.PrefsManager;

import java.util.List;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 11:30
 */
public class LocalDataManager implements LocalDataHelper {

    private PrefsHelper prefsHelper;
    private DBUserHelper dbHelper;

    public LocalDataManager(Context context) {
        prefsHelper = new PrefsManager(context);
        dbHelper = new DBUserManager(context);
    }

    @Override
    public String getUserID() {
        return prefsHelper.getUserID();
    }

    @Override
    public String getUserName() {
        return prefsHelper.getUserName();
    }

    @Override
    public String getUserPhone() {
        return prefsHelper.getUserPhone();
    }

    @Override
    public void setUserID(String id) {
        prefsHelper.setUserID(id);
    }

    @Override
    public void setUserName(String name) {
        prefsHelper.setUserName(name);
    }

    @Override
    public void setUserPhone(String phone) {
        prefsHelper.setUserPhone(phone);
    }


    @Override
    public List<User> queryAll() {
        return dbHelper.queryAll();
    }

    @Override
    public User query(String id) {
        return dbHelper.query(id);
    }

    @Override
    public void insert(User user) {
        dbHelper.insert(user);
    }

    @Override
    public void insertAll(List<User> list) {
        dbHelper.insertAll(list);
    }

    @Override
    public void update(User user) {
        dbHelper.update(user);
    }
}
