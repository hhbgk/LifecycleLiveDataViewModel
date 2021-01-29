package com.bob.dagger.improve;

import android.app.Application;

import com.bob.dagger.MainApplication;

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
@Component(modules = {ActivityModule.class, AndroidInjectionModule.class})
public interface AppComponent extends AndroidInjector<MainApplication> {
    @Component.Builder
    interface Builder {
        AppComponent create();
        @BindsInstance
        Builder application(Application application);

    }
    void inject(MainApplication application);
}
