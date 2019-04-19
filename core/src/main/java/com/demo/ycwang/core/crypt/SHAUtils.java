package com.demo.ycwang.core.crypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: 主要功能:SHA-1 加密 不可逆（Secure Hash Algorithm，安全散列算法）
 * @Prject: CommonUtilLibrary
 * @Package: com.jingewenku.abrahamcaijin.commonutil.encryption
 * @author: AbrahamCaiJin
 * @date: 2017年05月16日 15:57
 * @Copyright: 个人版权所有
 * @Company:
 * @version: 1.0.0
 */

public class SHAUtils {

    private SHAUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * SHA-512 加密
     *
     * @param data
     * @return
     */
    public static String encryptSHA(byte[] data) {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA-512");
            sha.update(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] resultBytes = sha.digest();
        return ByteUtils.byteToHexStr(resultBytes);
    }


    public static void main(String[] args){
        System.out.println(encryptSHA("ycwang".getBytes()));
    }

}