package com.demo.ycwang.ycwangdemo.design.observe;

public class CurrentDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject subject;

    public CurrentDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("CurrentDisplay temperature: " + temperature
                + "    CurrentDisplay humidity: " + humidity);
    }


    @Override
    public void update(float temputure, float humidity, float pressure) {
        this.temperature = temputure;
        this.humidity = humidity;
        display();
    }
}
