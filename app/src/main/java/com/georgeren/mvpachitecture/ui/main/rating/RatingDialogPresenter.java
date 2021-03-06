package com.georgeren.mvpachitecture.ui.main.rating;

import com.georgeren.mvpachitecture.DataManager;
import com.georgeren.mvpachitecture.R;
import com.georgeren.mvpachitecture.ui.base.BasePresenter;
import com.georgeren.mvpachitecture.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by georgeRen on 2017/9/7.
 */

public class RatingDialogPresenter <V extends RatingDialogMvpView> extends BasePresenter<V>
        implements RatingDialogMvpPresenter<V> {

    private boolean isRatingSecondaryActionShown = false;

    @Inject
    public RatingDialogPresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onRatingSubmitted(final float rating, String message) {

        if (rating == 0) {
            getMvpView().showMessage(R.string.rating_not_provided_error);
            return;
        }

        if (!isRatingSecondaryActionShown) {
            if (rating == 5) {// 5颗星
                getMvpView().showPlayStoreRatingView();
                getMvpView().hideSubmitButton();
                getMvpView().disableRatingStars();
            } else {
                getMvpView().showRatingMessageView();
            }
            isRatingSecondaryActionShown = true;
            return;
        }

        getMvpView().showLoading();

        //for demo
        getMvpView().hideLoading();
        getMvpView().showMessage(R.string.rating_thanks);
        getMvpView().dismissDialog();

    }

    private void sendRatingDataToServerInBackground(float rating) {

    }

    @Override
    public void onCancelClicked() {
        getMvpView().dismissDialog();
    }

    @Override
    public void onLaterClicked() {
        getMvpView().dismissDialog();
    }

    @Override
    public void onPlayStoreRatingClicked() {
        getMvpView().openPlayStoreForRating();
        sendRatingDataToServerInBackground(5);
        getMvpView().dismissDialog();
    }
}