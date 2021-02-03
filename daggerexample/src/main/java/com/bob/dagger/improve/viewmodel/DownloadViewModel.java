package com.bob.dagger.improve.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.bob.dagger.example1.UserRepository;

import javax.inject.Inject;

/**
 * Des:
 * Author: Bob
 * Date:21-2-1
 * UpdateRemark:
 */
public class DownloadViewModel extends AndroidViewModel {

    @Inject
    public DownloadViewModel(@NonNull Application application, UserRepository userRepository) {
        super(application);
    }
}
