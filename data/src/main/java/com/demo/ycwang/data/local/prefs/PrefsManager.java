package com.demo.ycwang.data.local.prefs;

import android.content.Context;

import com.demo.ycwang.data.local.prefs.device.DevicePrefsHelper;
import com.demo.ycwang.data.local.prefs.device.DevicePrefsManager;
import com.demo.ycwang.data.local.prefs.user.UserPrefsHelper;
import com.demo.ycwang.data.local.prefs.user.UserPrefsManager;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 11:04
 */
public class PrefsManager implements PrefsHelper {
    private UserPrefsHelper userHelper;
    private DevicePrefsHelper deviceHelper;

    public PrefsManager(Context context) {
        this.userHelper = new UserPrefsManager(context);
        this.deviceHelper = new DevicePrefsManager(context);
    }

    @Override
    public String getUserID() {
        return userHelper.getUserID();
    }

    @Override
    public String getUserName() {
        return userHelper.getUserName();
    }

    @Override
    public String getUserPhone() {
        return userHelper.getUserPhone();
    }

    @Override
    public void setUserID(String id) {
        userHelper.setUserID(id);
    }

    @Override
    public void setUserName(String name) {
        userHelper.setUserName(name);
    }

    @Override
    public void setUserPhone(String phone) {
        userHelper.setUserPhone(phone);
    }
}
