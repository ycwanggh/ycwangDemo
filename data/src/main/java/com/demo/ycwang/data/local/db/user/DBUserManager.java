package com.demo.ycwang.data.local.db.user;

import android.content.Context;

import com.demo.ycwang.data.local.db.dao.GreenDaoManager;
import com.demo.ycwang.data.local.db.entity.User;

import java.util.List;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 11:03
 */
public class DBUserManager implements DBUserHelper {

    private GreenDaoManager greenDaoManager;

    public DBUserManager(Context context) {
        greenDaoManager = new GreenDaoManager(context);
    }


    @Override
    public List<User> queryAll() {
        return greenDaoManager.queryAll(User.class);
    }

    @Override
    public User query(String id) {
        return greenDaoManager.queryByKey(User.class, id);
    }

    @Override
    public void insert(User user) {
        greenDaoManager.insert(user);
    }

    @Override
    public void insertAll(List<User> list) {
        greenDaoManager.insert(list);
    }

    @Override
    public void update(User user) {
        greenDaoManager.insertOrUpdate(user);
    }
}
