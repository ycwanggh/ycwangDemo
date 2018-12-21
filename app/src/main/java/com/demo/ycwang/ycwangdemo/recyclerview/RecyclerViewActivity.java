package com.demo.ycwang.ycwangdemo.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.ycwang.ycwangdemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author ycwang.
 * @date 2017/12/14.
 */

public class RecyclerViewActivity extends Activity {
    private List<String> list;
    private HomeAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerItemTouchHelperCallback recylerViewItemTouchHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyle_view);
        recyclerView = findViewById(R.id.recyler_view);
        initData();
        adapter = new HomeAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new TestItemDecoration());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 拖拽事件
        recylerViewItemTouchHelper = new RecyclerItemTouchHelperCallback(adapter);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(recylerViewItemTouchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        // 点击事件添加
        recyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(recyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder viewHolder) {
                int i = viewHolder.getAdapterPosition();
                Toast.makeText(getApplicationContext(), "点击：---》" + i + "条", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(RecyclerView.ViewHolder viewHolder) {
                if (viewHolder.getLayoutPosition() != 0) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });

        recyclerView.setAdapter(adapter);
    }


    @OnClick(R.id.btn_a)
    void onClickA() {
        adapter.addData(4);
    }

    @OnClick(R.id.btn_b)
    void onClickB() {
        adapter.removeData(4);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("我是第" + i + "条数据");
        }
    }


    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

        @Override
        public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new HomeViewHolder(
                    LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.item_recyle_view, parent, false));
        }

        @Override
        public void onBindViewHolder(HomeViewHolder holder, int position) {
            holder.bind(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public void addData(int position) {
            list.add(position, "Insert One");
            notifyItemInserted(position);
        }

        public void removeData(int position) {
            list.remove(position);
            notifyItemRemoved(position);
        }

        public List<String> getDataList() {
            return list;
        }

        public class HomeViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.txw)
            TextView tv;

            public HomeViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            public void bind(String item) {
                tv.setText(item);
            }
        }

    }


}
