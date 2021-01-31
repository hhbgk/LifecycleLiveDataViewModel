package com.bob.dagger;

import com.bob.dagger.example1.ApplicationGraph;
import com.bob.dagger.example1.DaggerApplicationGraph;
import com.bob.dagger.example3.di.DaggerExample3Component;
import com.bob.dagger.example3.di.Example3Component;
import com.bob.dagger.example4.di.DaggerExample4Component;
import com.bob.dagger.example4.di.Example4Component;
import com.bob.dagger.improve.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;

/**
 * Des:
 * Author: Bob
 * Date:21-1-26
 * UpdateRemark:
 */
public class MainApplication extends DaggerApplication {
    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;
    private static MainApplication sApplication;
    private ApplicationGraph applicationGraph;
    private Example3Component example3Component;
    private Example4Component example4Component;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        applicationGraph = DaggerApplicationGraph.create();
        example3Component = DaggerExample3Component.create();
        example4Component = DaggerExample4Component.create();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).create();
    }

    public static MainApplication getApplication() {
        return sApplication;
    }

    public ApplicationGraph getApplicationGraph() {
        return applicationGraph;
    }

    public Example3Component getExample3Component() {
        return example3Component;
    }
    public Example4Component getExample4Component() {
        return example4Component;
    }
}
