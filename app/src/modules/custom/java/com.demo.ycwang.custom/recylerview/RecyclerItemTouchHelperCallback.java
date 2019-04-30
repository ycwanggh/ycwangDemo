package com.demo.ycwang.custom.recylerview;

import android.graphics.Color;

import com.demo.ycwang.ycwangdemo.R;

import java.util.Collections;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author ycwang.
 * @date 2017/12/15.
 * // 拖拽事件和滑动事件
 */

public class RecyclerItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private RecyclerViewActivity.HomeAdapter adapter;

    public RecyclerItemTouchHelperCallback(RecyclerViewActivity.HomeAdapter adapter) {
        this.adapter = adapter;
    }

    // 用于设置是否处理拖拽事件和滑动事件，以及拖拽和滑动操作的方向
    // 如果是列表类型的 RecyclerView，拖拽只有 UP、DOWN 两个方向
    // 如果是网格类型的则有 UP、DOWN、LEFT、RIGHT 四个方向
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            int swipeFlags = 0;
            return makeMovementFlags(dragFlags, swipeFlags);
        } else {
            int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
            return makeMovementFlags(dragFlags, swipeFlags);
        }
    }

    // 长按进入拖拽状态时时回掉该方法
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();
        if (toPosition == 0) {
            return false;
        }
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(adapter.getDataList(), i, i + 1);
            }
        } else {
            for (int i = toPosition; i < fromPosition; i++) {
                Collections.swap(adapter.getDataList(), i, i - 1);
            }
        }
        adapter.notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    // 滑动删除的回掉
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int adapterPosition = viewHolder.getAdapterPosition();
        adapter.notifyItemRemoved(adapterPosition);
        adapter.getDataList().remove(adapterPosition);

    }

    // 当长按Item 刚开始拖拽的时候调用
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundResource(R.color.colorAccent);
        }
    }

    // 当完成拖拽手指松开的时候调用
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setBackgroundColor(Color.WHITE);
    }


    // 不可拖拽
    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }


}
