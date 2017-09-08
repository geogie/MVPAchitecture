package com.georgeren.mvpachitecture.ui.feed.blogs;

import com.georgeren.mvpachitecture.ui.base.MvpPresenter;

/**
 * Created by georgeRen on 2017/9/8.
 */

public interface BlogMvpPresenter <V extends BlogMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}
