package com.demo.ycwang.data.remote.response;

import com.demo.ycwang.data.remote.RemoteDataManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author: ycwang
 * @Date: 2018-12-26 9:58
 */
public class ResponseInterceptor implements Interceptor {

    public static final String SAVE_USER_LOGIN_KEY = "user/login";
    public static final String SAVE_USER_REGISTER_KEY = "user/register";
    public static final String SET_COOKIE_KEY = "set-cookie";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Response response = chain.proceed(request);
        final String requestUrl = request.url().toString();

        if ((requestUrl.contains(SAVE_USER_LOGIN_KEY) || requestUrl.contains(SAVE_USER_REGISTER_KEY))
                && !response.headers(SET_COOKIE_KEY).isEmpty()) {
            // TODO 拦截
        }
        return response;
    }
}
