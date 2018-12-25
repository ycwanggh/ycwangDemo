package com.demo.ycwang.data.remote.http;

import android.text.TextUtils;

import com.demo.ycwang.data.BuildConfig;
import com.demo.ycwang.data.remote.http.api.API;
import com.demo.ycwang.data.remote.http.response.Result;
import com.demo.ycwang.data.remote.http.response.UserBean;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 15:25
 */
public class RemoteDataManager implements RemoteDataHelper {
    public static final String SAVE_USER_LOGIN_KEY = "user/login";
    public static final String SAVE_USER_REGISTER_KEY = "user/register";
    public static final String SET_COOKIE_KEY = "set-cookie";
    public static final String COOKIE_NAME = "Cookie";

    public static final int TIME_OUT_READ = 20;
    public static final int TIME_OUT_CONNECT = 20;

    private API api;
    private String cookie;
    private static RemoteDataManager mInstance;

    public static RemoteDataManager getInstance() {
        if (mInstance == null) {
            synchronized (RemoteDataManager.class) {
                mInstance = new RemoteDataManager();
            }
        }
        return mInstance;
    }

    private RemoteDataManager() {
        final Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                if (!TextUtils.isEmpty(cookie)) {
                    builder.addHeader(RemoteDataManager.COOKIE_NAME, cookie);
                }
                return chain.proceed(builder.build());
            }
        };

        final Interceptor responseInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                final String requestUrl = request.url().toString();

                if ((requestUrl.contains(RemoteDataManager.SAVE_USER_LOGIN_KEY) || requestUrl.contains(RemoteDataManager.SAVE_USER_REGISTER_KEY))
                        && !response.headers(RemoteDataManager.SET_COOKIE_KEY).isEmpty()) {
//                    PrefHelper.set(RemoteDataManager.SAVE_USER_LOGIN_KEY,
//                            NetUtil.encodeCookie(response.headers(RemoteDataManager.SET_COOKIE_KEY)));
                }
                return response;
            }
        };

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(responseInterceptor)
                .addInterceptor(interceptor)
                .connectTimeout(RemoteDataManager.TIME_OUT_CONNECT, TimeUnit.SECONDS)
                .readTimeout(RemoteDataManager.TIME_OUT_READ, TimeUnit.SECONDS)
                .build();

        api = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(API.class);
    }


    @Override
    public void postLogin(String username, String password, Callback<Result<UserBean>> callback) {
        api.postLogin(username, password).enqueue(callback);
    }

    @Override
    public void postRegister(String username, String password, Callback<Result<UserBean>> callback) {
        api.postRegister(username, password, password).enqueue(callback);
    }
}
