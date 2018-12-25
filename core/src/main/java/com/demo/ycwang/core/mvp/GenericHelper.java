package com.demo.ycwang.core.mvp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: ycwang
 * @Date: 2018-12-25 10:27
 */
public class GenericHelper {


    public static <T> Class<T> getGenericClass(Class<?> klass, Class<?> filterClass) {
        Type type = klass.getGenericSuperclass();
        if (!(type instanceof ParameterizedType)) return null;
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] types = parameterizedType.getActualTypeArguments();
        for (Type t : types) {
            Class<T> tClass = (Class<T>) t;
            if (filterClass.isAssignableFrom(tClass)) {
                return tClass;
            }
        }
        return null;
    }

    private static Class<?> getViewClass(Class<?> klass, Class<?> filterClass) {
        for (Class c : klass.getInterfaces()) {
            if (filterClass.isAssignableFrom(c)) return klass;
        }
        return getViewClass(klass.getSuperclass(), filterClass);
    }


    public static <T> T newPresenter(Object obj) {
        if (!BaseContract.View.class.isInstance(obj)) {
            throw new RuntimeException("no implement XContract.BaseView");
        }
        try {
            Class<?> currentClass = obj.getClass();
            Class<?> viewClass = getViewClass(currentClass, BaseContract.View.class);
            Class<?> presenterClass = getGenericClass(viewClass, BaseContract.Presenter.class);
            Class<?> modelClass = getGenericClass(presenterClass, BaseContract.Model.class);
            BasePresenter<?, ?> basePresenter = (BasePresenter<?, ?>) presenterClass.newInstance();
            basePresenter.init(obj, modelClass.newInstance());
            return (T) basePresenter;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("instance of presenter fail\n" +
                " Remind presenter need to extends basePresenter");
    }

}
