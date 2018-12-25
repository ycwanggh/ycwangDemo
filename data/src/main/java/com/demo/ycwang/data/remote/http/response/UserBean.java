package com.demo.ycwang.data.remote.http.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 14:55
 */
public class UserBean {

    @SerializedName("email")
    public String email;

    @SerializedName("icon")
    public String icon;

    @SerializedName("id")
    public int id;

    @SerializedName("type")
    public int type;

    @SerializedName("username")
    public String username;

    @SerializedName("collectIds")
    public List<Integer> collectIds;

}
