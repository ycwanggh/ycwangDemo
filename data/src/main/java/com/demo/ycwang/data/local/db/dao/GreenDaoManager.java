package com.demo.ycwang.data.local.db.dao;


import android.content.Context;

import com.demo.ycwang.data.local.db.greenDao.DaoMaster;
import com.demo.ycwang.data.local.db.greenDao.DaoSession;
import com.demo.ycwang.data.local.prefs.utils.Constance;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 14:39
 */
public class GreenDaoManager implements GreenDaoHelper {

    private DaoSession daoSession;

    public GreenDaoManager(Context context) {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(context, Constance.DB_MESSAGE);
        Database db = openHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }


    public <T> T getDao(Class<? extends Object> entityClass) {
        return (T) daoSession.getDao(entityClass);
    }

    @Override
    public void insert(Object object) {
        Class cls;
        if (object instanceof List) {
            List listObject = (List) object;
            if (listObject.isEmpty()) {
                throw new IllegalArgumentException("List Object Not Allow Empty!");
            }
            cls = listObject.get(0).getClass();
            ((AbstractDao<Object, String>) getDao(cls)).insertInTx(listObject.iterator());
        } else {
            cls = object.getClass();
            ((AbstractDao<Object, String>) getDao(cls)).insert(object);
        }
    }

    @Override
    public void insertOrUpdate(Object object) {
        Class cls;
        if (object instanceof List) {
            List listObject = (List) object;
            if (listObject.isEmpty()) {
                throw new IllegalArgumentException("List Object Not Allow Empty!");
            }
            cls = listObject.get(0).getClass();
            ((AbstractDao<Object, String>) getDao(cls)).insertOrReplaceInTx(listObject.iterator());
        } else {
            cls = object.getClass();
            ((AbstractDao<Object, String>) getDao(cls)).insertOrReplace(object);
        }
    }

    @Override
    public void update(Object object) {
        Class cls;
        if (object instanceof List) {
            List listObject = (List) object;
            if (listObject.isEmpty()) {
                throw new IllegalArgumentException("List Object Not Allow Empty!");
            }
            cls = listObject.get(0).getClass();
            ((AbstractDao<Object, String>) getDao(cls)).updateInTx(listObject.iterator());
        } else {
            cls = object.getClass();
            ((AbstractDao<Object, String>) getDao(cls)).update(object);
        }
    }

    @Override
    public void delete(Object object) {
        Class cls;
        if (object instanceof List) {
            List listObject = (List) object;
            if (listObject.isEmpty()) {
                throw new IllegalArgumentException("List Object Not Allow Empty!");
            }
            cls = listObject.get(0).getClass();
            ((AbstractDao<Object, String>) getDao(cls)).deleteInTx(listObject.iterator());
        } else {
            cls = object.getClass();
            ((AbstractDao<Object, String>) getDao(cls)).delete(object);
        }
    }

    @Override
    public void deleteByKey(Class<?> classType, String id) {
        ((AbstractDao<Object, String>) getDao(classType)).deleteByKey(id);
    }

    @Override
    public void deleteAll(Class<?> classType) {
        ((AbstractDao<Object, String>) getDao(classType)).deleteAll();
    }

    @Override
    public <T> T queryByKey(Class<T> classType, String id) {
        return ((AbstractDao<T, String>) getDao(classType)).load(id);
    }

    @Override
    public <T> List<T> query(Class<T> classType, String where, String... selectionArg) {
        return ((AbstractDao<T, String>) getDao(classType)).queryRaw(where, selectionArg);
    }

    @Override
    public <T> List<T> queryAll(Class<T> classType) {
        return ((AbstractDao<T, String>) getDao(classType)).loadAll();
    }
}
