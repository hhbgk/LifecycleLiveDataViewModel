package com.bob.dagger.improve.di;

import android.app.Application;

import com.bob.dagger.MainApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Des:
 * Author: Bob
 * Date:21-1-28
 * UpdateRemark:
 */
@Singleton
@Component(modules = {ActivityModule.class, AndroidInjectionModule.class, AppModule.class})
public interface AppComponent extends AndroidInjector<MainApplication> {
    @Component.Builder
    interface Builder {
        AppComponent create();
        @BindsInstance
        Builder application(Application application);

    }
    void inject(MainApplication application);
}
