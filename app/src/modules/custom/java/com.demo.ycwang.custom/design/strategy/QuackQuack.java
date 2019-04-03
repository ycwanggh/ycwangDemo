package com.demo.ycwang.custom.design.strategy;

public class QuackQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("QuackQuack");
    }
}
