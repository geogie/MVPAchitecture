package com.georgeren.mvpachitecture.ui.base;

/**
 * Created by georgeRen on 2017/9/1.
 */

import com.androidnetworking.error.ANError;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 *
 * mvp的P：顶层抽取
 */
public interface MvpPresenter <V extends MvpView>{
    /**
     * p 关联 v
     * @param mvpView v
     */
    void onAttach(V mvpView);

    /**
     * 解除 p 和 v 关联
     */
    void onDetach();

    void handleApiError(ANError error);

    void setUserAsLoggedOut();
}
