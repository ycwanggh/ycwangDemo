package com.demo.ycwang.custom.recylerview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.ycwang.ycwangdemo.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


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
        layoutManager.setOrientation(RecyclerView.VERTICAL);
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

//            @Override
//            public void onItemLongClick(RecyclerView.ViewHolder viewHolder) {
//                if (viewHolder.getLayoutPosition() != 0) {
//                    itemTouchHelper.startDrag(viewHolder);
//                }
//            }
        });

        recyclerView.setAdapter(adapter);


        TextView btn_a = findViewById(R.id.btn_a);
        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addData(4);
            }
        });
        TextView btn_b = findViewById(R.id.btn_b);
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.removeData(4);
            }
        });

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

            TextView tv;

            public HomeViewHolder(View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.txw);
            }

            public void bind(String item) {
                tv.setText(item);
            }
        }

    }


}
