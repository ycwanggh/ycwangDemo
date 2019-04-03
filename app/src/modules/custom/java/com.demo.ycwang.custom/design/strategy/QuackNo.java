package com.demo.ycwang.custom.design.strategy;

public class QuackNo implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("QuackNo");
    }
}
