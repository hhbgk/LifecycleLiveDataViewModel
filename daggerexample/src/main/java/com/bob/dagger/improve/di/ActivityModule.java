package com.bob.dagger.improve.di;


import com.bob.dagger.improve.HelloActivity;
import com.bob.dagger.improve.ImproveActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract ImproveActivity contributeImproveActivity();
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract HelloActivity contributeHelloActivity();
}
