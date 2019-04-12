package com.demo.ycwang.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/11 16:56
 */
public class DateUtils {

    @NonNull
    private static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static int getYear(Date date) {
        Calendar calendar = getCalendar(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        Calendar calendar = getCalendar(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDay(Date date) {
        Calendar calendar = getCalendar(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getHour(Date date) {
        Calendar calendar = getCalendar(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinute(Date date) {
        Calendar calendar = getCalendar(date);
        return calendar.get(Calendar.MINUTE);
    }

    public static int getSecond(Date date) {
        Calendar calendar = getCalendar(date);
        return calendar.get(Calendar.SECOND);
    }

    public static Date addYear(Date date, int value) {
        Calendar calendar = getCalendar(date);
        calendar.add(Calendar.YEAR, value);
        return calendar.getTime();
    }

    public static Date addMonth(Date date, int value) {
        Calendar calendar = getCalendar(date);
        calendar.add(Calendar.MONTH, value);
        return calendar.getTime();
    }

    public static Date addDay(Date date, int value) {
        Calendar calendar = getCalendar(date);
        calendar.add(Calendar.DAY_OF_MONTH, value);
        return calendar.getTime();
    }

    public static Date addHour(Date date, int value) {
        Calendar calendar = getCalendar(date);
        calendar.add(Calendar.HOUR, value);
        return calendar.getTime();
    }


    public static Date setYear(Date date, int value) {
        Calendar calendar = getCalendar(date);
        calendar.set(Calendar.YEAR, value);
        return calendar.getTime();
    }

    public static Date setMonth(Date date, int value) {
        Calendar calendar = getCalendar(date);
        calendar.set(Calendar.MONTH, value);
        return calendar.getTime();
    }

    public static Date setDay(Date date, int value) {
        Calendar calendar = getCalendar(date);
        calendar.set(Calendar.DAY_OF_MONTH, value);
        return calendar.getTime();
    }

    public static Date setHour(Date date, int value) {
        Calendar calendar = getCalendar(date);
        calendar.set(Calendar.HOUR, value);
        return calendar.getTime();
    }

    public static Date setMinute(Date date, int value) {
        Calendar calendar = getCalendar(date);
        calendar.set(Calendar.MINUTE, value);
        return calendar.getTime();
    }

    public static Date setSecond(Date date, int value) {
        Calendar calendar = getCalendar(date);
        calendar.set(Calendar.SECOND, value);
        return calendar.getTime();
    }

    /**
     * 日期型字符串转化为日期 格式
     * "yyyy-MM-dd"
     * "yyyy-MM-dd HH:mm:ss"
     * "yyyy-MM-dd HH:mm"
     * "yyyy/MM/dd"
     * "yyyy/MM/dd HH:mm:ss"
     * "yyyy/MM/dd HH:mm"
     * "yyyy.MM.dd"
     * "yyyy.MM.dd HH:mm:ss"
     * "yyyy.MM.dd HH:mm"
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static Date getDate(long timeStamp) {
        return new Date(timeStamp);
    }

    public static long getTimeStamp(Date date) {
        return date.getTime();
    }


    /**
     * 比较两个date的前后
     *
     * @param date1
     * @param date2
     * @return 0:data1 equal data2
     * -1:date1 before date2
     * 1:date1 after date2
     */
    public static int compareDate(Date date1, Date date2) {
        return date1.compareTo(date2);
    }

    /**
     * 判断是否是闰年
     *
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setGregorianChange(new Date(Long.MIN_VALUE));
        return calendar.isLeapYear(year);
    }


    /**
     * 判断两个日期是否为同一天
     * 把二个时间的的年月日分别对比，完全相等就是同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        Calendar calendar1 = getCalendar(date1);
        Calendar calendar2 = getCalendar(date2);
        boolean isSameYear = calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
        boolean isMonth = isSameYear && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
        boolean isSameDay = isMonth && calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
        return isSameDay;
    }


    public static boolean isSameMonth(Date date1, Date date2) {
        Calendar calendar1 = getCalendar(date1);
        Calendar calendar2 = getCalendar(date2);
        boolean isSameYear = calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
        boolean isSameMonth = isSameYear && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
        return isSameMonth;
    }

    public static boolean isSameYear(Date date1, Date date2) {
        Calendar calendar1 = getCalendar(date1);
        Calendar calendar2 = getCalendar(date2);
        boolean isSameYear = calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
        return isSameYear;
    }


    /**
     * 将时间字符串转化为时间戳
     *
     * @param time
     * @param format
     * @return
     */
    public static long convertStrToTimeStamp(String time, String format) {
        if (TextUtils.isEmpty(time) || TextUtils.isEmpty(format)) {
            return 0L;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
        try {
            return simpleDateFormat.parse(time).getTime();
        } catch (ParseException e) {

        }
        return 0L;
    }


    /**
     * 将时间戳转化为特定格式的时间字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String convertTimeStampToStr(Date date, String format) {
        if (TextUtils.isEmpty(format)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
        return simpleDateFormat.format(date);
    }


    /**
     * 时间字符串格式的转化
     *
     * @param time         输入的时间
     * @param inputFormat  输入的时间字符串格式
     * @param outputFormat 输出的时间字符串格式
     * @return
     */
    public static String convertString(final String time, final String inputFormat, final String outputFormat) {
        if (TextUtils.isEmpty(time) || TextUtils.isEmpty(inputFormat) || TextUtils.isEmpty(outputFormat)) {
            return null;
        }
        try {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputFormat, Locale.getDefault());
            SimpleDateFormat outputDateFormat = new SimpleDateFormat(outputFormat, Locale.getDefault());
            return outputDateFormat.format(inputDateFormat.parse(time));
        } catch (ParseException e) {

        }
        return null;
    }

}
