package com.bob.dagger.example4;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bob.dagger.MainApplication;
import com.bob.dagger.R;
import com.bob.dagger.example4.di.LoginComponent;
import com.bob.dagger.example4.viewmodels.LoginViewModel;

import javax.inject.Inject;

/**
 * \@Inject + @Component + @Module + @Subcomponent 使用
 */
public class Example4Activity extends AppCompatActivity {
    private final String tag = getClass().getSimpleName();

    // Reference to the Login graph
    LoginComponent loginComponent;

    // Fields that need to be injected by the login graph
    @Inject
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example4);
        TextView textView = findViewById(R.id.text);
        textView.setText("Example4");

        loginComponent = MainApplication.getApplication().getExample4Component().getLoginComponent().build();
        loginComponent.inject(this);
        Log.e(tag, "loginViewModel =" + loginViewModel);
        if (loginViewModel != null) {
            loginViewModel.getUserRepository().setUserLocalDataSource();
        } else {
            Log.e(tag, "loginViewModel is null");
        }
    }
}