package com.demo.ycwang.ycwangdemo.design.strategy;

public class FlyNoWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("FlyNoWings");
    }
}
