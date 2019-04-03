package com.demo.ycwang.custom.design.observe.inner;

public class InnerWeatherStation {

    public static void main(String[] args) {

        InnerWeatherData innerWeatherData = new InnerWeatherData();
        InnerDisplay innerDisplay = new InnerDisplay(innerWeatherData);
//        innerDisplay.update(innerWeatherData, null);


        innerWeatherData.setMention(2, 3, 4);
        innerWeatherData.setMention(5, 6, 7);
        innerWeatherData.setMention(8, 9, 0);

    }

}
