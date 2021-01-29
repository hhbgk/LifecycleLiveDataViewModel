package com.bob.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity {
    protected String tag = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }
}