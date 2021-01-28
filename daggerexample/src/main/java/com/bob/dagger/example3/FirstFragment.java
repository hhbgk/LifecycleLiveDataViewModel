package com.bob.dagger.example3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bob.dagger.MainApplication;
import com.bob.dagger.R;
import com.bob.dagger.example3.di.Example3Component;
import com.bob.dagger.example3.viewmodule.LoginViewModel;

public class FirstFragment extends Fragment {
    private final String tag = getClass().getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Example3Component example2Component = MainApplication.getApplication().getExample3Component();
        LoginViewModel loginViewModel = example2Component.getLoginViewModel();
        Log.e(tag, "LoginViewModel =" + loginViewModel);
        if (loginViewModel != null) {
            loginViewModel.getUserRepository().setUserLocalDataSource();
            loginViewModel.getUserRepository().setUserRemoteDataSource();
        } else {
            Log.e(tag, "LoginViewModel is null");
        }
    }
}