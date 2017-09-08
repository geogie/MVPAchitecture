package com.georgeren.mvpachitecture.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.georgeren.mvpachitecture.R;
import com.georgeren.mvpachitecture.ui.base.BaseActivity;
import com.georgeren.mvpachitecture.ui.login.LoginActivity;
import com.georgeren.mvpachitecture.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by georgeRen on 2017/9/1.
 * 欢迎界面
 */

public class SplashActivity extends BaseActivity implements SplashMvpView{

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;// presenter dagger2 非module注入 类中单例

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);// 共享 dagger2  SplashActivity 拥有一个ActivityComponent对象，
        // 所以SplashMvpPresenter被注入就是SplashActivity内部单例，例如：再注入一个SplashMvpPresenter。则两个SplashMvpPresenter是同一个对象，内部共享。

        setUnBinder(ButterKnife.bind(this));// butterKnife 绑定

        mPresenter.onAttach(SplashActivity.this);// p 关联 v
    }

    /**
     * Making the screen wait so that the  branding can be shown
     * 打开登录界面
     */
    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    /**
     * 打开主界面
     */
    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void startSyncService() {
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();// p 解除 v 的关联
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }
}
