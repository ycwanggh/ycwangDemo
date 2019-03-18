package com.demo.ycwang.ycwangdemo.crypt;

import android.text.TextUtils;

/**
 * 字节数组处理类
 *
 * @author lijianqing
 */

public final class ByteUtils {

    private ByteUtils() {

    }

    /**
     * 将字节数组转换为16进制字符串。
     */
    public static String byteToHexStr(final byte[] input) {
        if (input == null) {
            throw null;
        } else {
            StringBuilder result = new StringBuilder("");
            for (byte b : input) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    result.append('0').append(hex);
                } else {
                    result.append(hex);
                }
            }
            return result.toString();
        }
    }

    /**
     * 将16进制字符串转换为字节数组。
     */
    public static byte[] hexStrToByte(final String input) {
        if (TextUtils.isEmpty(input) || input.length() % 2 == 1) {
            throw null;
        } else {
            final int length = input.length() / 2;
            byte[] result = new byte[length];
            for (int i = 0; i < length; i++) {
                String hex = input.substring(i * 2, i * 2 + 2);
                result[i] = (byte) Integer.parseInt(hex, 16);
            }
            return result;
        }
    }

}
