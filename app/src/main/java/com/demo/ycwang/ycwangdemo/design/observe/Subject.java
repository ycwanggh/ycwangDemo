package com.demo.ycwang.ycwangdemo.design.observe;

public interface Subject {

    void registerObserver(Observer observer);

    void unRegisterObserver(Observer observer);

    void notifyObserver();

}
