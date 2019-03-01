package com.demo.ycwang.ycwangdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.demo.ycwang.ycwangdemo.auto_create.ItemListDialogFragment;
import com.demo.ycwang.ycwangdemo.auto_create.ui_componment_notification.NewMessageNotification;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ItemListDialogFragment.Listener {

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

    @OnClick(R.id.txw_notification)
    void onClickNotification() {
        LaunchUtil.launchNotification(this);
    }

    @OnClick(R.id.txw_storage)
    void onClickStorageUtils() {
        LaunchUtil.launchStorageUtils(this);
    }

    @OnClick(R.id.txw_list_dialog_from_bottom)
    void onClickListDialogFromBottom() {
        ItemListDialogFragment.newInstance(5).show(getSupportFragmentManager(), "dialog");
        /**
         * //{@link #onItemClicked(int)}
         */
    }

    @OnClick(R.id.txw_list_fragment)
    void onClickListFragment() {
        LaunchUtil.launchItemListFragment(this);
    }

    @OnClick(R.id.txw_notification_auto)
    void onClickNotificationAuto() {
        NewMessageNotification.notify(this, "XXXXXXXXXX", 5);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(getApplicationContext(), "OnItemCLicked", Toast.LENGTH_SHORT).show();
    }

}
