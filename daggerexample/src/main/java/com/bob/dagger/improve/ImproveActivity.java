package com.bob.dagger.improve;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        if (textView == null) Log.e(tag, "text view is null");
        textView.setText("Hello " + tag);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ImproveActivity.this, HelloActivity.class));
            }
        });

        Log.e(tag, "userRepository=" + userRepository);
        if (userRepository != null) {
            userRepository.setUserLocalDataSource();
        } else {
            Log.e(tag, "userRepository is null");
        }
    }
}