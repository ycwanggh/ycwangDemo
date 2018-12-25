package com.demo.ycwang.data.remote.http.callback;

import com.demo.ycwang.data.remote.http.response.Result;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @Author: ycwang
 * @Date: 2018-12-25 15:09
 */
public class CallBackHandler {

    public static <T extends Result> Callback<T> getCallBack(final boolean isEnd, final DataCallBack<T> dataCallback) {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (isEnd) {
                    return;
                }
                dataCallback.finish();
                final Result result = response.body();
                if (result.code == 0) {
                    dataCallback.success(response.body());
                } else {
                    dataCallback.error(result.code, result.message);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (isEnd) {
                    return;
                }
                dataCallback.finish();
                String errMsg;
                if (t instanceof UnknownHostException || t instanceof ConnectException) {
                    errMsg = "网络连接异常";
                } else if (t instanceof TimeoutException || t instanceof SocketTimeoutException) {
                    errMsg = "网络连接超时";
                } else {
                    errMsg = t.getMessage();
                }
                dataCallback.error(-200, errMsg);
            }
        };
    }

}
