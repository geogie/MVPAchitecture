package com.georgeren.mvpachitecture.ui.feed.opensource;

import com.georgeren.mvpachitecture.ui.base.MvpPresenter;

/**
 * Created by georgeRen on 2017/9/8.
 */

public interface OpenSourceMvpPresenter <V extends OpenSourceMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}

