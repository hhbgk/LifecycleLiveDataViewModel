package org.hhbgk.lifecycle.livedata.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.hhbgk.lifecycle.livedata.viewmodel.bean.UserInfo;
import org.hhbgk.lifecycle.livedata.viewmodel.livedata.UserLiveData;
import org.hhbgk.lifecycle.livedata.viewmodel.viewmodel.DataRepository;
import org.hhbgk.lifecycle.livedata.viewmodel.viewmodel.MainViewModel;

import java.util.List;

public class LiveActivity extends AppCompatActivity {
    final String tag = getClass().getSimpleName();
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        DataRepository.getInstance().getUsers().observe(this, new Observer<List<UserInfo>>() {
            @Override
            public void onChanged(List<UserInfo> userInfos) {
                Log.w(tag, "userInfos size=" + userInfos.size());
                for (UserInfo userInfo : userInfos) {
                    Log.w(tag, "username=" + userInfo.getName());
                }
            }
        });

        ViewModelProvider.Factory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        MainViewModel viewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

        final UserLiveData userLiveData = viewModel.getUserLiveData();
        userLiveData.observe(this, new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo userInfo) {
                Log.e(tag, "UserInfo onChanged:" + userInfo);
            }
        });

        Button button = findViewById(R.id.btn_live);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo = new UserInfo();
                userInfo.setName("Live " + (counter++));
                userInfo.setAge(counter);
                userLiveData.setValue(userInfo);
            }
        });
    }
}