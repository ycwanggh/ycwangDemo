package com.ycwang.read.sms;

import android.os.Handler;
import android.os.Message;

/**
 * 短信处理
 */
class SmsHandler extends Handler {

    private SmsResponseCallback mCallback;

    /***
     * 短信过滤器
     */
    private SmsFilter smsFilter;

    SmsHandler(SmsResponseCallback callback) {
        mCallback = callback;
    }

    SmsHandler(SmsResponseCallback callback, SmsFilter smsFilter) {
        this(callback);
        this.smsFilter = smsFilter;
    }

    /***
     * 设置短信过滤器
     * @param smsFilter 短信过滤器
     */
    public void setSmsFilter(SmsFilter smsFilter) {
        this.smsFilter = smsFilter;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (msg.what == SmsObserver.MSG_RECEIVED_CODE) {
            String[] smsMessage = (String[]) msg.obj;
            if (smsMessage != null && smsMessage.length == 2 && mCallback != null) {
                if (smsFilter == null) {
                    smsFilter = new DefaultSmsFilter();
                }
                mCallback.onCallbackSmsContent(smsFilter.filter(smsMessage[0], smsMessage[1]));
            }
        }
    }
}
