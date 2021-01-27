package com.bob.dagger.example1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.bob.dagger.R;
import com.bob.dagger.example1.bean.UserLocalDataSource;

import javax.inject.Inject;

public class Example1Activity extends AppCompatActivity {
    private final String tag = getClass().getSimpleName();

    @Inject
    UserLocalDataSource userLocalDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        ApplicationGraph applicationGraph = DaggerApplicationGraph.builder().build();
        applicationGraph.inject(this);
        UserRepository userRepository = applicationGraph.userRepository();
        Log.i(tag, "userRepository=" + userRepository);
        Log.i(tag, "userLocalDataSource=" + userLocalDataSource);
        userRepository.setUserLocalDataSource();
    }
}