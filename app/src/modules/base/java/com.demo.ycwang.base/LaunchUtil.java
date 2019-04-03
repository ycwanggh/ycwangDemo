package com.demo.ycwang.base;

import android.content.Context;
import android.content.Intent;

import com.demo.ycwang.aidlt.BookManagerActivity;

import com.demo.ycwang.auto_create.ui_compoment_fragment.ItemActivity;
import com.demo.ycwang.custom.animation.AnimationActivity;


import com.demo.ycwang.custom.edittext.SpaceEditTextActivity;
import com.demo.ycwang.custom.view.imgcrop.ImageCropActivity;
import com.demo.ycwang.custom.keyboard.KeyBoardActivity;
import com.demo.ycwang.custom.layout.LayoutTestActivity;

import com.demo.ycwang.custom.niotifcation.NotificationActivity;
import com.demo.ycwang.custom.recylerview.RecyclerViewActivity;
import com.demo.ycwang.custom.slidetab.SlideTabActivity;
import com.demo.ycwang.custom.slidingtray.SlidingTrayActivity;

import com.demo.ycwang.custom.tab.TabActivity;

import com.demo.ycwang.custom.viewdraghelper.ViewDragHelperActivity;
import com.demo.ycwang.data.DataActivity;
import com.demo.ycwang.mvp.PresenterActivity;
import com.demo.ycwang.util.StorageActivity;
import com.demo.ycwang.util.textutils.TextUtilsCopyActivity;


// Intent.FLAG_ACTIVITY_NEW_TASK 启动的Activity都将在每个新的Task中 ，一般从Service中启动Activity用此标志
// Intent.FLAG_ACTIVITY_SINGLE_TOP 与指定 android:launchMode="singleTop" 一样
// Intent.FLAG_ACTIVITY_NO_HISTORY 所启动的Activity不会保留在栈中

/**
 * @Author: ycwang
 * @Date: 2018-12-18 11:20
 */
public class LaunchUtil {

    public static void launchSpaceEditText(Context context) {
        Intent intent = new Intent(context, SpaceEditTextActivity.class);
        context.startActivity(intent);
    }

    public static void launchRecyclerView(Context context) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(intent);
    }

    public static void launchSlidingTray(Context context) {
        Intent intent = new Intent(context, SlidingTrayActivity.class);
        context.startActivity(intent);
    }

    public static void launchTab(Context context) {
        Intent intent = new Intent(context, TabActivity.class);
        context.startActivity(intent);
    }

    public static void launchViewDragHelper(Context context) {
        Intent intent = new Intent(context, ViewDragHelperActivity.class);
        context.startActivity(intent);
    }

    public static void launchSlideTab(Context context) {
        Intent intent = new Intent(context, SlideTabActivity.class);
        context.startActivity(intent);
    }

    public static void launchCropImage(Context context) {
        Intent intent = new Intent(context, ImageCropActivity.class);
        context.startActivity(intent);
    }

    public static void launchKeyBoard(Context context) {
        Intent intent = new Intent(context, KeyBoardActivity.class);
        context.startActivity(intent);
    }

    public static void launchAnimation(Context context) {
        Intent intent = new Intent(context, AnimationActivity.class);
        context.startActivity(intent);
    }

    public static void launchTextUtils(Context context) {
        Intent intent = new Intent(context, TextUtilsCopyActivity.class);
        context.startActivity(intent);
    }

    public static void launchData(Context context) {
        Intent intent = new Intent(context, DataActivity.class);
        context.startActivity(intent);
    }

    public static void launchMVP(Context context) {
        Intent intent = new Intent(context, PresenterActivity.class);
        context.startActivity(intent);
    }

    public static void launchNotification(Context context) {
        Intent intent = new Intent(context, NotificationActivity.class);
        context.startActivity(intent);
    }

    public static void launchStorageUtils(Context context) {
        Intent intent = new Intent(context, StorageActivity.class);
        context.startActivity(intent);
    }

    public static void launchItemListFragment(Context context) {
        Intent intent = new Intent(context, ItemActivity.class);
        context.startActivity(intent);
    }

    public static void launchLayoutTest(Context context) {
        Intent intent = new Intent(context, LayoutTestActivity.class);
        context.startActivity(intent);
    }
    public static void launchSerVice(Context context) {
        Intent intent = new Intent(context, BookManagerActivity.class);
        context.startActivity(intent);
    }

}
