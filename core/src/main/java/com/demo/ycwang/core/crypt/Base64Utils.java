package com.demo.ycwang.core.crypt;

import android.text.TextUtils;
import android.util.Base64;

import java.nio.charset.Charset;

/**
 * Base64工具类
 *
 * @author lijianqing
 */

public final class Base64Utils {

    private Base64Utils() {

    }

    /**
     * 标准的base64编码方式
     */
    public static String encodeDefault(final byte[] input) {
        if (input == null) {
            return null;
        } else {
            return new String(Base64.encode(input, Base64.DEFAULT), Charset.defaultCharset());
        }
    }

    /**
     * 去掉换行的base64编码方式
     */
    public static String encodeNoWrap(final byte[] input) {
        if (input == null) {
            return null;
        } else {
            return new String(Base64.encode(input, Base64.NO_WRAP), Charset.defaultCharset());
        }
    }

    /**
     * 去掉\n、去掉 = 、替换 + / 的base64编码方式
     */
    public static String encodeUrlParams(final byte[] input) {
        if (input == null) {
            return null;
        } else {
            return new String(Base64.encode(input, Base64.URL_SAFE | Base64.NO_PADDING | Base64.NO_WRAP), Charset.defaultCharset());
        }
    }

    /**
     * 标准的base64解码方式
     */
    public static byte[] decodeDefault(final String input) {
        if (TextUtils.isEmpty(input)) {
            return null;
        } else {
            return Base64.decode(input, Base64.DEFAULT);
        }
    }

    /**
     * 去掉换行的base64解码方式
     */
    public static byte[] decodeNowrap(final String input) {
        if (TextUtils.isEmpty(input)) {
            return null;
        } else {
            return Base64.decode(input, Base64.NO_WRAP);
        }
    }

    /**
     * 去掉\n、去掉 = 、替换 + / 的base64解码方式
     */
    public static byte[] decodeUrlParams(final String input) {
        if (TextUtils.isEmpty(input)) {
            return null;
        } else {
            return Base64.decode(input, Base64.URL_SAFE | Base64.NO_PADDING | Base64.NO_WRAP);
        }
    }

}
