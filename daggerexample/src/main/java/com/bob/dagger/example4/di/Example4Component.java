package com.bob.dagger.example4.di;

import dagger.Component;

/**
 * Des:
 * Author: Bob
 * Date:21-1-28
 * UpdateRemark:
 */
@Component(modules = {ViewModelModule.class, NetworkModule.class})
public interface Example4Component {
    LoginComponent.Factory getLoginComponent();
}
