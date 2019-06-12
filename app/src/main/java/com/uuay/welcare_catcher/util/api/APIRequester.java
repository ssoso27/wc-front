package com.uuay.welcare_catcher.util.api;

import android.util.Log;

import com.uuay.welcare_catcher.GlobalApplication;
import com.uuay.welcare_catcher.model.Account;
import com.uuay.welcare_catcher.model.Facility;
import com.uuay.welcare_catcher.model.RequestLogin;
import com.uuay.welcare_catcher.model.WelfareService;
import com.uuay.welcare_catcher.util.LocalCookie;

import java.io.IOException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIRequester {
    private RetrofitAPI retrofitAPI;

    public APIRequester() {
        retrofitAPI = RestfulAdapter.getInstance();
    }

    public void join(Account account) {
        Call<String> stringCall = retrofitAPI.join(account);
        stringCall.enqueue(stringCallback);
    }

    public boolean login(String email, String password) {
        boolean isLogin = false;

        try {
            RequestLogin requestLogin = new RequestLogin(email, password);
            Call<Account> call = retrofitAPI.login(requestLogin);
            Response<Account> response = call.execute();

            if (response.isSuccessful()) {
                // 캐시 저장
                isLogin = true;
                GlobalApplication.setCurrentAccount(response.body());

                CookieManager cookieManager = RestfulAdapter.getCookieManager();
                List<HttpCookie> cookieList = cookieManager.getCookieStore().getCookies();
                LocalCookie localCookie = LocalCookie.getInstance();
                for(HttpCookie c : cookieList) {
                    localCookie.put(c.getName(), c.getValue());
                }
                localCookie.put("email", GlobalApplication.getCurrentAccount().getEmail());
                localCookie.put("isLogin", isLogin+"");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return isLogin;
    }

    public boolean duplicateEmail(String email) {
        boolean isDuplicate = true;

        try {
            Call<String> call = retrofitAPI.duplicateEmail(email);
            Response<String> response = call.execute();

            if (response.isSuccessful()) {
                isDuplicate = Boolean.parseBoolean(response.body());
            }

            return isDuplicate;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public ArrayList<Facility> findFacilities(String keyword, int size, int page) {
        ArrayList<Facility> facilities = null;

        try {
            Call<List<Facility>> call = retrofitAPI.findFacilities(keyword, size, page);
            Response<List<Facility>> response = call.execute();

            if(response.isSuccessful()) {
                ArrayList<Facility> list = (ArrayList<Facility>) response.body();
                if (list != null) {
                    facilities = list;
                }
            }

            return facilities;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Callback<String> stringCallback = new Callback<String>() {

        @Override
        public void onResponse(Call<String> call, Response<String> response) {
            int code = response.code();
            Log.d("onResponse", "잘받았나봥");
            Log.d("onResponse", String.valueOf(code));
        }

        @Override
        public void onFailure(Call<String> call, Throwable t) {
            Log.d("onFailure", "으나야사랑해ㅜ");
            t.printStackTrace();
        }
    };

    public ArrayList<WelfareService> findServices(String keyword, int size, int page) {
        ArrayList<WelfareService> services = null;

        try {
            Call<List<WelfareService>> call = retrofitAPI.findServices(keyword, size, page);
            Response<List<WelfareService>> response = call.execute();

            if(response.isSuccessful()) {
                ArrayList<WelfareService> list = (ArrayList<WelfareService>) response.body();
                if (list != null) {
                    services = list;
                    Log.d("궁금해", list.get(0).getName());
                    Log.d("2", list.get(0).getRegistedAt().toString());
                }
            }

            return services;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<WelfareService> finda(String disability_grade, String age_group, String disability_type) {
        ArrayList<WelfareService> services = null;

        try {
            Call<List<WelfareService>> call = retrofitAPI.finda(disability_grade, age_group, disability_type);
            Response<List<WelfareService>> response = call.execute();

            if(response.isSuccessful()) {
                ArrayList<WelfareService> list = (ArrayList<WelfareService>) response.body();
                if (list != null) {
                    services = list;
                    Log.d("궁금해", list.get(0).getName());
                    Log.d("2", list.get(0).getRegistedAt().toString());
                }
            }

            return services;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
