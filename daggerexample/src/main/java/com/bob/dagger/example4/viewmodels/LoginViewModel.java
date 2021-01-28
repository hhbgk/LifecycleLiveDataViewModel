package com.bob.dagger.example4.viewmodels;

import com.bob.dagger.example1.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Des:
 * Author: Bob
 * Date:21-1-28
 * UpdateRemark:
 */

public class LoginViewModel {
    private final UserRepository userRepository;

    // @Inject tells Dagger how to create instances of LoginViewModel
    @Inject
    public LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
