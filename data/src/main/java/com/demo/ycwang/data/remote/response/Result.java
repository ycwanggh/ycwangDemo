package com.demo.ycwang.data.remote.response;

import com.google.gson.annotations.SerializedName;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 14:55
 */
public class Result<T> {

    @SerializedName("message")
    public String message;

    @SerializedName("code")
    public int code;

    @SerializedName("data")
    public T data;

}
