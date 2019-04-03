package com.demo.ycwang.custom.design.observe;

public interface Subject {

    void registerObserver(Observer observer);

    void unRegisterObserver(Observer observer);

    void notifyObserver();

}
