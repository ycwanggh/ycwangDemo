package com.demo.ycwang.custom.layout;

import android.os.Bundle;

import com.demo.ycwang.ycwangdemo.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * ==merge使用注意==
 * <p>
 * 1.因为merge标签并不是View,所以在通过LayoutInflate.inflate()方法渲染的时候,第二个参数必须指定一个父容器,且第三个参数必须为true,也就是必须为merge下的视图指定一个父亲节点.
 * 2.因为merge不是View,所以对merge标签设置的所有属性都是无效的.
 * 3.注意如果include的layout用了merge,调用include的根布局也使用了merge标签,那么就失去布局的属性了
 * 4.merge标签必须使用在根布局
 * 5.ViewStub标签中的layout布局不能使用merge标签
 * <p>
 * <p>
 * <ViewStub android:id="@+id/stub_import"
 * <!--android:inflateId：重写ViewStub的父布局控件的Id-->
 * android:inflatedId="@+id/panel_import"
 * <!--android:layout：设置ViewStub被inflate的布局-->
 * android:layout="@layout/progress_overlay"
 * android:layout_width="match_parent"
 * android:layout_height="wrap_content"
 * android:layout_gravity="bottom" />
 * <p>
 * // 当你想加载布局时，可以使用下面其中一种方法：
 * ((ViewStub) findViewById(R.id.stub_import)).setVisibility(View.VISIBLE);
 * or
 * View importPanel = ((ViewStub) findViewById(R.id.stub_import)).inflate();
 * <p>
 * ==ViewStub标签使用注意==
 * 1.ViewStub标签不支持merge标签
 * 2.ViewStub的inflate只能被调用一次,第二次调用会抛出异常,
 * setVisibility可以被调用多次,但不建议这么做(ViewStub 调用过后,可能被GC掉,再调用setVisibility()会报异常)
 * 3.为ViewStub赋值的android:layout_XX属性会替换待加载布局文件的根节点对应的属性
 *
 * @Description:
 * @Author: ycwang
 * @Date: 2019/3/20 16:20
 */
public class LayoutTestActivity extends AppCompatActivity {
    ConstraintLayout includeTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_test);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.id_include_title);
        setSupportActionBar(mToolbar);


    }
}
