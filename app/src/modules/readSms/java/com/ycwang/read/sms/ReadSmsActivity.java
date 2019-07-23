package com.ycwang.read.sms;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.EditText;


import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.demo.ycwang.ycwangdemo.R;

/**
 * @Description: 自动填写短信验证码
 * @Author: ycwang
 * @Date: 2019/7/22 10:50
 */
public class ReadSmsActivity extends Activity {

    private EditText edtPassword;


    int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_read);
        edtPassword = findViewById(R.id.password);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_SMS},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        }

        smsObserver.registerSMSObserver();
    }

    private SmsObserver smsObserver = new SmsObserver(this, new SmsResponseCallback() {
        @Override
        public void onCallbackSmsContent(String smsContent) {
            edtPassword.setText(smsContent);
        }
    }, new VerificationCodeSmsFilter("XXXXXXXX"));

    @Override
    protected void onDestroy() {
        super.onDestroy();
        smsObserver.unregisterSMSObserver();
    }
}
