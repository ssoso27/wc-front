package com.uuay.welcare_catcher;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.kakao.auth.KakaoSDK;

public class GlobalApplication extends Application {
    private static volatile GlobalApplication instance = null;
    private static final String NANUM_BARUN_GOTHIC_TTF = "fonts/NanumBarunGothic.ttf";
    public static Typeface canaroExtraBold;
    private static Account currentAccount;

    public static void setCurrentAccount(Account account) {
        currentAccount = account;
    }

    public static Account getCurrentAccount() {
        return currentAccount;
    }

    public static Context getGlobalApplicationContext() {
        if(instance == null)
            throw new IllegalStateException("this application does not inherit com.kakao.GlobalApplication");
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initTypeface();

        instance = this;
        KakaoSDK.init(new KakaoSDKAdapter());
    }

    private void initTypeface() {
        canaroExtraBold = Typeface.createFromAsset(getAssets(), NANUM_BARUN_GOTHIC_TTF);

    }
}
