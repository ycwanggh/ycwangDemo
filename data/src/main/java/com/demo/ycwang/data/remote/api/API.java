package com.demo.ycwang.data.remote.api;

import com.demo.ycwang.data.remote.response.Result;
import com.demo.ycwang.data.remote.response.UserBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 14:51
 */
public interface API {

    /**
     * 登录
     */
    @POST("user/login")
    @FormUrlEncoded
    Call<Result<UserBean>> postLogin(@Field("username") String username, @Field("password") String password);

    /**
     * 注册
     */
    @POST("user/register")
    @FormUrlEncoded
    Call<Result<UserBean>> postRegister(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);


}
