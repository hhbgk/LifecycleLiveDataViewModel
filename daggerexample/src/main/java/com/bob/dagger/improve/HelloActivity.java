package com.bob.dagger.improve;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bob.dagger.BaseActivity;
import com.bob.dagger.R;
import com.bob.dagger.example1.UserRepository;

import javax.inject.Inject;

/**
 * Des:
 * Author: Bob
 * Date:21-1-31
 * UpdateRemark:
 */
public class HelloActivity extends BaseActivity {
    @Inject
    UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve);
        final TextView textView = findViewById(R.id.text);
        textView.setText(tag);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new DownloadFragment());
                textView.setClickable(false);
            }
        });

        Log.e(tag, "userRepository=" + userRepository);
        if (userRepository != null) {
            Log.w(tag, "UserLocalDataSource not null");
        } else {
            Log.e(tag, "UserLocalDataSource is null");
        }

        if (savedInstanceState == null) {
            changeFragment(new BrowserFragment());
        }
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }
}
