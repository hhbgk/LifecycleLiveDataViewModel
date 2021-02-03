package com.bob.dagger.improve.di;

import com.bob.dagger.improve.viewmodel.BrowserViewModel;
import com.bob.dagger.improve.viewmodel.DownloadViewModel;

import dagger.Subcomponent;

/**
 * Des:
 * Author: Bob
 * Date:21-2-1
 * UpdateRemark:
 */
@Subcomponent
public interface ViewModelSubcomponent {
    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Builder
    interface Factory {
        ViewModelSubcomponent build();
    }

//    void inject(BrowserFragment fragment);
//    void inject(DownloadFragment fragment);
    BrowserViewModel getBrowserViewModel();
    DownloadViewModel getDownloadViewModel();
}
