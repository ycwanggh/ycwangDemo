package com.demo.ycwang.ycwangdemo.design.strategy;

public class QuackNo implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("QuackNo");
    }
}
