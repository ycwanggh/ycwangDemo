package com.demo.ycwang.custom.slidetab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.ycwang.ycwangdemo.R;

/**
 * @Author: ycwang
 * @Date: 2018-12-18 16:28
 * 类似QQ侧滑
 */
public class SlideTabActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView tvClose;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_tab);
        initViews();
    }


    public void initViews() {
        tvClose = findViewById(R.id.tv_close);
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("Toolbar");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.ab_setting:
                        Toast.makeText(getApplicationContext(), "ab_setting", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.ab_share:
                        Toast.makeText(getApplicationContext(), "ab_share", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.ab_srarch:
                        Toast.makeText(getApplicationContext(), "ab_srarch", Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });

        drawerLayout = findViewById(R.id.draw_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
        tvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
