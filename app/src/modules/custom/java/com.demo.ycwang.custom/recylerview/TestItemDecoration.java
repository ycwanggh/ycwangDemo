package com.demo.ycwang.custom.recylerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author ycwang.
 * @date 2017/12/15.
 */

public class TestItemDecoration extends RecyclerView.ItemDecoration {

    private Paint paint;
    private float dividerItemH;
    private float offsetL;
    private float offsetH;
    private float radius = 20;

    public TestItemDecoration() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.left = 100;
        offsetL = 100;
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.top = 1;
            dividerItemH = 1;
        }
    }

    private float center[] = new float[2];

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        // 一屏中item
        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);

            float drawL = view.getPaddingLeft();
            float drawR = offsetL + drawL;
            float drawT = view.getTop() - dividerItemH;
            float drawB = view.getBottom();


            center[0] = (drawL + drawR) / 2;
            center[1] = (drawB + drawT) / 2;

            paint.setStyle(Paint.Style.STROKE);
            c.drawCircle(center[0], center[1], radius, paint);
            paint.setStyle(Paint.Style.FILL);

            paint.setColor(Color.RED);
            Rect rect = new Rect();
            paint.getTextBounds("" + index, 0, ("" + index).length(), rect);
            int txtW = rect.width();
            int txwH = rect.height();
            c.drawText("" + index, center[0] - txtW / 2, center[1] + txwH / 2, paint);
            paint.setColor(Color.RED);

            c.drawRect(center[0] - 1, drawT, center[0] + 1, center[1] - radius, paint);
            c.drawRect(center[0] - 1, center[1] + radius, center[0] + 1, drawB, paint);
        }
    }


    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
