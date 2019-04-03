package com.demo.ycwang.custom.design.proxy.dynamicProxy;

/**
 * @Author: ycwang
 * @Date: 2019-1-3 15:16
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("UserDao ====>>>>>> save()");
    }
}
