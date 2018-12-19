package com.demo.ycwang.ycwangdemo.imgcrop;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.demo.ycwang.ycwangdemo.R;
import com.demo.ycwang.ycwangdemo.imgcrop.view.CropImageView;

/**
 * @Author: ycwang
 * @Date: 2018-12-18 16:43
 * 截取图片
 */
public class ImageCropActivity extends Activity {


    private CropImageView cropImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_crop);


        cropImageView = findViewById(R.id.cropImageView);
        cropImageView.setImageResource(R.drawable.timg);

        findViewById(R.id.cropOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取裁剪的图片
                Bitmap cropBitMap = cropImageView.getCroppedImage();
                if (cropBitMap != null) {
                    cropImageView.setImageBitmap(cropBitMap);
                }

            }
        });
    }
}
