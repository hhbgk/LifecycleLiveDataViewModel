package com.bob.dagger;

import android.app.Application;

import com.bob.dagger.example1.ApplicationGraph;
import com.bob.dagger.example1.DaggerApplicationGraph;
import com.bob.dagger.example3.di.DaggerExample3Component;
import com.bob.dagger.example3.di.Example3Component;

/**
 * Des:
 * Author: Bob
 * Date:21-1-26
 * UpdateRemark:
 */
public class MainApplication extends Application {

    private static MainApplication sApplication;
    private ApplicationGraph applicationGraph;
    private Example3Component example3Component;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        applicationGraph = DaggerApplicationGraph.create();
        example3Component = DaggerExample3Component.create();
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
}
