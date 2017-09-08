package com.georgeren.mvpachitecture.di.module;

import android.app.Application;
import android.content.Context;

import com.georgeren.mvpachitecture.BuildConfig;
import com.georgeren.mvpachitecture.DataManager;
import com.georgeren.mvpachitecture.R;
import com.georgeren.mvpachitecture.data.AppDataManager;
import com.georgeren.mvpachitecture.data.db.AppDbHelper;
import com.georgeren.mvpachitecture.data.db.DbHelper;
import com.georgeren.mvpachitecture.data.network.ApiHeader;
import com.georgeren.mvpachitecture.data.network.ApiHelper;
import com.georgeren.mvpachitecture.data.network.AppApiHelper;
import com.georgeren.mvpachitecture.data.prefs.AppPreferencesHelper;
import com.georgeren.mvpachitecture.data.prefs.PreferencesHelper;
import com.georgeren.mvpachitecture.di.ApiInfo;
import com.georgeren.mvpachitecture.di.ApplicationContext;
import com.georgeren.mvpachitecture.di.DatabaseInfo;
import com.georgeren.mvpachitecture.di.PreferenceInfo;
import com.georgeren.mvpachitecture.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by georgeRen on 2017/9/1.
 * 提供：
 * 全局，app独一份，单例
 * 字体、管理（db，pre，api），
 */
@Module
public class ApplicationModule {
    private final Application mApplication;// application

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    /**
     * context
     * @return
     */
    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    /**
     * application
     * @return
     */
    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    /**
     * app提供
     * 单例
     *
     * @param appDataManager
     * @return
     */
    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    /**
     * 自定义字体
     * @return
     */
    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

}
