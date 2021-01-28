package com.bob.dagger.example3.viewmodule;

import com.bob.dagger.example1.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Des:
 * Author: Bob
 * Date:21-1-28
 * UpdateRemark:
 */
@Singleton
public class DisplayViewModel {
    private final UserRepository userRepository;

    // @Inject tells Dagger how to create instances of LoginViewModel
    @Inject
    public DisplayViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
