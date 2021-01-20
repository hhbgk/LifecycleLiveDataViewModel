package org.hhbgk.lifecycle.livedata.viewmodel.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import org.hhbgk.lifecycle.livedata.viewmodel.livedata.UserLiveData;

public class MainViewModel extends ViewModel {
    final String tag = getClass().getSimpleName();
    private final UserLiveData userLiveData = new UserLiveData();

    public MainViewModel() {
        Log.e(tag, "Create MainViewModel......");
    }

    public UserLiveData getUserLiveData() {
        return userLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e(tag, "onCleared!!");
    }
}
