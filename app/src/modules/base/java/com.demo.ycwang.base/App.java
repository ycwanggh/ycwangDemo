package com.demo.ycwang.base;

import android.app.Application;

import com.demo.ycwang.data.DataManager;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 15:15
 */
public class App extends Application {

    private static DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        dataManager = new DataManager(this);
    }

    public static DataManager getDataManager() {
        return dataManager;
    }

}
