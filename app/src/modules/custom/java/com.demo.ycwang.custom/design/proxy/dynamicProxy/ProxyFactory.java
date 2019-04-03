package com.demo.ycwang.custom.design.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: ycwang
 * @Date: 2019-1-3 15:16
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }


    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Begin Transaction");
                        Object returnValue = method.invoke(target, args);
                        System.out.println("Commit Transaction");
                        return returnValue;
                    }
                });
    }

}
