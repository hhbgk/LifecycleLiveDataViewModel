package com.bob.dagger.improve;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract ImproveActivity contributeImproveActivity();
}
