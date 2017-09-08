package com.georgeren.mvpachitecture;

import com.georgeren.mvpachitecture.data.db.DbHelper;
import com.georgeren.mvpachitecture.data.network.ApiHelper;
import com.georgeren.mvpachitecture.data.prefs.PreferencesHelper;

import io.reactivex.Observable;

/**
 * Created by georgeRen on 2017/9/1.
 * 抽出
 * 管理：db,pre,api
 */

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    void updateApiHeader(Long userId, String accessToken);

    void setUserAsLoggedOut();

    Observable<Boolean> seedDatabaseQuestions();

    Observable<Boolean> seedDatabaseOptions();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
