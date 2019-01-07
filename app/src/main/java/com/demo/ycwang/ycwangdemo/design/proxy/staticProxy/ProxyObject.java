package com.demo.ycwang.ycwangdemo.design.proxy.staticProxy;

/**
 * @Author: ycwang
 * @Date: 2019-1-3 15:29
 */
public class ProxyObject implements AbstractObject {

    private AbstractObject abstractObject;

    public ProxyObject(AbstractObject abstractObject) {
        this.abstractObject = abstractObject;
    }

    @Override
    public void operation() {
        abstractObject.operation();
    }
}
