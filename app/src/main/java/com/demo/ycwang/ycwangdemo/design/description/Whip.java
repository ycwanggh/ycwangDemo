package com.demo.ycwang.ycwangdemo.design.description;

public class Whip extends DescriptionBeverage {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.23;
    }
}
