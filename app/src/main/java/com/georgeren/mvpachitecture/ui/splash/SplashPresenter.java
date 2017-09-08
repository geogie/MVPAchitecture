package com.georgeren.mvpachitecture.ui.splash;

import com.georgeren.mvpachitecture.DataManager;
import com.georgeren.mvpachitecture.R;
import com.georgeren.mvpachitecture.ui.base.BasePresenter;
import com.georgeren.mvpachitecture.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by georgeRen on 2017/9/1.
 * 登录的具体p：
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {
    /**
     * 构造：dagger2 实现, 非module实现注入
     * dagger2 注解
     * 参数由module提供：
     * @param dataManager ApplicationModule提供，对db、pre、api管理
     * @param schedulerProvider ActivityModule提供，对rx2的任务调度封装
     * @param compositeDisposable ActivityModule提供，调度控制任务
     */
    @Inject
    public SplashPresenter(DataManager dataManager,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    /**
     * p 和 v 关联
     * splash--》下个界面前逻辑处理
     * 不管有没有登录，必须初始化数据源。
     * @param mvpView v
     */
    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        getMvpView().startSyncService();// 调用空方法，无用

        getCompositeDisposable().add(getDataManager()
                .seedDatabaseQuestions()
                .subscribeOn(getSchedulerProvider().io())// 在io线程中进行数据库操作
                .observeOn(getSchedulerProvider().ui())
                .concatMap(new Function<Boolean, ObservableSource<Boolean>>() {
                    @Override
                    public ObservableSource<Boolean> apply(Boolean aBoolean) throws Exception {// main
                        return getDataManager().seedDatabaseOptions();
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (!isViewAttached()) {// p没有拥有v
                            return;
                        }
                        decideNextActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().onError(R.string.some_error);
                        decideNextActivity();
                    }
                }));


    }

    /**
     * 转场：登录 或 主界面
     */
    private void decideNextActivity() {
        if (getDataManager().getCurrentUserLoggedInMode()
                == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {// 还未登录，跳到登录界面
            getMvpView().openLoginActivity();
        } else {// 已经登录，跳到主界面
            getMvpView().openMainActivity();
        }
    }
}
