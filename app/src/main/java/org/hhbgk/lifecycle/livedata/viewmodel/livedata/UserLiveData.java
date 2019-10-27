package org.hhbgk.lifecycle.livedata.viewmodel.livedata;

import androidx.lifecycle.LiveData;


public class UserLiveData<UserInfo> extends LiveData<UserInfo> {


    @Override
    public void postValue(UserInfo value) {
        super.postValue(value);
    }

    @Override
    public void setValue(UserInfo value) {
        super.setValue(value);
    }
}
