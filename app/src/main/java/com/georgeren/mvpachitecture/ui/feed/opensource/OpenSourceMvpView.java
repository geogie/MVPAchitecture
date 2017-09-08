package com.georgeren.mvpachitecture.ui.feed.opensource;

import com.georgeren.mvpachitecture.data.network.model.OpenSourceResponse;
import com.georgeren.mvpachitecture.ui.base.MvpView;

import java.util.List;

/**
 * Created by georgeRen on 2017/9/8.
 */

public interface OpenSourceMvpView extends MvpView {

    void updateRepo(List<OpenSourceResponse.Repo> repoList);
}

