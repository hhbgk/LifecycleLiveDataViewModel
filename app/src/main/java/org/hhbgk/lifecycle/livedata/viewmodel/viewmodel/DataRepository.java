package org.hhbgk.lifecycle.livedata.viewmodel.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.hhbgk.lifecycle.livedata.viewmodel.bean.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Des:
 * Author: Bob
 * Date:21-1-20
 * UpdateRemark:
 */
public class DataRepository {
    final String tag = getClass().getSimpleName();
    private static DataRepository instance;
    private final MutableLiveData<List<UserInfo>> mGroups = new MutableLiveData<>();

    public static DataRepository getInstance() {
        if (instance == null) {
            synchronized (DataRepository.class) {
                if (null == instance) {
                    instance = new DataRepository();
                }
            }
        }
        return instance;
    }

    public DataRepository() {
        loadData();
    }

    private void loadData() {
        Log.i(tag, "loadData...");
        List<UserInfo> groups = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Jacky");
        userInfo.setAge(99);
        groups.add(userInfo);
        mGroups.setValue(groups);
    }

    public LiveData<List<UserInfo>> getUsers() {
        return mGroups;
    }
}
