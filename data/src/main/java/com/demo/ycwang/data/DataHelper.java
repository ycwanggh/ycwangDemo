package com.demo.ycwang.data;

import com.demo.ycwang.data.local.LocalDataUserHelper;
import com.demo.ycwang.data.remote.http.RemoteDataHelper;

/**
 * @Author: ycwang
 * @Date: 2018-12-21 10:57
 */
public interface DataHelper extends LocalDataUserHelper, RemoteDataHelper {
}
