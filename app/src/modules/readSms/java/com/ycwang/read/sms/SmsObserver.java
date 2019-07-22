package com.ycwang.read.sms;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/***
 * 短信接收观察者
 */
public class SmsObserver extends ContentObserver {

    private Context mContext;
    public static final int MSG_RECEIVED_CODE = 1001;
    private SmsHandler mHandler;

    /***
     * 构造器
     * @param context
     * @param callback 短信接收器
     * @param smsFilter 短信过滤器
     */
    public SmsObserver(Activity context, SmsResponseCallback callback, SmsFilter smsFilter) {
        this(new SmsHandler(callback, smsFilter));
        mContext = context;
    }

    public SmsObserver(Activity context, SmsResponseCallback callback) {
        this(new SmsHandler(callback));
        mContext = context;
    }

    private SmsObserver(SmsHandler handler) {
        super(handler);
        mHandler = handler;
    }

    /***
     * 设置短信过滤器
     * @param smsFilter
     */
    public void setSmsFilter(SmsFilter smsFilter) {
        mHandler.setSmsFilter(smsFilter);
    }

    /***
     * 注册短信变化观察者
     *
     * @see [类、类#方法、类#成员]
     */
    public void registerSMSObserver() {
        Uri uri = Uri.parse("content://sms");
        if (mContext != null) {
            mContext.getContentResolver().registerContentObserver(uri,
                    true, this);
        }
    }

    /***
     * 注销短信变化观察者
     *
     * @see [类、类#方法、类#成员]
     */
    public void unregisterSMSObserver() {
        if (mContext != null) {
            mContext.getContentResolver().unregisterContentObserver(this);
        }
        if (mHandler != null) {
            mHandler = null;
        }
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);
        if (uri.toString().equals("content://sms/raw")) {
            return;
        }
        Uri inboxUri = Uri.parse("content://sms/inbox");
        try {
            Cursor c = mContext.getContentResolver().query(inboxUri, new String[]{"_id", "address", "read", "body"}, "read=?", new String[]{"0"}, "date desc");
            if (c != null) {
                if (c.moveToFirst()) {
                    String address = c.getString(c.getColumnIndex("address"));
                    String body = c.getString(c.getColumnIndex("body"));
                    if (mHandler != null) {
                        mHandler.obtainMessage(MSG_RECEIVED_CODE, new String[]{address, body})
                                .sendToTarget();
                    }
                    Log.i("VVV", "发件人为：" + address + " " + "短信内容为：" + body);
                }
                c.close();
            }
        } catch (SecurityException e) {
            Log.e("VVV", "获取短信权限失败", e);
        } catch (Exception e) {
            Log.e("VVV", "VVV获取短信权限失败", e);
            e.printStackTrace();
        }
    }

}
