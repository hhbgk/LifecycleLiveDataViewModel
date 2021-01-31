package com.bob.dagger.improve;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.bob.dagger.R;
import com.bob.dagger.example1.bean.UserRemoteDataSource;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * Des:
 * Author: Bob
 * Date:21-1-31
 * UpdateRemark:
 */
public class BrowserFragment extends DaggerFragment {
    private final String tag = getClass().getSimpleName();

    @Inject
    UserRemoteDataSource userRemoteDataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(tag, "userRemoteDataSource =" + userRemoteDataSource);
        if (userRemoteDataSource != null) {
            Log.w(tag, "userRemoteDataSource not null");
        } else {
            Log.e(tag, "userRemoteDataSource is null");
        }
    }
}
