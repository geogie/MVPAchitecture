package com.georgeren.mvpachitecture.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.georgeren.mvpachitecture.data.network.model.BlogResponse;
import com.georgeren.mvpachitecture.data.network.model.OpenSourceResponse;
import com.georgeren.mvpachitecture.di.ActivityContext;
import com.georgeren.mvpachitecture.di.PerActivity;
import com.georgeren.mvpachitecture.ui.about.AboutMvpPresenter;
import com.georgeren.mvpachitecture.ui.about.AboutMvpView;
import com.georgeren.mvpachitecture.ui.about.AboutPresenter;
import com.georgeren.mvpachitecture.ui.feed.FeedMvpPresenter;
import com.georgeren.mvpachitecture.ui.feed.FeedMvpView;
import com.georgeren.mvpachitecture.ui.feed.FeedPagerAdapter;
import com.georgeren.mvpachitecture.ui.feed.FeedPresenter;
import com.georgeren.mvpachitecture.ui.feed.blogs.BlogAdapter;
import com.georgeren.mvpachitecture.ui.feed.blogs.BlogMvpPresenter;
import com.georgeren.mvpachitecture.ui.feed.blogs.BlogMvpView;
import com.georgeren.mvpachitecture.ui.feed.blogs.BlogPresenter;
import com.georgeren.mvpachitecture.ui.feed.opensource.OpenSourceAdapter;
import com.georgeren.mvpachitecture.ui.feed.opensource.OpenSourceMvpPresenter;
import com.georgeren.mvpachitecture.ui.feed.opensource.OpenSourceMvpView;
import com.georgeren.mvpachitecture.ui.feed.opensource.OpenSourcePresenter;
import com.georgeren.mvpachitecture.ui.login.LoginMvpPresenter;
import com.georgeren.mvpachitecture.ui.login.LoginMvpView;
import com.georgeren.mvpachitecture.ui.login.LoginPresenter;
import com.georgeren.mvpachitecture.ui.main.MainMvpPresenter;
import com.georgeren.mvpachitecture.ui.main.MainMvpView;
import com.georgeren.mvpachitecture.ui.main.MainPresenter;
import com.georgeren.mvpachitecture.ui.main.rating.RatingDialogMvpPresenter;
import com.georgeren.mvpachitecture.ui.main.rating.RatingDialogMvpView;
import com.georgeren.mvpachitecture.ui.main.rating.RatingDialogPresenter;
import com.georgeren.mvpachitecture.ui.splash.SplashMvpPresenter;
import com.georgeren.mvpachitecture.ui.splash.SplashMvpView;
import com.georgeren.mvpachitecture.ui.splash.SplashPresenter;
import com.georgeren.mvpachitecture.utils.rx.AppSchedulerProvider;
import com.georgeren.mvpachitecture.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by georgeRen on 2017/9/1.
 * module:提供依赖
 */
@Module
public class ActivityModule {
    /**
     * activity
     */
    private AppCompatActivity mActivity;

    /**
     * baseActivity注册模块
     *
     * @param activity
     */
    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    /**
     * context
     *
     * @return
     */
    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    /**
     * activity
     *
     * @return
     */
    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    /**
     * 提供给activity：
     * 第三方的初始化
     * 调度控制任务
     *
     * @return
     */
    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    /**
     * 对rx2的任务调度封装
     *
     * @return
     */
    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    /**
     * 要构造的对象，并提供依赖
     * PerActivity 局部单例 SplashPresenter
     *
     * @param presenter
     * @return
     */
    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    /**
     * module部分：利用module + component 来实现
     * 初始化 login 的 presenter 局部单例
     *
     * @param presenter
     * @return
     */
    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }
    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }
    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }


    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }
    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }
}
