package com.demo.ycwang.data.local.prefs.user;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 11:05
 */
public interface UserPrefsHelper {

    String getUserID();

    String getUserName();

    String getUserPhone();

    void setUserID(String id);

    void setUserName(String name);

    void setUserPhone(String phone);

}
