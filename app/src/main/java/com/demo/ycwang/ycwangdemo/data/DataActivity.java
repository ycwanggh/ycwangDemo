package com.demo.ycwang.ycwangdemo.data;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.demo.ycwang.data.local.db.entity.User;
import com.demo.ycwang.ycwangdemo.R;
import com.demo.ycwang.ycwangdemo.app.App;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 15:19
 */
public class DataActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        TextView add_one = findViewById(R.id.add_one);
        add_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getDataManager().setUser(new User("1", "ycwang", 23));
            }
        });

        TextView add_all = findViewById(R.id.add_all);
        add_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> list = new ArrayList<>();
                list.add(new User("1", "ycwang_1", 23));
                list.add(new User("1", "ycwang_2", 24));
                list.add(new User("1", "ycwang_3", 25));
                App.getDataManager().setUsers(list);
            }
        });

        TextView delete_one = findViewById(R.id.delete_one);
        delete_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = App.getDataManager().getUser("1");
                Log.e("ycwang", "name:" + user.getName() + "   id:" + user.getId() + "   age:" + user.getAge());
            }
        });

    }
}
