package com.bob.dagger.example2.di;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import dagger.Module;
import dagger.Provides;

/**
 * Des:
 * Author: Bob
 * Date:21-1-27
 * UpdateRemark:
 */

@Module
public class AppModule {
    final String tag = getClass().getSimpleName();
    private final Context mContext;

    public AppModule(final Context context) {
        Log.e(tag, "Create AppModule:" +context);
        this.mContext = context.getApplicationContext();
    }

    @Provides
    public View provideView(Context context) {
        Log.e(tag, "provideView:" + context);
        return new TextView(context);
    }

    /**
     * 因为provideView所依赖的View又依赖了Context，所以这里也要把Context管理起来
     * 同理，如果这个Context还依赖了别的类，也要在这里引入
     * @return context
     */
    @Provides
    public Context provideContext() {
        Log.e(tag, "provideContext:" + mContext);
        return mContext;
    }
}
