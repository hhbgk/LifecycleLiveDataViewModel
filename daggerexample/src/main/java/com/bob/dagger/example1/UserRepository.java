package com.bob.dagger.example1;

import android.util.Log;

import com.bob.dagger.example1.bean.UserLocalDataSource;
import com.bob.dagger.example1.bean.UserRemoteDataSource;

import javax.inject.Inject;

/**
 * Des:
 * Author: Bob
 * Date:21-1-26
 * UpdateRemark:
 */
public class UserRepository {
    final String tag = getClass().getSimpleName();
    private final UserLocalDataSource userLocalDataSource;
    private final UserRemoteDataSource userRemoteDataSource;

    @Inject
    public UserRepository(UserLocalDataSource userLocalDataSource, UserRemoteDataSource userRemoteDataSource) {
        Log.e(tag, "Create UserRepository");
        this.userLocalDataSource = userLocalDataSource;
        this.userRemoteDataSource = userRemoteDataSource;
    }

    public void setUserLocalDataSource() {
        Log.e(tag, "setUserLocalDataSource");
    }

    public void setUserRemoteDataSource() {
        Log.i(tag, "setUserRemoteDataSource");
    }
}
