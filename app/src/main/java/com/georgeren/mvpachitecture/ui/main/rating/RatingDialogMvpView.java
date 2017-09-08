package com.georgeren.mvpachitecture.ui.main.rating;

import com.georgeren.mvpachitecture.ui.base.DialogMvpView;

/**
 * Created by georgeRen on 2017/9/7.
 */

public interface RatingDialogMvpView extends DialogMvpView {

    void openPlayStoreForRating();

    void showPlayStoreRatingView();

    void showRatingMessageView();

    void hideSubmitButton();

    void disableRatingStars();

    void dismissDialog();

}
