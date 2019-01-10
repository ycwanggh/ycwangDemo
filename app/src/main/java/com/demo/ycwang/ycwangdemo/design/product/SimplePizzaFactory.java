package com.demo.ycwang.ycwangdemo.design.product;

public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza;
        switch (type) {
            case "1":
                break;

            case "2":
                break;

            default:
                break;
        }

        return new Pizza();
    }

}
