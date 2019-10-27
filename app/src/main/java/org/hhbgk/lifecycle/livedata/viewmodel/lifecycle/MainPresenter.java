package org.hhbgk.lifecycle.livedata.viewmodel.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MainPresenter implements LifecycleObserver {
    private String tag = getClass().getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void doSomething() {
        Log.i(tag, "Do something now!!");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void release() {
        Log.i(tag, "Done!!");
    }
}
