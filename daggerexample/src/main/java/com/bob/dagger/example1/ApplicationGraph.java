package com.bob.dagger.example1;

import dagger.Component;

/**
 * Des:
 * Author: Bob
 * Date:21-1-26
 * UpdateRemark:
 */
@Component
public interface ApplicationGraph {
    void inject(Example1Activity example1Activity);
    UserRepository userRepository();
}
