package com.demo.ycwang.core.crypt;

import android.text.TextUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/3/15 14:52
 */
public class CryptMD5 {


    /**
     * MD5加盐
     *
     * @param string 字符串
     * @param slat   盐
     * @return
     */
    public static byte[] generateMD5(String string, String slat) {
        try {
            if (TextUtils.isEmpty(string)) {
                throw new IllegalArgumentException();
            } else {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update((slat + string).getBytes("UTF-8"));
                return messageDigest.digest();
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 对字符串多次md5加密
     *
     * @param string 字符串
     * @param times  md5次数
     * @return
     */
    public static byte[] generateMD5(String string, int times) {
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException();
        }
        byte[] md5 = generateMD5(string);
        for (int i = 0; i < times - 1; i++) {
            md5 = generateMD5(new String(md5));
        }
        return generateMD5(new String(md5));
    }


    /**
     * 生成给定字符串的MD5值
     *
     * @param input 字符串
     * @return
     */
    public static byte[] generateMD5(final String input) {
        try {
            if (TextUtils.isEmpty(input)) {
                throw new IllegalArgumentException();
            } else {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(input.getBytes("UTF-8"));
                return messageDigest.digest();
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
    }


    /**
     * 生成给定文件的MD5值
     *
     * @param path 文件路径
     * @return
     */
    public static byte[] generateFileMD5(final String path) {
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
                return md.digest();
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


}
