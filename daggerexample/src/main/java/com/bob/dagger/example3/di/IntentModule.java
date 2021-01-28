package com.bob.dagger.example3.di;

import android.content.Intent;
import android.util.Log;

import java.util.Random;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Des:
 * Author: Bob
 * Date:21-1-28
 * UpdateRemark:
 */
@Module
public class IntentModule {

    @Provides
    @Singleton
    public Intent provideIntent() {
        Log.w("NetworkModule", "provideMessage");
        return new Intent("HelloWorld " + new Random().nextInt());
    }
}
