package com.uuay.welcare_catcher.util.api;

import android.util.Log;
import android.widget.Toast;

import com.uuay.welcare_catcher.model.Account;
import com.uuay.welcare_catcher.model.Facility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIRequester {
    private RetrofitAPI retrofitAPI;

    public APIRequester() {
        retrofitAPI = RestfulAdapter.getInstance();
    }

    public void join(Account account) {
        Call<String> stringCall = retrofitAPI.join(account);
        stringCall.enqueue(stringCallback);
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
}
