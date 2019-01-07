package com.demo.ycwang.ycwangdemo.design.proxy.dynamicProxy;

/**
 * @Author: ycwang
 * @Date: 2019-1-3 15:19
 */
public class TestProxyFactory {


    public static void main(String[] args) {

        IUserDao userDao = new UserDao();
        System.out.println(userDao.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(userDao).getProxyInstance();
        System.out.println(proxy.getClass());

        proxy.save();
    }
}
