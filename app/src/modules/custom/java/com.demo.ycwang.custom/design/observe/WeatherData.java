package com.demo.ycwang.custom.design.observe;

import java.util.ArrayList;

public class WeatherData implements Subject {

    private ArrayList<Observer> observers;
    private float temputure;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(temputure, humidity, pressure);
        }
    }

    private void mentionChanged() {
        notifyObserver();
    }

    public void setMentions(float temputure, float humidity, float pressure) {
        this.humidity = humidity;
        this.temputure = temputure;
        this.pressure = pressure;
        mentionChanged();
    }
}
