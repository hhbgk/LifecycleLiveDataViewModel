package com.bob.dagger.improve;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bob.dagger.R;
import com.bob.dagger.example1.bean.UserRemoteDataSource;
import com.bob.dagger.improve.viewmodel.BrowserViewModel;

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
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final BrowserViewModel viewModel = new ViewModelProvider(this, viewModelFactory).get(BrowserViewModel.class);
        viewModel.getBrowserLink().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.i(tag, "onChanged: s=" + s);
            }
        });
        Log.e(tag, "userRemoteDataSource =" + userRemoteDataSource);
        if (userRemoteDataSource != null) {
            Log.w(tag, "userRemoteDataSource not null");
        } else {
            Log.e(tag, "userRemoteDataSource is null");
        }
    }
}
