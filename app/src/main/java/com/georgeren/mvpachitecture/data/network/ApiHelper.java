package com.georgeren.mvpachitecture.data.network;

import com.georgeren.mvpachitecture.data.network.model.BlogResponse;
import com.georgeren.mvpachitecture.data.network.model.LoginRequest;
import com.georgeren.mvpachitecture.data.network.model.LoginResponse;
import com.georgeren.mvpachitecture.data.network.model.LogoutResponse;
import com.georgeren.mvpachitecture.data.network.model.OpenSourceResponse;

import io.reactivex.Observable;

/**
 * Created by georgeRen on 2017/9/4.
 */

public interface ApiHelper {
    ApiHeader getApiHeader();

    Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Observable<LogoutResponse> doLogoutApiCall();

    Observable<BlogResponse> getBlogApiCall();

    Observable<OpenSourceResponse> getOpenSourceApiCall();
}
