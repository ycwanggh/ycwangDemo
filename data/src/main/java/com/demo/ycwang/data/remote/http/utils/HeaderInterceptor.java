package com.demo.ycwang.data.remote.http.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author: ycwang
 * @Date: 2018-12-26 9:45
 */
public class HeaderInterceptor implements Interceptor {


    public HeaderInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();

//        builder.addHeader(Constance.USER_ID, );


        return null;
    }
}
