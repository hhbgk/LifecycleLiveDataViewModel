package com.bob.dagger.example3.di;

import android.content.Intent;

import com.bob.dagger.example3.viewmodule.LoginViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Des:
 * Author: Bob
 * Date:21-1-28
 * UpdateRemark:
 */
@Singleton
@Component(modules = IntentModule.class)
public interface Example3Component {
    LoginViewModel getLoginViewModel();
    Intent getIntent();
}
