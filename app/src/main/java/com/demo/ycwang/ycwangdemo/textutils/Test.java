package com.demo.ycwang.ycwangdemo.textutils;

import android.text.TextUtils;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ycwang
 * @Date: 2018-12-20 15:53
 */
public class Test {


    public static void test() {

        String a = "Android";
        String b = " Stu dio";
        String c = "012345";
        String d = " \n\t \b";
        String e = "11-233-we-7d-fv";
        String f = "<html>\n<body>\n<h1>My First Heading</h1>\n<p>My first paragraph.</p>\n</body>\n</html>";
//        Log.e("tag", TextUtils.isEmpty(a) + "");// 字符串是否为null或“”
        Log.e("tag", TextUtils.isDigitsOnly(c) + "");// 字符串是否全是数字
//        Log.e("tag", TextUtils.isGraphic(d) + "");// 字符串是否含有可打印的字符
//
//        Log.e("tag", TextUtils.concat(a, b) + "");// 拼接多个字符串
//        Log.e("tag", TextUtils.getTrimmedLength(b) + "");// 去掉字符串前后两端空格(相当于trim())之后的长度
//        Log.e("tag", TextUtils.getReverse(b, 0, b.length()) + "");// 在字符串中，start和end之间字符的逆序
//        List<String> list = new LinkedList<>();
//        list.add("I");
//        list.add("love");
//        list.add("you");
//        Log.e("tag", TextUtils.join("-", list));// 在数组中每个元素之间使用“-”来连接
//
//        String[] arr = TextUtils.split(e, "-");// 以"-"来分组
//        for (int i = 0; i < arr.length; i++) {
//            Log.e("tag", arr[i]);
//        }
//        Log.e("tag", TextUtils.htmlEncode(f) + "");// 使用html编码字符串


    }
}
