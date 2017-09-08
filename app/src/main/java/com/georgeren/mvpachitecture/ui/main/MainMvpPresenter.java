package com.georgeren.mvpachitecture.ui.main;

import com.georgeren.mvpachitecture.di.PerActivity;
import com.georgeren.mvpachitecture.ui.base.MvpPresenter;

/**
 * Created by georgeRen on 2017/9/7.
 */
@PerActivity
public interface MainMvpPresenter <V extends MainMvpView> extends MvpPresenter<V> {
    void onDrawerOptionAboutClick();

    void onDrawerOptionLogoutClick();

    void onDrawerRateUsClick();

    void onDrawerMyFeedClick();

    void onViewInitialized();

    void onCardExhausted();

    void onNavMenuCreated();

}
