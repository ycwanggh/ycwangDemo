package com.demo.ycwang.ycwangdemo.auto_create.ui_compoment_fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.demo.ycwang.ycwangdemo.R;
import com.demo.ycwang.ycwangdemo.auto_create.ui_compoment_fragment.dummy.DummyContent;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/2/28 15:59
 */
public class ItemActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_item);


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame, ItemFragment.newInstance(2));
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();
    }
}
