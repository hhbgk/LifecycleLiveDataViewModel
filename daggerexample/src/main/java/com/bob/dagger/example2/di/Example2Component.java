package com.bob.dagger.example2.di;

import android.content.Context;
import android.view.View;

import com.bob.dagger.example2.Example2Activity;

import dagger.Component;

/**
 * Des:
 * Author: Bob
 * Date:21-1-27
 * UpdateRemark:
 */
@Component(modules = AppModule.class)
public interface Example2Component {
    //方式1
    View getView();
    //方式2，需要在Example2Activity添加@Inject来注解变量，适合用于多个依赖提供方
    void inject(Example2Activity activity);
}
