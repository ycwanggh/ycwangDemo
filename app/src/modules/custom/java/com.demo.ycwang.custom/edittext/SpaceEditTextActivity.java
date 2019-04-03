package com.demo.ycwang.custom.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.demo.ycwang.ycwangdemo.R;

/**
 * @Author: ycwang
 * @Date: 2018-12-18 11:20
 */
public class SpaceEditTextActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_edittext);

        SpaceEditText editText = findViewById(R.id.edit);
        editText.setTextChangeListener(new SpaceEditText.TextChangeListener() {
            @Override
            public void textChange(String text) {
                Log.e("ycwang", text);
            }
        });
    }
}
