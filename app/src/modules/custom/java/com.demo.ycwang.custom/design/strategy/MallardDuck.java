package com.demo.ycwang.custom.design.strategy;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new QuackNo();
        flyBehavior = new FlyNoWings();
    }
}
