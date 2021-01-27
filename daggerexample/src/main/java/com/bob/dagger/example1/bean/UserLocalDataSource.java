package com.bob.dagger.example1.bean;

import android.util.Log;

import javax.inject.Inject;

/**
 * Des:
 * Author: Bob
 * Date:21-1-26
 * UpdateRemark:
 */
public class UserLocalDataSource {
    final String tag = getClass().getSimpleName();
    @Inject
    public UserLocalDataSource() {
        Log.e(tag, "create " + tag);
    }
}
