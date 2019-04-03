package com.demo.ycwang.data;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.demo.ycwang.base.App;
import com.demo.ycwang.data.local.db.entity.User;
import com.demo.ycwang.ycwangdemo.R;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 15:19
 */
public class DataActivity extends Activity {
    DataManager dataManager;


    User user1 = new User("111", "ycwang_111", 111);
    User user2 = new User("222", "ycwang_222", 222);
    User user3 = new User("333", "ycwang_333", 333);
    User user4 = new User("444", "ycwang_444", 444);
    User user5 = new User("555", "ycwang_555", 555);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        dataManager = App.getDataManager();

        TextView txw_insert_one = findViewById(R.id.txw_insert_one);
        txw_insert_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataManager.insert(user1);

                List<User> list = dataManager.queryAll();
                Log.e("ycwang", list.toString());
            }
        });

        TextView txw_insert_all = findViewById(R.id.txw_insert_all);
        txw_insert_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> list = new ArrayList<>();
                list.add(user2);
                list.add(user3);
                list.add(user4);
                dataManager.insertAll(list);


                List<User> list1 = dataManager.queryAll();
                Log.e("ycwang", list1.toString());
            }
        });

        TextView txw_query = findViewById(R.id.txw_query);
        txw_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = dataManager.query("333");
                Log.e("ycwang", user.toString());

                List<User> list1 = dataManager.queryAll();
                Log.e("ycwang", list1.toString());
            }
        });

        TextView txw_query_all = findViewById(R.id.txw_query_all);
        txw_query_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> list1 = dataManager.queryAll();
                Log.e("ycwang", list1.toString());
            }
        });

        TextView txw_update = findViewById(R.id.txw_update);
        txw_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user4.setAge(888);
                dataManager.update(user4);

                List<User> list1 = dataManager.queryAll();
                Log.e("ycwang", list1.toString());
            }
        });

    }
}
