package com.demo.ycwang.custom.keyboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.ycwang.ycwangdemo.R;

/**
 * @Author: ycwang
 * @Date: 2018-12-19 10:36
 * Android 软键盘打开与隐藏测试
 */
public class KeyBoardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_board);


        TextView open = findViewById(R.id.open_key_board);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtils.showSoftInput(KeyBoardActivity.this, v);
            }
        });

        TextView close = findViewById(R.id.close_key_board);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtils.hideSoftInput(KeyBoardActivity.this, v);
            }
        });

        KeyboardUtils.registerSoftInputChangedListener(this, new KeyboardUtils.OnSoftInputChangedListener() {
            @Override
            public void onSoftInputChanged(int height) {
                Toast.makeText(getApplicationContext(), "height:" + height, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        KeyboardUtils.unregisterSoftInputChangedListener(this);
    }
}
