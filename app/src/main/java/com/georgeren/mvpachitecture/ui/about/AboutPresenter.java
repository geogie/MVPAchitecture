package com.georgeren.mvpachitecture.ui.about;

import com.georgeren.mvpachitecture.DataManager;
import com.georgeren.mvpachitecture.ui.base.BasePresenter;
import com.georgeren.mvpachitecture.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by georgeRen on 2017/9/8.
 */

public class AboutPresenter <V extends AboutMvpView> extends BasePresenter<V>
        implements AboutMvpPresenter<V> {
    @Inject
    public AboutPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

}
