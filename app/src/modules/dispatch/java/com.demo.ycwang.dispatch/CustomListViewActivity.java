package com.demo.ycwang.dispatch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.demo.ycwang.ycwangdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/25 17:54
 */
public class CustomListViewActivity extends Activity {

    private String[] names = new String[]{"Lion", "Tiger", "Monkey", "Dog", "Cat", "elephant"};
    private int[] image = new int[]{R.drawable.common_google_signin_btn_icon_dark,
            R.drawable.common_full_open_on_phone,
            R.drawable.common_google_signin_btn_icon_dark_focused,
            R.drawable.common_google_signin_btn_icon_dark_normal_background,
            R.drawable.common_google_signin_btn_icon_light,
            R.drawable.common_google_signin_btn_icon_light_focused};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        CustomListView listView = findViewById(R.id.list_view);


        List<Map<String, Object>> ListItems = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("header", names[i]);
            listItem.put("images", image[i]);
            ListItems.add(listItem);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,
                ListItems,
                R.layout.listview_item,
                names,
                image);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
