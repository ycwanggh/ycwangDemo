package com.demo.ycwang.ycwangdemo.design.observe.inner;

import java.util.Observable;

public class InnerWeatherData extends Observable {

    private float aFloat;
    private float bFloat;
    private float cFloat;

    public InnerWeatherData() {
    }

    public float getaFloat() {
        return aFloat;
    }

    public float getbFloat() {
        return bFloat;
    }

    public float getcFloat() {
        return cFloat;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    public void setbFloat(float bFloat) {
        this.bFloat = bFloat;
    }

    public void setcFloat(float cFloat) {
        this.cFloat = cFloat;
    }

    public void setMention(float aFloat, float bFloat, float cFloat) {
        this.aFloat = aFloat;
        this.bFloat = bFloat;
        this.cFloat = cFloat;
        mentionNotify();

    }

    public void mentionNotify() {
        setChanged();
        notifyObservers();
    }
}
