
package com.ycwang.read.sms;

/**
 * 短信过滤器
 */
interface SmsFilter {

    /***
     * 过滤方法
     */
    String filter(String address, String smsContent);
}
