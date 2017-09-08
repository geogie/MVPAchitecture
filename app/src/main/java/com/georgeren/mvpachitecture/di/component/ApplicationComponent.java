package com.georgeren.mvpachitecture.di.component;

import android.app.Application;
import android.content.Context;

import com.georgeren.mvpachitecture.DataManager;
import com.georgeren.mvpachitecture.MvpApp;
import com.georgeren.mvpachitecture.di.ApplicationContext;
import com.georgeren.mvpachitecture.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by georgeRen on 2017/9/1.
 * 单例:全局component interface抽出
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    /**
     * 注入
     * @param app
     */
    void inject(MvpApp app);

    /**
     * context
     * @return
     */
    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
