package com.demo.ycwang.ycwangdemo.design.observe;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentDisplay currentDisplay = new CurrentDisplay(weatherData);

        ForceCastDisplay forceCastDisplay = new ForceCastDisplay(weatherData);

        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);


        weatherData.setMentions(100F, 10F, 1F);
        weatherData.setMentions(1000F, 100F, 10F);
        weatherData.setMentions(10000F, 1000F, 100F);

    }

}
