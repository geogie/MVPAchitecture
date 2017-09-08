package com.georgeren.mvpachitecture.ui.main.rating;

import com.georgeren.mvpachitecture.ui.base.MvpPresenter;

/**
 * Created by georgeRen on 2017/9/7.
 */

public interface RatingDialogMvpPresenter <V extends RatingDialogMvpView> extends MvpPresenter<V> {

    void onRatingSubmitted(float rating, String message);

    void onCancelClicked();

    void onLaterClicked();

    void onPlayStoreRatingClicked();
}