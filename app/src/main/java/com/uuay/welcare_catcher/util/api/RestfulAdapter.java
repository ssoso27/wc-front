package com.uuay.welcare_catcher.util.api;

import android.annotation.SuppressLint;
import android.util.Log;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestfulAdapter {
    public static final int CONNECT_TIMEOUT = 15;
    public static final int WRITE_TIMEOUT = 15;
    public static final int READ_TIMEOUT = 15;
    private static final String SERVER_URL = "http://54.180.147.7"; //2부터 url뒤에 /를 입력해야 합니다.
    private static OkHttpClient client;
    private static RetrofitAPI retrofitAPI;
    private static CookieManager cookieManager;

    public static CookieManager getCookieManager() { return cookieManager; }

    public synchronized static RetrofitAPI getInstance() {
        if (retrofitAPI == null) {
            //통신로그를 확인하기 위한 부분
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            //쿠키 메니저의 cookie policy를 변경 합니다.
            if (cookieManager == null) {
                cookieManager = new CookieManager();
                cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            }

            //OkHttpClient를 생성합니다.
            client = configureClient(new OkHttpClient().newBuilder()) //인증서 무시
                    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS) //연결 타임아웃 시간 설정
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS) //쓰기 타임아웃 시간 설정
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS) //읽기 타임아웃 시간 설정
                    .cookieJar(new JavaNetCookieJar(cookieManager)) //쿠키메니져 설정
                    .addInterceptor(httpLoggingInterceptor) //http 로그 확인
                    .build();

            //Retrofit 설정
            retrofitAPI = new Retrofit.Builder()
                    .baseUrl(SERVER_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create()) //Json Parser 추가
                    .build().create(RetrofitAPI.class); //인터페이스 연결
        }
        return retrofitAPI;
    }

    /**
     * UnCertificated 허용
     */
    public static OkHttpClient.Builder configureClient(final OkHttpClient.Builder builder) {
        final TrustManager[] certs = new TrustManager[]{new X509TrustManager() {

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkServerTrusted(final X509Certificate[] chain,
                                           final String authType) {
            }

            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkClientTrusted(final X509Certificate[] chain,
                                           final String authType) {
            }
        }};

        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(null, certs, new SecureRandom());
        } catch (final java.security.GeneralSecurityException ex) {
            ex.printStackTrace();
        }

        try {
            final HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @SuppressLint("BadHostnameVerifier")
                @Override
                public boolean verify(final String hostname, final SSLSession session) {
                    return true;
                }
            };

            if (ctx != null) {
                builder.sslSocketFactory(ctx.getSocketFactory(), (X509TrustManager) certs[0]).hostnameVerifier(hostnameVerifier);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }

        return builder;
    }
}