package com.demo.ycwang.data.remote;

import android.content.Context;

import com.demo.ycwang.data.local.prefs.user.UserPrefsManager;

/**
 * @Author: ycwang
 * @Date: 2018-12-26 9:22
 */
public class ModuleLocalData {

    private static UserPrefsManager userPrefsManager;

    public ModuleLocalData(Context context) {
        userPrefsManager = new UserPrefsManager(context);
    }

    public static String getUserID() {
        return userPrefsManager.getUserID();
    }


}
