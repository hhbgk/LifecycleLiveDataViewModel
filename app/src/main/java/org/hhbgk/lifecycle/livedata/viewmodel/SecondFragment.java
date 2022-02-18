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


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final TextView textView = getView().findViewById(R.id.second_textId);
        //Only current fragment
//        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        //
        MainViewModel viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        final UserLiveData userInfoUserLiveData = viewModel.getUserLiveData();

        userInfoUserLiveData.observe(getViewLifecycleOwner(), new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo userInfo) {
                textView.setText("Second Fragment:" + userInfo);
            }
        });


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfo userInfo = new UserInfo();
                userInfo.setAge(23);
                userInfo.setName("Tom");
                userInfoUserLiveData.setValue(userInfo);
            }
        });
    }
}
