package com.demo.ycwang.custom.design.observe.inner;

import java.util.Observable;
import java.util.Observer;

public class InnerDisplay implements Observer, Display {

    private Observable observable;
    private float aFloat;
    private float bFloat;
    private float cFloat;

    public InnerDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof InnerWeatherData) {
            InnerWeatherData innerWeatherData = (InnerWeatherData) o;
            this.aFloat = innerWeatherData.getaFloat();
            this.bFloat = innerWeatherData.getbFloat();
            this.cFloat = innerWeatherData.getcFloat();
            display(aFloat, bFloat, cFloat);
        }
    }


    @Override
    public void display(float aFloat, float bFloat, float cFloat) {
        System.out.println("aFloat:" + aFloat + "   bFloat:" + bFloat + "   cFloat:" + cFloat);
    }
}
