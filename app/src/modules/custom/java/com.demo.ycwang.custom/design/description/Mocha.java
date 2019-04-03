package com.demo.ycwang.custom.design.description;

public class Mocha extends DescriptionBeverage {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.29;
    }
}
