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
        LaunchUtil.launchRecyclerView(this);
    }

    @OnClick(R.id.txw_slidingtray)
    void onClickSlideTray() {
        LaunchUtil.launchSlidingTray(this);
    }

    @OnClick(R.id.txw_tab)
    void onClickTab() {
        LaunchUtil.launchTab(this);
    }

    @OnClick(R.id.txw_view_drag_helper)
    void onClickViewDragHelper() {
        LaunchUtil.launchViewDragHelper(this);
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

    @OnClick(R.id.txw_animation)
    void onClickAnimation() {
        LaunchUtil.launchAnimation(this);
    }

    @OnClick(R.id.txw_text_utils)
    void onClickTextUtils() {
        LaunchUtil.launchTextUtils(this);
    }

    @OnClick(R.id.txw_data)
    void onClickData() {
        LaunchUtil.launchData(this);
    }


    @OnClick(R.id.txw_mvp)
    void onClickMVP() {
        LaunchUtil.launchMVP(this);
    }
}
