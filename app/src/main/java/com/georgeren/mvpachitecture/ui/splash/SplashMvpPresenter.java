package com.georgeren.mvpachitecture.ui.splash;

import com.georgeren.mvpachitecture.di.PerActivity;
import com.georgeren.mvpachitecture.ui.base.MvpPresenter;

/**
 * Created by georgeRen on 2017/9/1.
 * splash的mvp：p，具体操作，
 * splash界面没有什么逻辑操作就不用写内容了，写个空的以后如果有什么需求添加。
 */
@PerActivity
public interface SplashMvpPresenter <V extends SplashMvpView> extends MvpPresenter<V> {
}
