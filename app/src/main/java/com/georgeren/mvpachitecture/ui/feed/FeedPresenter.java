package com.georgeren.mvpachitecture.ui.feed;

import com.georgeren.mvpachitecture.DataManager;
import com.georgeren.mvpachitecture.ui.base.BasePresenter;
import com.georgeren.mvpachitecture.ui.base.MvpView;
import com.georgeren.mvpachitecture.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by georgeRen on 2017/9/8.
 */

public class FeedPresenter <V extends MvpView> extends BasePresenter<V> implements
        FeedMvpPresenter<V> {
    @Inject
    public FeedPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
