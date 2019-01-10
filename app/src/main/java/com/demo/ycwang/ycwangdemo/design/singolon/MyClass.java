package com.demo.ycwang.ycwangdemo.design.singolon;

public class MyClass {

    private static volatile MyClass myClass;

    public static MyClass getInstance() {
        if (myClass == null) {
            // 只有第一次才彻底执行这里的代码
            synchronized (MyClass.class) {
                if (myClass == null) {
                    myClass = new MyClass();
                }
            }
        }
        return myClass;
    }

}
