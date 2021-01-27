package com.bob.dagger.example1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bob.dagger.MainApplication;
import com.bob.dagger.R;
import com.bob.dagger.example1.bean.UserLocalDataSource;

import javax.inject.Inject;

/**
 * \@Inject + \@Component使用
 */
public class Example1Activity extends AppCompatActivity {
    private final String tag = getClass().getSimpleName();
//-----------方式1 start-------------
    @Inject
    UserLocalDataSource userLocalDataSource;
    @Inject
    UserRepository userRepository;
//-----------方式1 end-------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);
        TextView textView = findViewById(R.id.text);
        textView.setText("Example1");

        MainApplication mainApplication = MainApplication.getApplication();
//-----------方式1 start-------------
        mainApplication.getApplicationGraph().inject(this);
        if (userLocalDataSource != null) {
            Log.i(tag, "userLocalDataSource=" + userLocalDataSource);
        } else {
            Log.e(tag, "userLocalDataSource is null");
        }

        if (userRepository != null) {
            Log.i(tag, "userRepository=" + userRepository);
        } else {
            Log.e(tag, "userRepository is null");
        }
//-----------方式1 end-------------

        //-----------方式2 start-------------
//        UserRepository userRepository = mainApplication.getApplicationGraph().getUserRepository();
//        Log.i(tag, "userRepository=" + userRepository);
//        userRepository.setUserLocalDataSource();
        //-----------方式2 end-------------
    }
}