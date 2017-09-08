package com.georgeren.mvpachitecture.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.georgeren.mvpachitecture.R;

/**
 * Created by georgeRen on 2017/9/7.
 */

public class AppUtils {
    private AppUtils() {
        // This class is not publicly instantiable
    }

    /**
     * 打开第三方的应用商店或浏览器，查看app详情
     * 根据跳到第三方 根据packageName 来定位应用
     * @param context
     */
    public static void openPlayStoreForApp(Context context) {
        final String appPackageName = context.getPackageName();
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_market_link) + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_google_play_store_link) + appPackageName)));
        }
    }
}
