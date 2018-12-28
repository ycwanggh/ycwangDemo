package com.demo.ycwang.ycwangdemo.design.strategy;

public class QuackQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("QuackQuack");
    }
}
