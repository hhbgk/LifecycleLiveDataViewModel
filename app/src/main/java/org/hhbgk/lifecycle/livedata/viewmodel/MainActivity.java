package org.hhbgk.lifecycle.livedata.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.hhbgk.lifecycle.livedata.viewmodel.bean.UserInfo;
import org.hhbgk.lifecycle.livedata.viewmodel.databinding.ActivityMainBinding;
import org.hhbgk.lifecycle.livedata.viewmodel.lifecycle.MainPresenter;
import org.hhbgk.lifecycle.livedata.viewmodel.livedata.UserLiveData;
import org.hhbgk.lifecycle.livedata.viewmodel.viewmodel.MainViewModel;

/**
 * 多个Fragment之间共享一个ViewModel对象: MainActivity、FirstFragment、SecondFragment
 */
public class MainActivity extends AppCompatActivity {
    private String tag = getClass().getSimpleName();
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getLifecycle().addObserver(new MainPresenter());

        final MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
//        final MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
//        ViewModelProvider.Factory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
//        MainViewModel viewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

        final UserLiveData userLiveData = viewModel.getUserLiveData();
        userLiveData.observe(this, new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo userInfo) {
                Log.e("MainActivity", "UserInfo onChanged");
                binding.tvLogInfo.setText("Main:" + userInfo);
            }
        });


        binding.btnGoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LiveActivity.class));
            }
        });
    }
}
