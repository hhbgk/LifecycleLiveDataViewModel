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
    //方式1
    void inject(Example1Activity example1Activity);
    //方式2
    UserRepository getUserRepository();

}
