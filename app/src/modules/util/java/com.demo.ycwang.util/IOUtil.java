package com.demo.ycwang.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/29 10:29
 */
public class IOUtil {


    // Out 从内存向其他地方输出
    // in 从其他地方向内存写入
    public static void main(String[] args) {
        writeDataToDisk();
//        readDataFromDisk();

//        copyData();
//        readDataFromDisk();


        bufferOut();
        bufferIn();

    }


    public static void copyData() {
        FileOutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            outputStream = new FileOutputStream("b.txt");
            inputStream = new FileInputStream("a.txt");
            byte[] bytes = new byte[10];
            while (true) {
                int len = inputStream.read(bytes);
                if (len == -1) {
                    break;
                } else {
                    outputStream.write(bytes, 0, len);
                }
            }
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readDataFromDisk() {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("b.txt");
            byte[] b = new byte[1024];
            while (true) {
                int l = inputStream.read(b);
                if (l == -1) {
                    break;
                }
                System.out.println(new String(b, 0, l));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writeDataToDisk() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("a.txt");
            outputStream.write(("ycwang hello my name is ycwang.").getBytes());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void bufferOut() {
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("a.txt"));
            outputStream.write("hello world ycwang".getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bufferIn() {
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("a.txt"));
            byte[] bytes = new byte[1024];
            while (true) {
                int len = inputStream.read(bytes);
                if (len == -1) {
                    break;
                } else {
                    System.out.println(new String(bytes, 0, len));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
