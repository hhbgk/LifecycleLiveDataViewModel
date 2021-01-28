package com.bob.dagger.example4.di;

import android.util.Log;

import java.net.NetPermission;

import dagger.Module;
import dagger.Provides;

/**
 * Des:
 * Author: Bob
 * Date:21-1-28
 * UpdateRemark:
 */
@Module
public class NetworkModule {

    @Provides
    public NetPermission provideNetPermission() {
        Log.w("NetworkModule", "provideNetPermission");
        return new NetPermission("net permission");
    }
}
