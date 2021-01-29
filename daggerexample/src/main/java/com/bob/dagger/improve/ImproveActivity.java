package com.bob.dagger.improve;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bob.dagger.BaseActivity;
import com.bob.dagger.R;
import com.bob.dagger.example1.UserRepository;

import javax.inject.Inject;

public class ImproveActivity extends BaseActivity {
    @Inject
    UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);
        TextView textView = findViewById(R.id.text);
        textView.setText("Hello " + tag);

        if (userRepository != null) {
            userRepository.setUserLocalDataSource();
        } else {
            Log.e(tag, "userRepository is null");
        }
    }
}