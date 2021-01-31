package com.bob.dagger.improve;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bob.dagger.R;
import com.bob.dagger.example1.bean.UserLocalDataSource;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * Des:
 * Author: Bob
 * Date:21-1-31
 * UpdateRemark:
 */
public class DownloadFragment extends DaggerFragment {
    private final String tag = getClass().getSimpleName();

    @Inject
    UserLocalDataSource userLocalDataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView = getView().findViewById(R.id.tv_text);
        textView.setText(tag);
        Log.e(tag, "userLocalDataSource =" + userLocalDataSource);
        if (userLocalDataSource != null) {
            Log.w(tag, "userLocalDataSource not null");
        } else {
            Log.e(tag, "userLocalDataSource is null");
        }
    }
}
