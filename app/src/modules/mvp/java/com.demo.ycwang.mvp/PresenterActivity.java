package com.demo.ycwang.mvp;

import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.demo.ycwang.core.mvp.BasePresenterActivity;
import com.demo.ycwang.ycwangdemo.R;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 11:29
 */
public class PresenterActivity extends BasePresenterActivity<LoginPresenter> implements LoginContract.View {

    private Button mBtnSwitch;
    private Button mBtnConfirm;
    private EditText mEtAccount;
    private EditText mEtPassword;
    private View mLayoutContainer;
    private ProgressBar mProgressBar;

    @Override
    protected void initData() {
        mBtnSwitch = findViewById(R.id.btnSwitch);
        mBtnConfirm = findViewById(R.id.btnConfirm);
        mProgressBar = findViewById(R.id.progressBar);
        mEtAccount = findViewById(R.id.account);
        mEtPassword = findViewById(R.id.password);
        mLayoutContainer = findViewById(R.id.layoutContainer);
        mBtnSwitch.setPaintFlags(mBtnSwitch.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        mBtnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLoginPage()) {
                    switchToRegister();
                } else {
                    switchToLogin();
                }
            }
        });

        mBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLoginPage()) {
                    presenter.requestLogin(mEtAccount.getText().toString(), mEtPassword.getText().toString());
                } else {
                    presenter.requestRegister(mEtAccount.getText().toString(), mEtPassword.getText().toString());
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_activity_login;
    }

    @Override
    public void displayProgress() {
        mLayoutContainer.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgress() {
        mProgressBar.setVisibility(View.GONE);
        mLayoutContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void switchToLogin() {
        mBtnSwitch.setText("注册");
        mBtnConfirm.setText("登陆");
    }

    @Override
    public void switchToRegister() {
        mBtnSwitch.setText("登陆");
        mBtnConfirm.setText("注册");
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isLoginPage() {
        return mBtnSwitch.getText().toString().equals("注册");
    }
}
