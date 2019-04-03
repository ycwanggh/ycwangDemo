package com.demo.ycwang.ycwangdemo.crypt;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * //        List<Person> personList = new ArrayList<>();
 * //        int testMaxCount = 100;
 * //        for (int i = 0; i < testMaxCount; i++) {
 * //            Person person = new Person();
 * //            person.setAge(i);
 * //            person.setName(String.valueOf(i));
 * //            personList.add(person);
 * //        }
 * //
 * //        StringBuffer stringBuffer = new StringBuffer();
 * //        for (Person person : personList) {
 * //            stringBuffer.append("===");
 * //            stringBuffer.append(person.toString());
 * //        }
 * //        stringBuffer.append("===");
 * //        System.out.println("加密前json数据 ---->" + stringBuffer.toString());
 * //        System.out.println("加密前json数据长度 ----> + stringBuffer.toString().length()");
 * //
 * //
 * //        KeyPair keyPair = CryptRSA.generateRSAKeyPair(CryptRSA.KEY_LENGTH);
 * //        // 公钥
 * //        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
 * //        // 私钥
 * //        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
 * <p>
 * //        //公钥加密
 * //        long start = System.currentTimeMillis();
 * //        byte[] encryptBytes = CryptRSA.encryptByPublicKeyForSpilt(stringBuffer.toString().getBytes(), publicKey.getEncoded());
 * //        long end = System.currentTimeMillis();
 * //        System.out.println("公钥加密耗时 cost time---->" + (end - start));
 * //        String encryStr = Base64Utils.encodeDefault(encryptBytes);
 * //        System.out.println("加密后json数据 --1-->" + encryStr);
 * //        System.out.println("加密后json数据长度 --1-->" + encryStr.length());
 * //
 * //        //私钥解密
 * //        start = System.currentTimeMillis();
 * //        byte[] decryptBytes = CryptRSA.decryptByPrivateKeyForSpilt(Base64Utils.decodeDefault(encryStr), privateKey.getEncoded());
 * //        String decryStr = new String(decryptBytes);
 * //        end = System.currentTimeMillis();
 * //        System.out.println("私钥解密耗时 cost time---->" + (end - start));
 * //        System.out.println("解密后json数据 --1-->" + decryStr);
 * <p>
 * //        //私钥加密
 * //        long start = System.currentTimeMillis();
 * //        byte[] encryptBytes = CryptRSA.encryptByPrivateKeyForSpilt(stringBuffer.toString().getBytes(), privateKey.getEncoded());
 * //        long end = System.currentTimeMillis();
 * //        Log.e("MainActivity", "私钥加密密耗时 cost time---->" + (end - start));
 * //        String encryStr = Base64Utils.encodeDefault(encryptBytes);
 * //        Log.e("MainActivity", "加密后json数据 --2-->" + encryStr);
 * //        Log.e("MainActivity", "加密后json数据长度 --2-->" + encryStr.length());
 * //        //公钥解密
 * //        start = System.currentTimeMillis();
 * //        byte[] decryptBytes = CryptRSA.decryptByPublicKeyForSpilt(Base64Utils.decodeDefault(encryStr), publicKey.getEncoded());
 * //        String decryStr = new String(decryptBytes);
 * //        end = System.currentTimeMillis();
 * //        Log.e("MainActivity", "公钥解密耗时 cost time---->" + (end - start));
 * //        Log.e("MainActivity", "解密后json数据 --2-->" + decryStr);
 */
/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/3/15 10:02
 */
public class CryptRSA {

    public static final int KEY_LENGTH = 1024;
    public static final int DEFAULT_BUFFER_SIZE = KEY_LENGTH / 8 - 11;
    public static final byte[] DEFAULT_SPLIT = "#PART#".getBytes();

    /**
     * 随机生成RSA密钥对
     *
     * @param keyLength 密钥长度 512-2048
     *                  一般为 1024
     * @return
     */
    public static KeyPair generateRSAKeyPair(int keyLength) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(keyLength);
            return keyPairGenerator.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 用公钥对字符串进行加密
     *
     * @param data      原文
     * @param publicKey
     * @return
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) {
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey1 = keyFactory.generatePublic(keySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey1);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 用私钥对字符串进行加密
     *
     * @param data       原文
     * @param privateKey
     * @return
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] privateKey) {
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey1 = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey1);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 用公钥对字符串解密
     *
     * @param data      原文
     * @param publicKey
     * @return
     */
    public static byte[] decryptByPublicKey(byte[] data, byte[] publicKey) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey1 = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, publicKey1);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 使用私钥进行解密
     */
    public static byte[] decryptByPrivateKey(byte[] encrypted, byte[] privateKey) {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PrivateKey keyPrivate = kf.generatePrivate(keySpec);
            Cipher cp = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cp.init(Cipher.DECRYPT_MODE, keyPrivate);
            return cp.doFinal(encrypted);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 用公钥对字符串进行分段加密
     *
     * @param data      要加密的原始数据
     * @param publicKey 公钥
     * @return
     */
    public static byte[] encryptByPublicKeyForSpilt(byte[] data, byte[] publicKey) {
        int dataLen = data.length;
        if (dataLen <= DEFAULT_BUFFER_SIZE) {
            return encryptByPublicKey(data, publicKey);
        }
        List<Byte> allBytes = new ArrayList<>(2048);
        int bufIndex = 0;
        int subDataLoop = 0;
        byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
        for (int i = 0; i < dataLen; i++) {
            buf[bufIndex] = data[i];
            if (++bufIndex == DEFAULT_BUFFER_SIZE || i == dataLen - 1) {
                subDataLoop++;
                if (subDataLoop != 1) {
                    for (byte b : DEFAULT_SPLIT) {
                        allBytes.add(b);
                    }
                }
                byte[] encryptBytes = encryptByPublicKey(buf, publicKey);
                for (byte b : encryptBytes) {
                    allBytes.add(b);
                }
                bufIndex = 0;
                if (i == dataLen - 1) {
                    buf = null;
                } else {
                    buf = new byte[Math.min(DEFAULT_BUFFER_SIZE, dataLen - i - 1)];
                }
            }
        }
        byte[] bytes = new byte[allBytes.size()];
        {
            int i = 0;
            for (Byte b : allBytes) {
                bytes[i++] = b.byteValue();
            }
        }
        return bytes;
    }


    /**
     * 分段加密
     *
     * @param data       要加密的原始数据
     * @param privateKey 秘钥
     */
    public static byte[] encryptByPrivateKeyForSpilt(byte[] data, byte[] privateKey) {
        int dataLen = data.length;
        if (dataLen <= DEFAULT_BUFFER_SIZE) {
            return encryptByPrivateKey(data, privateKey);
        }
        List<Byte> allBytes = new ArrayList<>(2048);
        int bufIndex = 0;
        int subDataLoop = 0;
        byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
        for (int i = 0; i < dataLen; i++) {
            buf[bufIndex] = data[i];
            if (++bufIndex == DEFAULT_BUFFER_SIZE || i == dataLen - 1) {
                subDataLoop++;
                if (subDataLoop != 1) {
                    for (byte b : DEFAULT_SPLIT) {
                        allBytes.add(b);
                    }
                }
                byte[] encryptBytes = encryptByPrivateKey(buf, privateKey);
                for (byte b : encryptBytes) {
                    allBytes.add(b);
                }
                bufIndex = 0;
                if (i == dataLen - 1) {
                    buf = null;
                } else {
                    buf = new byte[Math.min(DEFAULT_BUFFER_SIZE, dataLen - i - 1)];
                }
            }
        }
        byte[] bytes = new byte[allBytes.size()];
        {
            int i = 0;
            for (Byte b : allBytes) {
                bytes[i++] = b.byteValue();
            }
        }
        return bytes;
    }


    /**
     * 公钥分段解密
     *
     * @param encrypted 待解密数据
     * @param publicKey 密钥
     */
    public static byte[] decryptByPublicKeyForSpilt(byte[] encrypted, byte[] publicKey) {
        int splitLen = DEFAULT_SPLIT.length;
        if (splitLen <= 0) {
            return decryptByPublicKey(encrypted, publicKey);
        }
        int dataLen = encrypted.length;
        List<Byte> allBytes = new ArrayList<>(1024);
        int latestStartIndex = 0;
        for (int i = 0; i < dataLen; i++) {
            byte bt = encrypted[i];
            boolean isMatchSplit = false;
            if (i == dataLen - 1) {
                byte[] part = new byte[dataLen - latestStartIndex];
                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
                byte[] decryptPart = decryptByPublicKey(part, publicKey);
                for (byte b : decryptPart) {
                    allBytes.add(b);
                }
                latestStartIndex = i + splitLen;
                i = latestStartIndex - 1;
            } else if (bt == DEFAULT_SPLIT[0]) {
                if (splitLen > 1) {
                    if (i + splitLen < dataLen) {
                        for (int j = 1; j < splitLen; j++) {
                            if (DEFAULT_SPLIT[j] != encrypted[i + j]) {
                                break;
                            }
                            if (j == splitLen - 1) {
                                isMatchSplit = true;
                            }
                        }
                    }
                } else {
                    isMatchSplit = true;
                }
            }
            if (isMatchSplit) {
                byte[] part = new byte[i - latestStartIndex];
                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
                byte[] decryptPart = decryptByPublicKey(part, publicKey);
                for (byte b : decryptPart) {
                    allBytes.add(b);
                }
                latestStartIndex = i + splitLen;
                i = latestStartIndex - 1;
            }
        }
        byte[] bytes = new byte[allBytes.size()];
        {
            int i = 0;
            for (Byte b : allBytes) {
                bytes[i++] = b.byteValue();
            }
        }
        return bytes;
    }


    /**
     * 使用私钥分段解密
     *
     * @param encrypted  待解密数据
     * @param privateKey 密钥
     * @return
     */
    public static byte[] decryptByPrivateKeyForSpilt(byte[] encrypted, byte[] privateKey) {
        int splitLen = DEFAULT_SPLIT.length;
        if (splitLen <= 0) {
            return decryptByPrivateKey(encrypted, privateKey);
        }
        int dataLen = encrypted.length;
        List<Byte> allBytes = new ArrayList<>(1024);
        int latestStartIndex = 0;
        for (int i = 0; i < dataLen; i++) {
            byte bt = encrypted[i];
            boolean isMatchSplit = false;
            if (i == dataLen - 1) {
                byte[] part = new byte[dataLen - latestStartIndex];
                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
                byte[] decryptPart = decryptByPrivateKey(part, privateKey);
                for (byte b : decryptPart) {
                    allBytes.add(b);
                }
                latestStartIndex = i + splitLen;
                i = latestStartIndex - 1;
            } else if (bt == DEFAULT_SPLIT[0]) {
                if (splitLen > 1) {
                    if (i + splitLen < dataLen) {
                        for (int j = 1; j < splitLen; j++) {
                            if (DEFAULT_SPLIT[j] != encrypted[i + j]) {
                                break;
                            }
                            if (j == splitLen - 1) {
                                isMatchSplit = true;
                            }
                        }
                    }
                } else {
                    isMatchSplit = true;
                }
            }
            if (isMatchSplit) {
                byte[] part = new byte[i - latestStartIndex];
                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
                byte[] decryptPart = decryptByPrivateKey(part, privateKey);
                for (byte b : decryptPart) {
                    allBytes.add(b);
                }
                latestStartIndex = i + splitLen;
                i = latestStartIndex - 1;
            }
        }
        byte[] bytes = new byte[allBytes.size()];
        {
            int i = 0;
            for (Byte b : allBytes) {
                bytes[i++] = b.byteValue();
            }
        }
        return bytes;
    }

}
