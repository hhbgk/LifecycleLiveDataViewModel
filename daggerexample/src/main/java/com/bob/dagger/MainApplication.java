package com.bob.dagger;

import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;

/**
 * Des:
 * Author: Bob
 * Date:21-1-26
 * UpdateRemark:
 */
public class MainApplication extends Application {
    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
