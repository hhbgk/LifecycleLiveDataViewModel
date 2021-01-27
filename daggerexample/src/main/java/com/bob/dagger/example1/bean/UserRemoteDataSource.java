package com.bob.dagger.example1.bean;

import android.util.Log;

import javax.inject.Inject;

/**
 * Des:
 * Author: Bob
 * Date:21-1-26
 * UpdateRemark:
 */
public class UserRemoteDataSource {
    final String tag = getClass().getSimpleName();
    @Inject
    public UserRemoteDataSource() {
        Log.e(tag, "create " + tag);
    }
}
