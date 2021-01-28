package com.bob.dagger.example4.di;

import com.bob.dagger.example4.Example4Activity;
import com.bob.dagger.example4.LoginUsernameFragment;

import dagger.Subcomponent;

/**
 * Des:
 * Author: Bob
 * Date:21-1-28
 * UpdateRemark:
 */
@Subcomponent
public interface LoginComponent {
    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Builder
    interface Factory {
        LoginComponent build();
    }

    void inject(Example4Activity activity);
    void inject(LoginUsernameFragment fragment);
}
