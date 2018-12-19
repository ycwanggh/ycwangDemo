package com.demo.ycwang.ycwangdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.txw_edit)
    void onClickEdit() {
        LaunchUtil.launchSpaceEditText(this);
    }

    @OnClick(R.id.txw_recycler_view)
    void onClickRecyclerView() {
        LaunchUtil.launchRecyclerViewActivity(this);
    }

    @OnClick(R.id.txw_slidingtray)
    void onClickSlideTray() {
        LaunchUtil.launchSlidingtrayActivity(this);
    }

    @OnClick(R.id.txw_tab)
    void onClickTab() {
        LaunchUtil.launchTabActivity(this);
    }

    @OnClick(R.id.txw_view_drag_helper)
    void onClickViewDragHelper() {
        LaunchUtil.launchViewDragHelperActivity(this);
    }

    @OnClick(R.id.txw_slide_tab)
    void onClickSlideTab() {
        LaunchUtil.launchSlideTab(this);
    }

    @OnClick(R.id.txw_image_crop)
    void onClickCropImage() {
        LaunchUtil.launchCropImage(this);
    }

    @OnClick(R.id.txw_key_board)
    void onClickKeyBoard() {
        LaunchUtil.launchKeyBoard(this);
    }
}
