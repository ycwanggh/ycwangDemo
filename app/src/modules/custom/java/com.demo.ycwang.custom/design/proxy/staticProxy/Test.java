package com.demo.ycwang.custom.design.proxy.staticProxy;

/**
 * @Author: ycwang
 * @Date: 2019-1-3 15:30
 */
public class Test {

    public static void main(String[] args) {
        ProxyObject proxyObject = new ProxyObject(new RealObject());
        proxyObject.operation();
    }

}
