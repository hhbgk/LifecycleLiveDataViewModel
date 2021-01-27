package com.bob.dagger;

import android.app.Application;

import com.bob.dagger.example1.ApplicationGraph;
import com.bob.dagger.example1.DaggerApplicationGraph;
import com.bob.dagger.example2.DaggerExample2Component;
import com.bob.dagger.example2.Example2Component;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;

/**
 * Des:
 * Author: Bob
 * Date:21-1-26
 * UpdateRemark:
 */
public class MainApplication extends Application {

    private static MainApplication sApplication;
    private ApplicationGraph applicationGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        applicationGraph = DaggerApplicationGraph.create();
    }

    public static MainApplication getApplication() {
        return sApplication;
    }

    public ApplicationGraph getApplicationGraph() {
        return applicationGraph;
    }
}
