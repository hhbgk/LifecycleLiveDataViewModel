package com.bob.dagger.improve.di;

import com.bob.dagger.improve.BrowserFragment;
import com.bob.dagger.improve.DownloadFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Des:
 * Author: Bob
 * Date:21-1-31
 * UpdateRemark:
 */
@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract BrowserFragment contributeBrowserFragment();
    @ContributesAndroidInjector
    abstract DownloadFragment contributeDownloadFragment();
}
