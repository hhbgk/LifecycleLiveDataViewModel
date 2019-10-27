package org.hhbgk.lifecycle.livedata.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.hhbgk.lifecycle.livedata.viewmodel.bean.UserInfo;
import org.hhbgk.lifecycle.livedata.viewmodel.lifecycle.MainPresenter;
import org.hhbgk.lifecycle.livedata.viewmodel.livedata.UserLiveData;
import org.hhbgk.lifecycle.livedata.viewmodel.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textId);


        getLifecycle().addObserver(new MainPresenter());

        final MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        final UserLiveData<UserInfo> userLiveData = viewModel.getUserLiveData();
        userLiveData.observe(this, new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo userInfo) {
                textView.setText("Main:" + userInfo);
            }
        });


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfo user = new UserInfo();
                user.setAge(20);
                user.setName("James");
                userLiveData.setValue(user);
            }
        });
    }
}
