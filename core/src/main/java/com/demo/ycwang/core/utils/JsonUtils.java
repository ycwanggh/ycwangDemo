package com.demo.ycwang.core.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.Reader;
import java.lang.reflect.Type;

/**
 * json工具类
 *
 * @author lijianqing
 */

public final class JsonUtils {

    private static final Gson GSON = new GsonBuilder().create();

    private JsonUtils() {

    }

    /**
     * 对象转json
     */
    public static String beanToJson(final Object src) {
        return GSON.toJson(src);
    }

    /**
     * 对象转json
     */
    public static String beanToJson(final Object src, final Type typeOfSrc) {
        return GSON.toJson(src, typeOfSrc);
    }

    /**
     * json转对象
     */
    public static <T> T jsonToBean(final String json, final Class<T> classOfT) throws JSONException {
        try {
            return GSON.fromJson(json, classOfT);
        } catch (final JsonParseException e) {
            throw new JSONException(e.getMessage());
        }
    }

    /**
     * json转对象
     */
    public static <T> T jsonToBean(final String json, final Type typeOfT) throws JSONException {
        try {
            return GSON.fromJson(json, typeOfT);
        } catch (final JsonParseException e) {
            throw new JSONException(e.getMessage());
        }
    }

    /**
     * json转对象
     */
    public static <T> T jsonToBean(final Reader json, final Class<T> classOfT) throws JSONException {
        try {
            return GSON.fromJson(json, classOfT);
        } catch (final JsonParseException e) {
            throw new JSONException(e.getMessage());
        }
    }

    /**
     * json转对象
     */
    public static <T> T jsonToBean(final JsonElement json, final Class<T> classOfT) throws JSONException {
        try {
            return GSON.fromJson(json, classOfT);
        } catch (final JsonParseException e) {
            throw new JSONException(e.getMessage());
        }
    }

    /**
     * json转对象
     */
    public static <T> T jsonToBean(final JsonElement json, final Type typeOfT) throws JSONException {
        try {
            return GSON.fromJson(json, typeOfT);
        } catch (final JsonParseException e) {
            throw new JSONException(e.getMessage());
        }
    }

}
