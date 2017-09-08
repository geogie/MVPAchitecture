package com.georgeren.mvpachitecture.ui.splash;

import com.georgeren.mvpachitecture.ui.base.MvpView;

/**
 * Created by georgeRen on 2017/9/1.
 * v：splash
 */

public interface SplashMvpView extends MvpView{
    void openLoginActivity();

    void openMainActivity();

    void startSyncService();
}
