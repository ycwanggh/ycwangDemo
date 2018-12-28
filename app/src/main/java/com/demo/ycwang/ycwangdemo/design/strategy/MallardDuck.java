package com.demo.ycwang.ycwangdemo.design.strategy;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new QuackNo();
        flyBehavior = new FlyNoWings();
    }
}
