package com.demo.ycwang.data.local.db.dao;

import java.util.List;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 14:49
 */
public interface GreenDaoHelper {

    void insert(Object object);

    void insertOrUpdate(Object object);

    void update(Object object);

    void delete(Object object);

    void deleteByKey(Class<? extends Object> classType, String id);

    void deleteAll(Class<? extends Object> classType);

    <T> T queryByKey(Class<T> classType, String id);

    <T> List<T> query(Class<T> classType, String where, String... selectionArg);

    <T> List<T> queryAll(Class<T> classType);


}
