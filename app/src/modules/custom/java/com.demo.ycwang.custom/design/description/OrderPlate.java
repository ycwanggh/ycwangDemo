package com.demo.ycwang.custom.design.description;

public class OrderPlate {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println("Espresso: cost" + beverage.cost() + "Espresso:description" + beverage.getDescription());

        // 加一份魔卡
        beverage = new Mocha(beverage);
        System.out.println("Espresso:Mocha:cost" + beverage.cost() +
                "Espresso:Mocha:description" + beverage.getDescription());

        // 再加一份魔卡
        beverage = new Mocha(beverage);
        System.out.println("Espresso:Mocha:Mocha:cost" + beverage.cost() +
                "Espresso:Mocha:Mocha:description" + beverage.getDescription());

        // 再加一份Whis
        beverage = new Whip(beverage);
        System.out.println("Espresso:Mocha:Mocha:Whip:cost" + beverage.cost() +
                "Espresso:Mocha:Mocha:Whip:description" + beverage.getDescription());

    }

}
