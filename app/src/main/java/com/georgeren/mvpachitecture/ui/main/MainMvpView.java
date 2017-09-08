package com.georgeren.mvpachitecture.ui.main;

import com.georgeren.mvpachitecture.data.db.model.Question;
import com.georgeren.mvpachitecture.ui.base.MvpView;

import java.util.List;

/**
 * Created by georgeRen on 2017/9/7.
 */

public interface MainMvpView extends MvpView {
    void openLoginActivity();

    void showAboutFragment();

    void refreshQuestionnaire(List<Question> questionList);

    void reloadQuestionnaire(List<Question> questionList);

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateUserProfilePic(String currentUserProfilePicUrl);

    void updateAppVersion();

    void showRateUsDialog();

    void openMyFeedActivity();

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();

}
