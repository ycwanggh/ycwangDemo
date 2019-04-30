package com.demo.ycwang.custom.animation;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.demo.ycwang.ycwangdemo.R;

import androidx.annotation.RequiresApi;

/**
 * @Author: ycwang
 * @Date: 2018-12-20 10:06
 */
public class AnimationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        TextView txwAnimation = findViewById(R.id.txw_animation);
        txwAnimation.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                animation1(v);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void animation2(View v) {

//        ViewWrapper viewWrapper = new ViewWrapper(v);
//        ObjectAnimator animator = ObjectAnimator.ofInt(viewWrapper, "width", 500, 100, 500, 100, 0, 1000);
//        animator.setDuration(6000);
//        animator.start();

//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "translationX", 100);
//        objectAnimator.setDuration(2000);
//        objectAnimator.start();


//        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f);
//        PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("translationX", 0f, -200f, 200f);
//        PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f, 1f);
//        PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0f, 1f);
//        ObjectAnimator.ofPropertyValuesHolder(v,
//                propertyValuesHolder,
//                propertyValuesHolder1,
//                propertyValuesHolder2,
//                propertyValuesHolder3).setDuration(5000).start();


//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0F, 100F);
//        valueAnimator.setTarget(v);
//        valueAnimator.setDuration(5000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float f = animation.getAnimatedFraction();
//                Log.e("ycwang", "f:  " + f);
//            }
//        });
//        valueAnimator.start();


//        ObjectAnimator animator = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f, 1f);
//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(v, "translationX", 0f, -200f, 200f);
//        ObjectAnimator animator2 = ObjectAnimator.ofFloat(v, "scaleX", 1f, 0f, 1f);
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.play(animator).with(animator1).after(animator2);
//        animatorSet.setDuration(5000);
//        animatorSet.start();

//        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.test_animator);
//        animator.setTarget(v);
//        animator.start();


//        v.animate().alpha(0.5f).y(300).setDuration(3000).start();

//        v.animate().translationX(100).setDuration(5000).withStartAction(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(getApplicationContext(), "动画开始", Toast.LENGTH_SHORT).show();
//            }
//        }).withEndAction(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(getApplicationContext(), "动画结束", Toast.LENGTH_SHORT).show();
//            }
//        }).start();


    }


    private void animation1(View v) {
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.setDuration(2000);

//                TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 200);
//                translateAnimation.setDuration(2000);
//                animationSet.addAnimation(translateAnimation);

//                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 2, 0, 2);
//                scaleAnimation.setDuration(2000);
//                animationSet.addAnimation(scaleAnimation);

//                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
//                alphaAnimation.setDuration(2000);
//                animationSet.addAnimation(alphaAnimation);

//        RotateAnimation rotateAnimation = new RotateAnimation(0f,
//                1800f,
//                Animation.RELATIVE_TO_SELF,
//                0.5f,
//                Animation.RELATIVE_TO_SELF,
//                0.5f);
//        rotateAnimation.setDuration(2000);
//        rotateAnimation.setRepeatMode(Animation.INFINITE);
//        animationSet.addAnimation(rotateAnimation);
//        v.startAnimation(animationSet);


        com.demo.ycwang.ycwangdemo.animation.CameraAnimation animation = new com.demo.ycwang.ycwangdemo.animation.CameraAnimation();
        v.startAnimation(animation);

    }


}
