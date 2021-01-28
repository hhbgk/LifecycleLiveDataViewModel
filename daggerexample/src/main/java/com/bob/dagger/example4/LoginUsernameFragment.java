package com.bob.dagger.example4;

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
import com.bob.dagger.example3.viewmodule.DisplayViewModel;
import com.bob.dagger.example4.di.Example4Component;
import com.bob.dagger.example4.viewmodels.LoginViewModel;

import javax.inject.Inject;

public class LoginUsernameFragment extends Fragment {
    private final String tag = getClass().getSimpleName();
    @Inject
    LoginViewModel loginViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Example4Component component = MainApplication.getApplication().getExample4Component();
        component.getLoginComponent().build().inject(this);
        Log.e(tag, "loginViewModel =" + loginViewModel);
        if (loginViewModel != null) {
            loginViewModel.getUserRepository().setUserLocalDataSource();
            loginViewModel.getUserRepository().setUserRemoteDataSource();
        } else {
            Log.e(tag, "displayViewModel is null");
        }
    }
}