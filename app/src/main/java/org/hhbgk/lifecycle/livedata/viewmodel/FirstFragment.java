package org.hhbgk.lifecycle.livedata.viewmodel;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import org.hhbgk.lifecycle.livedata.viewmodel.bean.UserInfo;
import org.hhbgk.lifecycle.livedata.viewmodel.livedata.UserLiveData;
import org.hhbgk.lifecycle.livedata.viewmodel.viewmodel.DataRepository;
import org.hhbgk.lifecycle.livedata.viewmodel.viewmodel.MainViewModel;

import java.util.List;


public class FirstFragment extends Fragment {
    final String tag = getClass().getSimpleName();
    public static FirstFragment newInstance() {
        return new FirstFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MainViewModel viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        final UserLiveData userLiveData = viewModel.getUserLiveData();

        final TextView textView = getView().findViewById(R.id.first_textId);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfo userInfo = new UserInfo();
                userInfo.setName("Bob");
                userInfo.setAge(22);
                userLiveData.setValue(userInfo);
            }
        });

        // method 1:
        userLiveData.observe(this, new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo o) {
                textView.setText("First fragment:" + o);
            }
        });

        // method 2:
        DataRepository.getInstance().getUsers().observe(getViewLifecycleOwner(), new Observer<List<UserInfo>>() {
            @Override
            public void onChanged(List<UserInfo> userInfos) {
                Log.e(tag, "userInfos size=" + userInfos.size());
                for (UserInfo userInfo : userInfos) {
                    Log.i(tag, "username=" + userInfo.getName());
                }
            }
        });
    }
}
