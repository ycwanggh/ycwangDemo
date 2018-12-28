package com.demo.ycwang.ycwangdemo.design.description;

public abstract class Beverage {

    protected String description = "Unknow Type";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
