package com.georgeren.mvpachitecture;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.georgeren.mvpachitecture.di.component.ApplicationComponent;
import com.georgeren.mvpachitecture.di.component.DaggerApplicationComponent;
import com.georgeren.mvpachitecture.di.module.ApplicationModule;
import com.georgeren.mvpachitecture.utils.AppLogger;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by georgeRen on 2017/9/1.
 * mApplicationComponent：全局只有一个mApplicationComponent被创建并且被Singleton修饰，则全局app内单例。通过mApplicationComponent注册的都是全局单例
 */

public class MvpApp extends Application{
    @Inject
    DataManager mDataManager;// 数据库注入
    @Inject
    CalligraphyConfig mCalligraphyConfig;// 字体注入
    private ApplicationComponent mApplicationComponent;// 全局单例 dagger2 初始化component app唯一拥有ApplicationComponent


    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());// logger

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    /**
     * baseActivity dagger2
     * @return
     */
    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
