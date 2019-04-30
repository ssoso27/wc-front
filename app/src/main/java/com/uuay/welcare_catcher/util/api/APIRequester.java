package com.uuay.welcare_catcher.util.api;

import android.util.Log;

import com.uuay.welcare_catcher.model.Account;
import com.uuay.welcare_catcher.model.Facility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIRequester {
    private Retrofit retrofit;
    private RetrofitAPI retrofitAPI;
    private Call<String> stringCall;
    private Call<List<Facility>> facilityListCall;
    private ArrayList<Facility> facilities;

    public APIRequester() {
        this.setRetrofit();
    }

    public void join(Account account) {
        stringCall = retrofitAPI.join(account);
        stringCall.enqueue(stringCallback);
    }

    public void findFacilities(String keyword, int size, int page) {
        facilityListCall = retrofitAPI.findFacilities(keyword, size, page);
        facilityListCall.enqueue(facilityListCallback);
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

    private Callback<List<Facility>> facilityListCallback = new Callback<List<Facility>>() {

        @Override
        public void onResponse(Call<List<Facility>> call, Response<List<Facility>> response) {
            int code = response.code();
            Log.d("onResponse", String.valueOf(code));

            if(response.isSuccessful()) {
                ArrayList<Facility> list = (ArrayList<Facility>) response.body();
                if (list != null) {
                    facilities = list;
                }
            }
        }

        @Override
        public void onFailure(Call<List<Facility>> call, Throwable t) {
            Log.d("onFailure", "으나야사랑해ㅜ");
            t.printStackTrace();
        }
    };

    private void setRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://54.180.147.7")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitAPI = retrofit.create(RetrofitAPI.class);
    }

    public ArrayList<Facility> getFacilities() {
        return facilities;
    }
}
