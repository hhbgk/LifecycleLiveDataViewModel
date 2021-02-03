package com.bob.dagger.improve.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bob.dagger.example1.UserRepository;

import javax.inject.Inject;

/**
 * Des:
 * Author: Bob
 * Date:21-2-1
 * UpdateRemark:
 */
public class BrowserViewModel extends AndroidViewModel {
    private final MutableLiveData<String> mBrowserLinks = new MutableLiveData<>();

    @Inject
    public BrowserViewModel(@NonNull Application application, UserRepository repository) {
        super(application);

    }

    public LiveData<String> getBrowserLink() {
        return mBrowserLinks;
    }
}
