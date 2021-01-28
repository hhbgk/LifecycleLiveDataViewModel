package com.bob.dagger.example3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bob.dagger.MainApplication;
import com.bob.dagger.R;
import com.bob.dagger.example3.di.Example3Component;
import com.bob.dagger.example3.viewmodule.LoginViewModel;

import javax.inject.Inject;

/**
 * \@Inject + @Component + @Module + @Singleton使用
 */
public class Example3Activity extends AppCompatActivity {
    private final String tag = getClass().getSimpleName();

    @Inject
    LoginViewModel loginViewModel;
    @Inject
    LoginViewModel loginViewModel2;
    @Inject
    Intent intent;
    @Inject
    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example3);
        TextView textView = findViewById(R.id.text);
        textView.setText("Example3");

        Example3Component example2Component = MainApplication.getApplication().getExample3Component();
        loginViewModel = example2Component.getLoginViewModel();
        loginViewModel2 = example2Component.getLoginViewModel();
        Log.e(tag, "LoginViewModel =" + loginViewModel);
        Log.e(tag, "LoginViewModel2=" + loginViewModel2);
        if (loginViewModel != null) {
            loginViewModel.getUserRepository().setUserLocalDataSource();
            loginViewModel.getUserRepository().setUserRemoteDataSource();
        } else {
            Log.e(tag, "LoginViewModel is null");
        }

        intent = example2Component.getIntent();
        intent2 = example2Component.getIntent();
        Log.w(tag, "intent =" + intent);
        Log.w(tag, "intent2=" + intent2);
        if (intent != null) {
            Log.w(tag, "intent=" + intent.getAction());
        } else {
            Log.e(tag, "intent is null");
        }
    }
}