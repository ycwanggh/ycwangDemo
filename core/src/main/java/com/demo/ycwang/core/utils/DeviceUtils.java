package com.demo.ycwang.core.utils;

import android.os.Build;

import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 设备信息工具类
 *
 * @author lijianqing
 */

public final class DeviceUtils {

    private DeviceUtils() {

    }

    /**
     * 返回手机型号。
     */
    public static String getDeviceModel() {
        return Build.BRAND + " " + Build.PRODUCT;
    }

    /**
     * 返回Android版本
     */
    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 返回SDK版本
     */
    public static String getSDKVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    /**
     * 返回处理器型号。
     */
    public static String getCPUModel() {
        return Build.HARDWARE + " " + Build.BOARD;
    }

    /**
     * 返回手机版本号。
     */
    public static String getDeviceVersion() {
        return Build.DISPLAY;
    }

    /**
     * 返回安全补丁级别
     */
    public static String getSecurityPatch() {
        return Build.VERSION.SECURITY_PATCH;
    }

    /**
     * 返回手机序列号
     */
    public static String getDeviceSerial() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Build.getSerial();
        } else {
            return Build.SERIAL;
        }
    }


    /**
     * 获取mac地址
     *
     * @return
     */
    public static String getMacAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                if (!networkInterface.getName().equals("wlan0")) {
                    continue;
                }
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (hardwareAddress == null || hardwareAddress.length == 0) {
                    continue;
                }
                StringBuilder stringBuffer = new StringBuilder();
                for (byte hardwareAddres : hardwareAddress) {
                    stringBuffer.append(String.format("%02X:", hardwareAddres));
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                return stringBuffer.toString();
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }

}
