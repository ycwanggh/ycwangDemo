package com.demo.ycwang.data.local.db.user;

import com.demo.ycwang.data.local.db.entity.User;

import java.util.List;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 11:03
 */
public interface DBUserHelper {


    List<User> getUsers();

    User getUser(String id);

    void setUser(User user);

    void setUsers(List<User> list);


}
