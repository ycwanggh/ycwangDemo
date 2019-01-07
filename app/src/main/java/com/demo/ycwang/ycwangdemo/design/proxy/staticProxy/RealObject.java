package com.demo.ycwang.ycwangdemo.design.proxy.staticProxy;

/**
 * @Author: ycwang
 * @Date: 2019-1-3 15:28
 */
public class RealObject implements AbstractObject {
    @Override
    public void operation() {
        System.out.println("RealObject ===>>> operation()");
    }
}
