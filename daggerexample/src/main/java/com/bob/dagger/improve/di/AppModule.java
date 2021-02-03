package com.bob.dagger.improve.di;

import androidx.lifecycle.ViewModelProvider;

import com.bob.dagger.improve.viewmodel.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Des:
 * Author: Bob
 * Date:21-2-1
 * UpdateRemark:
 */
@Module(subcomponents = ViewModelSubcomponent.class)
public class AppModule {
    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubcomponent.Factory viewModelSubComponent) {

        return new ViewModelFactory(viewModelSubComponent.build());
    }
}
