package com.demo.ycwang.data.local.prefs.device;

import android.content.Context;

import com.demo.ycwang.data.local.prefs.utils.SPUtils;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 11:10
 */
public class DevicePrefsManager implements DevicePrefsHelper {

    SPUtils spUtils;

    public DevicePrefsManager(Context context) {
        spUtils = SPUtils.getInstance(context, "device");
    }
}
