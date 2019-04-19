package com.demo.ycwang.core.crypt;


import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: 主要功能:MD5加密 不可逆（Message Digest，消息摘要算法）
 * @Prject: CommonUtilLibrary
 * @Package: com.jingewenku.abrahamcaijin.commonutil.encryption
 * @author: AbrahamCaiJin
 * @date: 2017年05月16日 15:56
 * @Copyright: 个人版权所有
 * @Company:
 * @version: 1.0.0
 */

public class MD5Utils {

    private MD5Utils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * MD5加密
     */
    public static String encryptMD5(String input) {
        try {
            if (TextUtils.isEmpty(input)) {
                throw new IllegalArgumentException();
            } else {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(input.getBytes("UTF-8"));
                return ByteUtils.byteToHexStr(messageDigest.digest());
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 获得字符串的md5大写值
     *
     * @param str 待加密的字符串
     * @return md5加密后的大写字符串
     */
    public static String getMD5UpperString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strMD5 = encryptMD5(str);
        if (TextUtils.isEmpty(strMD5)) {
            return null;
        }
        return strMD5.toUpperCase();
    }

    /**
     * 获得文件的md5值
     *
     * @param path 文件路径
     * @return 文件的md5
     */
    public static String getFileMD5String(String path) {
        DigestInputStream dis = null;
        try {
            if (TextUtils.isEmpty(path)) {
                throw new IllegalArgumentException();
            } else {
                FileInputStream fis = new FileInputStream(path);
                MessageDigest md = MessageDigest.getInstance("MD5");
                dis = new DigestInputStream(fis, md);
                final byte[] buffer = new byte[1024];
                int read;
                do {
                    read = dis.read(buffer, 0, buffer.length);
                } while (read != -1);
                return ByteUtils.byteToHexStr(md.digest());
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | IOException e) {
            return null;
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {

            }
        }
    }

    /**
     * 获得文件md5值大写字符串
     *
     * @param path 文件对象
     * @return 文件md5大写字符串
     */
    public static String getFileMD5UpperString(String path) {
        return getFileMD5String(path).toUpperCase();
    }

    /**
     * 校验文件的md5值
     *
     * @param path 目标文件
     * @param md5  基准md5
     * @return 校验结果
     */
    public static boolean checkFileMD5(String path, String md5) {
        return getFileMD5String(path).equalsIgnoreCase(md5);
    }

    /**
     * 校验字符串的md5值
     *
     * @param str 目标字符串
     * @param md5 基准md5
     * @return 校验结果
     */
    public static boolean checkMD5(String str, String md5) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strMD5 = encryptMD5(str);
        if (TextUtils.isEmpty(strMD5)) {
            return false;
        }
        return strMD5.equalsIgnoreCase(md5);
    }

    /**
     * 获得加盐md5，算法过程是原字符串md5后连接加盐字符串后再进行md5
     *
     * @param str  待加密的字符串
     * @param salt 盐
     * @return 加盐md5
     */
    public static String getMD5AndSalt(String str, String salt) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strMD5 = encryptMD5(str);
        if (TextUtils.isEmpty(strMD5)) {
            return null;
        }
        if (TextUtils.isEmpty(salt)) {
            return strMD5;
        }
        return encryptMD5(strMD5.concat(salt));
    }


    public static void main(String[] args) {
        System.out.println(getMD5UpperString("ycwang"));

    }

}