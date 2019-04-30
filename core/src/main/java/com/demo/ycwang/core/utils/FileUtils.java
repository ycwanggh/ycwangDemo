package com.demo.ycwang.core.utils;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * 文件操作工具类
 *
 * @author lijianqing
 */

public final class FileUtils {

    private FileUtils() {

    }

    /**
     * 获取指定参数表示的File对象。
     *
     * @param rootPath 文件根路径
     * @param subPath  文件追加的子路径
     * @param fileName 文件名
     * @return 参数表示的File对象
     */
    public static File getFile(final File rootPath, final String subPath, final String fileName) {
        if (rootPath == null) {
            return null;
        } else if (rootPath.isFile()) {
            return rootPath;
        } else {
            final File dir = TextUtils.isEmpty(subPath) ? rootPath : new File(rootPath, subPath);
            if (TextUtils.isEmpty(fileName)) {
                if (dir.exists()) {
                    return dir;
                } else {
                    return dir.mkdirs() ? dir : null;
                }
            } else {
                if (dir.exists()) {
                    return new File(dir, fileName);
                } else {
                    return dir.mkdirs() ? new File(dir, fileName) : null;
                }
            }
        }
    }

    /**
     * 删除File代表的路径或者文件。
     */
    public static boolean deleteFile(final File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            final File[] files = file.listFiles();
            if (files != null) {
                for (final File file1 : files) {
                    deleteFile(file1);
                }
            }
        }
        return file.delete();

    }

    /**
     * 获取给定文件的MIME类型。
     */
    public static String getFileMimeType(final File file) {
        if (file == null || !file.isFile()) {
            return null;
        } else {
            final String fileName = file.getName();
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileName.substring(fileName.lastIndexOf('.') + 1));
        }
    }

    /**
     * 当你遇到IO的时候，就想两件事，第一，我的内存是中心，第二看看流的方向
     * 只是想是内存的数据出去了就是out 外设的东西到内存了就IN了
     *
     * 将输入流的数据写入到指定文件，写入完成之后会关闭输入流。
     */
    public static boolean writeInputToDisk(final InputStream inputStream, final String savePath) {
        if (inputStream == null || TextUtils.isEmpty(savePath)) {
            return false;
        } else {
            boolean result;
            OutputStream outputStream = null;
            try {
                final File file = new File(savePath);
                file.delete();
                if (file.createNewFile()) {
                    outputStream = new FileOutputStream(file);
                    final byte[] buffer = new byte[4096];
                    while (true) {
                        final int read = inputStream.read(buffer);
                        if (read == -1) {
                            break;
                        } else {
                            outputStream.write(buffer, 0, read);
                        }
                    }
                    outputStream.flush();
                    result = true;
                } else {
                    result = false;
                }
            } catch (final IOException e) {
                result = false;
            } finally {
                try {
                    inputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (final IOException ignored) {

                }
            }
            return result;
        }
    }

    /**
     * 将字符串数据写入到指定文件。
     */
    public static boolean writeDataToDisk(final String data, final String savePath) {
        if (TextUtils.isEmpty(data) || TextUtils.isEmpty(savePath)) {
            return false;
        } else {
            boolean result;
            OutputStream outputStream = null;
            try {
                final File file = new File(savePath);
                file.delete();
                if (file.createNewFile()) {
                    outputStream = new FileOutputStream(file);
                    final byte[] dataByte = data.getBytes(Charset.defaultCharset());
                    outputStream.write(dataByte, 0, dataByte.length);
                    outputStream.flush();
                    result = true;
                } else {
                    result = false;
                }
            } catch (final IOException e) {
                result = false;
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (final IOException e) {

                }
            }
            return result;
        }
    }

    /**
     * 从指定文件读取字符串数据。
     */
    public static String readDataFromDisk(final String savePath) {
        if (TextUtils.isEmpty(savePath)) {
            return null;
        } else {
            String result;
            InputStream inputStream = null;
            try {
                final File file = new File(savePath);
                inputStream = new FileInputStream(file);
                StringBuilder builder = new StringBuilder("");
                final byte[] buffer = new byte[4096];
                while (true) {
                    final int read = inputStream.read(buffer);
                    if (read == -1) {
                        break;
                    } else {
                        builder.append(new String(buffer, 0, read, Charset.defaultCharset()));
                    }
                }
                result = builder.toString();
            } catch (final IOException e) {
                result = null;
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (final IOException e) {

                }
            }
            return result;
        }
    }

}
