package com.demo.ycwang.ycwangdemo.design.strategy;

public class Duck {

    protected QuackBehavior quackBehavior;
    protected FlyBehavior flyBehavior;

    public void swim() {
        System.out.println("Duck:swim");
    }

    public void eat() {
        System.out.println("Duck:eat");
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

}
