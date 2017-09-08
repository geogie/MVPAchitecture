package com.georgeren.mvpachitecture.ui.feed.blogs;

import com.georgeren.mvpachitecture.data.network.model.BlogResponse;
import com.georgeren.mvpachitecture.ui.base.MvpView;

import java.util.List;

/**
 * Created by georgeRen on 2017/9/8.
 */

public interface BlogMvpView extends MvpView {
    void updateBlog(List<BlogResponse.Blog> blogList);
}
