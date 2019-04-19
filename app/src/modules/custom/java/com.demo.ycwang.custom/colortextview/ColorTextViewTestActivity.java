package com.demo.ycwang.custom.colortextview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.demo.ycwang.ycwangdemo.R;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/18 17:04
 */
public class ColorTextViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_color_text_view);
        ColorTextView colorTextView=findViewById(R.id.txt_reload);
        colorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
