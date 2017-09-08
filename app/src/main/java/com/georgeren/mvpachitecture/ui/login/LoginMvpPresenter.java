package com.georgeren.mvpachitecture.ui.login;

import com.georgeren.mvpachitecture.di.PerActivity;
import com.georgeren.mvpachitecture.ui.base.MvpPresenter;

/**
 * Created by georgeRen on 2017/9/5.
 * 局部共享
 */
@PerActivity
public interface LoginMvpPresenter <V extends LoginMvpView> extends MvpPresenter<V> {
    void onServerLoginClick(String email, String password);

    void onGoogleLoginClick();

    void onFacebookLoginClick();
}
