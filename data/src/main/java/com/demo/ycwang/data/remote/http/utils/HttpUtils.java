package com.demo.ycwang.data.remote.http.utils;

import com.demo.ycwang.data.BuildConfig;
import com.demo.ycwang.data.remote.api.API;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: ycwang
 * @Date: 2018-12-26 10:02
 */
public class HttpUtils {

    private static final int TIME_OUT_READ = 20;
    private static final int TIME_OUT_CONNECT = 20;

    private HttpUtils() {
    }

    private static class SingletonInstance {
        private static final API INSTANCE = getAPI();
    }

    public static API getInstance() {
        return SingletonInstance.INSTANCE;
    }

    private static OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new ResponseInterceptor())
                .addInterceptor(new HeaderInterceptor())
                .connectTimeout(TIME_OUT_CONNECT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT_READ, TimeUnit.SECONDS)
                .build();
    }


    private static API getAPI() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(getOkHttpClient())
                .build()
                .create(API.class);
    }
}
