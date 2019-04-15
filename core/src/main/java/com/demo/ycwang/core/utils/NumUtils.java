package com.demo.ycwang.core.utils;

import android.text.TextUtils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * DecimalFormat format 方法
 * eg:
 * 1：new DecimalFormat(“00.000”).format(pi) //结果：03.142
 * 2：new DecimalFormat(“##.###”).format(pi) //结果：3.142
 * 都是对pi进行格式化，但第一个的结果是03.142,第二个的结果是3.142
 * 这是什么原因呢？
 * 0和#都是占位符，但在不同的地方，作用不一样。下面对他们做了具体的比较。
 * 希望对大家有所帮助。
 * 0：****************************************************
 * 比实际数字的位数多，不足的地方用0补上。
 * new DecimalFormat(“00.00”).format(3.14) //结果：03.14
 * new DecimalFormat(“0.000”).format(3.14) //结果： 3.140
 * new DecimalFormat(“00.000”).format(3.14) //结果：03.140
 * 比实际数字的位数少：整数部分不改动，小数部分，四舍五入
 * new DecimalFormat(“0.000”).format(13.146) //结果：13.146
 * new DecimalFormat(“00.00”).format(13.146) //结果：13.15
 * new DecimalFormat(“0.00”).format(13.146) //结果：13.15
 * #：****************************************************
 * 比实际数字的位数多，不变。
 * new DecimalFormat(“##.##”).format(3.14) //结果：3.14
 * new DecimalFormat(“#.###”).format(3.14) //结果： 3.14
 * new DecimalFormat(“##.###”).format(3.14) //结果：3.14
 * 比实际数字的位数少：整数部分不改动，小数部分，四舍五入
 * new DecimalFormat(“#.###”).format(13.146) //结果：13.146
 * new DecimalFormat(“##.##”).format(13.146) //结果：13.15
 * new DecimalFormat(“#.##”).format(13.146) //结果：13.15
 *
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/12 15:33
 */
public class NumUtils {


    public static void main(String[] args) {
        System.out.println("XX:" + numToStrHP(1.09876, 2));
        System.out.println("XX:" + numToStrF(1.09876, 2));
    }


    /**
     * 格式化value，对point后小数四舍五入
     *
     * @param value
     * @param point
     * @return
     */
    public static String numToStrHP(double value, int point) {
        StringBuilder sb = new StringBuilder("0");
        if (point > 0) {
            sb.append(".");
            for (int i = 0; i < point; i++) {
                sb.append("0");
            }
        }
        return numToStr(value, sb.toString(), RoundingMode.HALF_UP);
    }

    /**
     * 格式化value，对point后小数舍弃
     *
     * @param value
     * @param point
     * @return
     */
    public static String numToStrF(double value, int point) {
        StringBuilder sb = new StringBuilder("0");
        if (point > 0) {
            sb.append(".");
            for (int i = 0; i < point; i++) {
                sb.append("0");
            }
        }
        return numToStr(value, sb.toString(), RoundingMode.FLOOR);
    }

    public static String numToStr(double value, String format, RoundingMode mode) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        decimalFormat.setRoundingMode(mode);
        return decimalFormat.format(value);
    }


    public static byte parseByte(final String s) {
        if (TextUtils.isEmpty(s)) {
            return 0;
        } else {
            try {
                return Byte.parseByte(s);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }


    public static short parseShort(final String s) {
        if (TextUtils.isEmpty(s)) {
            return 0;
        } else {
            try {
                return Short.parseShort(s);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }


    public static int parseInt(final String s) {
        if (TextUtils.isEmpty(s)) {
            return 0;
        } else {
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }


    public static long parseLong(final String s) {
        if (TextUtils.isEmpty(s)) {
            return 0L;
        } else {
            try {
                return Long.parseLong(s);
            } catch (NumberFormatException e) {
                return 0L;
            }
        }
    }


    public static float parseFloat(final String s) {
        if (TextUtils.isEmpty(s)) {
            return 0F;
        } else {
            try {
                return Float.parseFloat(s);
            } catch (NumberFormatException e) {
                return 0F;
            }
        }
    }


    public static double parseDouble(final String s) {
        if (TextUtils.isEmpty(s)) {
            return 0D;
        } else {
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                return 0D;
            }
        }
    }

}
