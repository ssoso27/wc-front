package com.uuay.welcare_catcher;

import android.util.Log;

import com.kakao.auth.ISessionCallback;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.exception.KakaoException;

public class SessionCallback implements ISessionCallback {
    // 로그인에 성공한 상태
    @Override
    public void onSessionOpened() {
        requestMe();
    }

    // 로그인에 실패한 상태
    @Override
    public void onSessionOpenFailed(KakaoException exception) {
        Log.e("SessionCallback :: ", "onSessionOpenFailed : " + exception.getMessage());
    }

    // 사용자 정보 요청
    public void requestMe() {
        // 사용자정보 요청 결과에 대한 Callback
        UserManagement.getInstance().me(new MeV2ResponseCallback() {

            // 사용자정보 요청에 성공한 경우,
            @Override
            public void onSuccess(MeV2Response result) {
                APIRequester apiRequester = new APIRequester();
                Log.e("SessionCallback::", "onSuccess");

                Account account = new Account(result.getNickname()
                        , result.getProfileImagePath()
                        , result.getKakaoAccount().getEmail()
                        , "60"
                        , "5");
                GlobalApplication.setCurrentAccount(account);
                apiRequester.join(account);
            }

            // 세션 오픈 실패. 세션이 삭제된 경우,
            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                Log.e("SessionCallback::", "onSessionClosed : " + errorResult.getErrorMessage());
            }
        });
    }
}
