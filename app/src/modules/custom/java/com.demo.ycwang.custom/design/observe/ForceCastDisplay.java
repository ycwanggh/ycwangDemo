package com.demo.ycwang.custom.design.observe;

public class ForceCastDisplay implements DisplayElement, Observer {

    private float humidity;
    private float pressure;
    private Subject subject;

    public ForceCastDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("ForceCastDisplay pressure: " + pressure
                + "    ForceCastDisplay humidity: " + humidity);

    }


    @Override
    public void update(float temputure, float humidity, float pressure) {
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
