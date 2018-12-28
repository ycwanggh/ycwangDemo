package com.demo.ycwang.ycwangdemo.design.observe;

public class StatisticsDisplay implements DisplayElement,Observer {

    private float temputure;
    private float pressure;
    private Subject subject;

    public StatisticsDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("StatisticsDisplay temputure: " + temputure
                + "    StatisticsDisplay pressure: " + pressure);

    }


    @Override
    public void update(float temputure, float humidity, float pressure) {
        this.pressure=pressure;
        this.temputure=temputure;
        display();
    }
}
