package org.hhbgk.lifecycle.livedata.viewmodel.viewmodel;

import androidx.lifecycle.ViewModel;

import org.hhbgk.lifecycle.livedata.viewmodel.bean.UserInfo;
import org.hhbgk.lifecycle.livedata.viewmodel.livedata.UserLiveData;

public class MainViewModel extends ViewModel {

    private UserLiveData<UserInfo> userLiveData = new UserLiveData<>();


    public UserLiveData<UserInfo> getUserLiveData() {
        return userLiveData;
    }
}
