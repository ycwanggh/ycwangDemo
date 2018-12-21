package com.demo.ycwang.data.local.prefs.user;

import android.content.Context;

import com.demo.ycwang.data.local.prefs.utils.SPUtils;
import com.demo.ycwang.data.local.prefs.utils.Constance;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 11:10
 */
public class UserPrefsManager implements UserPrefsHelper {

    private SPUtils spUtils;

    public UserPrefsManager(Context context) {
        spUtils = SPUtils.getInstance(context, "user");
    }

    @Override
    public String getUserID() {
        return spUtils.getString(Constance.USER_ID);
    }

    @Override
    public String getUserName() {
        return spUtils.getString(Constance.USER_NAME);
    }

    @Override
    public String getUserPhone() {
        return spUtils.getString(Constance.USER_PHONE);
    }

    @Override
    public void setUserID(String id) {
        spUtils.put(Constance.USER_ID, id);
    }

    @Override
    public void setUserName(String name) {
        spUtils.put(Constance.USER_NAME, name);
    }

    @Override
    public void setUserPhone(String phone) {
        spUtils.put(Constance.USER_PHONE, phone);
    }
}
