package com.bob.dagger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bob.dagger.example1.Example1Activity;

public class MainActivity extends AppCompatActivity {
    private final String tag = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onExample1(View view) {
        startActivity(new Intent(this, Example1Activity.class));
    }

    public void onExample2(View view) {
    }
}