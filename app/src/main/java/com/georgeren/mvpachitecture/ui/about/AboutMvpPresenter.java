package com.georgeren.mvpachitecture.ui.about;

import com.georgeren.mvpachitecture.di.PerActivity;
import com.georgeren.mvpachitecture.ui.base.MvpPresenter;

/**
 * Created by georgeRen on 2017/9/8.
 */
@PerActivity
public interface AboutMvpPresenter <V extends AboutMvpView> extends MvpPresenter<V> {
}
