package com.demo.ycwang.data.remote.callback;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 14:58
 */
public interface DataCallBack<T> {

    void finish();

    void success(T data);

    void error(int code, String message);


}
