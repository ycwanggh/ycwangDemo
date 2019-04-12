package com.demo.ycwang.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/11 15:23
 */
public class CalendarUtil {


    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("获取当前得年份:" + calendar.get(Calendar.YEAR));
        System.out.println("获取当前得月份:" + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("获取当前得日期:" + calendar.get(Calendar.DAY_OF_MONTH));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");

        System.out.println(simpleDateFormat.format(calendar.getTime()));
        //增加日期中的某个域的值，比如想获得明天的日期
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("明天：" + simpleDateFormat.format(calendar.getTime()));

        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, 1);
        //比较两个日期哪个更靠后一些
        System.out.println("calendar1日期在calendar日期后面：" + calendar1.after(calendar));

        //判断两个日期哪个更靠前
        System.out.println("calendar1日期在calendar日期前面：" + calendar1.before(calendar));


        //清空所有的域然后全部用最小的值代替
        calendar.clear();
        System.out.println("calendar清空全域用最小值替换：" + simpleDateFormat.format(calendar.getTime()));

        //清空#Calendar.MONTH域并用这个域最小的值代替和
        calendar1.clear(Calendar.MONTH);
        System.out.println("calendar1清空月份最小值替换：" + simpleDateFormat.format(calendar1.getTime()));


        //获得Calendar对象的一个深拷贝
        Calendar calendar2 = (Calendar) calendar1.clone();
        System.out.println("calendar1:" + simpleDateFormat.format(calendar1.getTime()));
        System.out.println("calendar2:" + simpleDateFormat.format(calendar2.getTime()));

        calendar1.add(Calendar.DAY_OF_MONTH, 2);
        System.out.println("calendar1:" + simpleDateFormat.format(calendar1.getTime()));
        System.out.println("calendar2:" + simpleDateFormat.format(calendar2.getTime()));


        // 比较两个Calendar哪个在前哪个在后的方法
        //
        // 如果调calendar2比calendar1
        // 靠前，返回-1，
        // 靠后，返回1，
        // 相等，返回0
        System.out.println("比较的结果:" + calendar2.compareTo(calendar1));
        calendar2.add(Calendar.YEAR, 1);
        System.out.println("比较的结果:" + calendar2.compareTo(calendar1));
        calendar1.add(Calendar.YEAR, 1);
        calendar2.add(Calendar.DAY_OF_MONTH, 2);
        System.out.println("比较的结果:" + calendar2.compareTo(calendar1));

        // 将当前Calendar对象转换为Date对象
        System.out.println(calendar.getTime());


        // 为Calendar对象的域设置值的一些方法
        // Calendar.set(int field,int value);


        // 将Date对象设置给Calendar对象的方法
        // Calendar.setTime(Date date);
    }


}
