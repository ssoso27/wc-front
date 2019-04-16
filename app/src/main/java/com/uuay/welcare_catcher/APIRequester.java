package com.uuay.welcare_catcher;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIRequester {
    private Retrofit retrofit;
    private RetrofitAPI retrofitAPI;
    private Call<String> call;

    public APIRequester() {
        this.setRetrofit();
    }

    public void join(Account account) {
        call = retrofitAPI.join(account);
        call.enqueue(retrofitCallback);
    }

    private Callback<String> retrofitCallback = new Callback<String>() {

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

    private void setRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://54.180.147.7")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitAPI = retrofit.create(RetrofitAPI.class);
    }
}
