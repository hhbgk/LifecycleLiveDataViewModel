package org.hhbgk.lifecycle.livedata.viewmodel;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.hhbgk.lifecycle.livedata.viewmodel.bean.UserInfo;
import org.hhbgk.lifecycle.livedata.viewmodel.livedata.UserLiveData;
import org.hhbgk.lifecycle.livedata.viewmodel.viewmodel.MainViewModel;


public class FirstFragment extends Fragment {

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
        final UserLiveData<UserInfo> userLiveData = viewModel.getUserLiveData();

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

        userLiveData.observe(this, new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo o) {
                textView.setText("First fragment:" + o);
            }
        });
    }
}
