package com.demo.ycwang.custom.colortextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.demo.ycwang.ycwangdemo.R;

import androidx.appcompat.widget.AppCompatTextView;


/**
 * 不同类型按钮  样式
 * 样式查看 color_text_sample.xml
 * <p>
 * Created by ycwang on 2016-11-23 11:17.
 * Description
 */

public class ColorTextView extends AppCompatTextView {

    private static final int NORMAL = 0;
    private static final int CLICK_DOWN = 1;
    private static final int UN_USE = 2;


    /**
     * 圆角设置
     */
    private int topRightCornerRadius = 0;
    private int topLeftCornerRadius = 0;
    private int bottomRightCornerRadius = 0;
    private int bottomLeftCornerRadius = 0;
    private int cornerRadius = 0;

    /**
     * 边线设置
     */
    private int strokeWidth = 0;


    private int strokeColorDisable;
    private int backgroundColorDisable;
    private int textColorDisable;


    private int strokeColor;
    /**
     * 字体/背景颜色设置
     */
    private int backgroundColor;
    private int textColor;


    private int drawStrokeColor;
    private int drawBackgroundColor;
    private int drawTextColor;


    /**
     * 是否可点击
     */
    private boolean isEnable = true;

    private ShapeDrawable mDrawable;
    private Rect rect = new Rect();
    private float[] outerR = new float[8];
    private float[] outerI = new float[8];


    /**
     * 0：正常 1：点击 2：不可用
     * 按钮状态
     */
    private int state = NORMAL;


    public ColorTextView(Context context) {
        this(context, null);
    }

    public ColorTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ColorTextView);
        strokeWidth = typedArray.getDimensionPixelSize(R.styleable.ColorTextView_strokeWidth, strokeWidth);
        cornerRadius = typedArray.getDimensionPixelSize(R.styleable.ColorTextView_cornerRadius, cornerRadius);
        topLeftCornerRadius = typedArray.getDimensionPixelSize(R.styleable.ColorTextView_topLeftCornerRadius, topLeftCornerRadius);
        topRightCornerRadius = typedArray.getDimensionPixelSize(R.styleable.ColorTextView_topRightCornerRadius, topRightCornerRadius);
        bottomLeftCornerRadius = typedArray.getDimensionPixelSize(R.styleable.ColorTextView_bottomLeftCornerRadius, bottomLeftCornerRadius);
        bottomRightCornerRadius = typedArray.getDimensionPixelSize(R.styleable.ColorTextView_bottomRightCornerRadius, bottomRightCornerRadius);
        strokeColor = typedArray.getColor(R.styleable.ColorTextView_strokeColor, Color.TRANSPARENT);
        backgroundColor = typedArray.getColor(R.styleable.ColorTextView_backgroundColor, Color.TRANSPARENT);
        textColor = typedArray.getColor(R.styleable.ColorTextView_ctTextColor, Color.TRANSPARENT);

        strokeColorDisable = typedArray.getColor(R.styleable.ColorTextView_stroke_color_disable, Color.TRANSPARENT);
        backgroundColorDisable = typedArray.getColor(R.styleable.ColorTextView_background_color_disable, Color.TRANSPARENT);
        textColorDisable = typedArray.getColor(R.styleable.ColorTextView_ct_text_color_disable, Color.TRANSPARENT);

        isEnable = typedArray.getBoolean(R.styleable.ColorTextView_isEnable, isEnable);
        typedArray.recycle();

        setEnabled(isEnable);

    }


    RectF rectF = new RectF();


    @Override
    protected void onDraw(Canvas canvas) {
        // 绘制边角
        setTextColor(drawTextColor);

        rect.left = 0;
        rect.top = 0;
        rect.right = getMeasuredWidth();
        rect.bottom = getMeasuredHeight();

        rectF.bottom = strokeWidth;
        rectF.left = strokeWidth;
        rectF.top = strokeWidth;
        rectF.right = strokeWidth;

        if (cornerRadius > 0) {
            for (int i = 0; i < outerR.length; i++) {
                outerR[i] = cornerRadius;
            }
        } else {
            outerR[0] = outerR[1] = topRightCornerRadius;
            outerR[2] = outerR[3] = topLeftCornerRadius;
            outerR[4] = outerR[5] = bottomRightCornerRadius;
            outerR[6] = outerR[7] = bottomLeftCornerRadius;
        }

        mDrawable = new ShapeDrawable(new RoundRectShape(outerR, rectF, outerR));
        mDrawable.setBounds(rect);

        mDrawable.getPaint().setAntiAlias(true);
        mDrawable.getPaint().setColor(drawBackgroundColor);
        mDrawable.getPaint().setStyle(Paint.Style.FILL);
        mDrawable.draw(canvas);
        canvas.save();

        mDrawable.getPaint().setStyle(Paint.Style.FILL);
        mDrawable.getPaint().setColor(drawStrokeColor);
        mDrawable.draw(canvas);

        super.onDraw(canvas);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (isEnabled()) {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    state = CLICK_DOWN;
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    state = NORMAL;
                    break;
            }
            setColor(state);
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            state = NORMAL;
        } else {
            state = UN_USE;
        }
        setColor(state);
    }

    private void setColor(int state) {

        switch (state) {
            case CLICK_DOWN:

                drawBackgroundColor = adjustAlpha(backgroundColor, 0.4f);
                drawStrokeColor = adjustAlpha(strokeColor, 0.4f);
                drawTextColor = adjustAlpha(textColor, 0.4f);
                invalidate();
                break;

            case NORMAL:

                drawBackgroundColor = adjustAlpha(backgroundColor, 1.0f);
                drawStrokeColor = adjustAlpha(strokeColor, 1.0f);
                drawTextColor = adjustAlpha(textColor, 1.0f);
                invalidate();
                break;

            case UN_USE:

                if (backgroundColorDisable == 0) {
                    drawBackgroundColor = adjustAlpha(backgroundColor, 0.4f);
                } else {
                    drawBackgroundColor = adjustAlpha(backgroundColorDisable, 1.0f);
                }

                if (strokeColorDisable == 0) {
                    drawStrokeColor = adjustAlpha(strokeColor, 0.4f);
                } else {
                    drawStrokeColor = adjustAlpha(strokeColorDisable, 1.0f);
                }

                if (textColorDisable == 0) {
                    drawTextColor = adjustAlpha(textColor, 0.4f);
                } else {
                    drawTextColor = adjustAlpha(textColorDisable, 1.0f);
                }


                invalidate();
                break;

            default:
                break;
        }
    }


    private int adjustAlpha(int color, float factor) {
        int alpha;
        if (Color.alpha(color) != 0 || Color.red(color) != 0 || Color.green(color) != 0 || Color.blue(color) != 0) {
            alpha = Math.round(255 * factor);
        } else {
            alpha = 0;
        }

        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }


    public ColorTextView setTopRightCornerRadius(int topRightCornerRadius) {
        this.topRightCornerRadius = (int) dpToPx(topRightCornerRadius);
        return this;
    }

    public ColorTextView setTopLeftCornerRadius(int topLeftCornerRadius) {
        this.topLeftCornerRadius = (int) dpToPx(topLeftCornerRadius);
        return this;
    }

    public ColorTextView setBottomRightCornerRadius(int bottomRightCornerRadius) {
        this.bottomRightCornerRadius = (int) dpToPx(bottomRightCornerRadius);
        return this;
    }

    public ColorTextView setBottomLeftCornerRadius(int bottomLeftCornerRadius) {
        this.bottomLeftCornerRadius = (int) dpToPx(bottomLeftCornerRadius);
        return this;
    }

    public ColorTextView setCornerRadius(int cornerRadius) {
        this.cornerRadius = (int) dpToPx(cornerRadius);
        return this;
    }

    public ColorTextView setStrokeWidth(int strokeWidth) {
        this.strokeWidth = (int) dpToPx(strokeWidth);
        return this;
    }

    public ColorTextView setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        return this;
    }

    public ColorTextView setBackgroundColour(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public ColorTextView setTextColour(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public ColorTextView setStrokeColorDisable(int strokeColorDisable) {
        this.strokeColorDisable = strokeColorDisable;
        return this;
    }

    public ColorTextView setBackgroundColourDisable(int backgroundColorDisable) {
        this.backgroundColorDisable = backgroundColorDisable;
        return this;
    }

    public ColorTextView setTextColourDisable(int textColorDisable) {
        this.textColorDisable = textColorDisable;
        return this;
    }

    public ColorTextView setEnable(boolean enable) {
        isEnable = enable;
        return this;
    }


    public void create() {
        setEnabled(isEnable);
        invalidate();
    }

    /**
     * 将 dp 单位转为 px 单位
     *
     * @param value dp
     * @return 对应的px
     */
    public float dpToPx(float value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }
}
