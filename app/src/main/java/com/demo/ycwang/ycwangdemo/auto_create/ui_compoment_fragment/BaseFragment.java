package com.demo.ycwang.ycwangdemo.auto_create.ui_compoment_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/2/28 14:24
 */
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 接受传递的参数
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // View视图创建
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // 获取持有该Fragment的Activity
//
        // 创建接口 将Fragment数据传递到持有该Fragment的Activity中

    }

    @Override
    public void onDetach() {
        super.onDetach();
        // 接口置为null
    }
}
