package com.georgeren.mvpachitecture.di.component;

import com.georgeren.mvpachitecture.di.PerActivity;
import com.georgeren.mvpachitecture.di.module.ActivityModule;
import com.georgeren.mvpachitecture.ui.about.AboutFragment;
import com.georgeren.mvpachitecture.ui.feed.FeedActivity;
import com.georgeren.mvpachitecture.ui.feed.blogs.BlogFragment;
import com.georgeren.mvpachitecture.ui.feed.opensource.OpenSourceFragment;
import com.georgeren.mvpachitecture.ui.login.LoginActivity;
import com.georgeren.mvpachitecture.ui.main.MainActivity;
import com.georgeren.mvpachitecture.ui.main.rating.RateUsDialog;
import com.georgeren.mvpachitecture.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by georgeRen on 2017/9/1.
 * 注入：自定义 PerActivity 局部单例模式（共享）
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity activity);
    void inject(LoginActivity activity);
    void inject(MainActivity activity);
    void inject(RateUsDialog dialog);
    void inject(AboutFragment fragment);
    void inject(FeedActivity activity);
    void inject(OpenSourceFragment fragment);
    void inject(BlogFragment fragment);
}
